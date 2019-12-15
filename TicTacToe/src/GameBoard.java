import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameBoard extends JFrame {
    private ArrayList<String> savedGameList;
    private JButton[] boardButtons = new JButton[9];
    private JButton resetBtn = new JButton("Reset");
    private JButton saveBtn;
    private JButton backBtn;
    private boolean hardMode;

    private final Game game;
    private final JFrame frame = new JFrame("CS151 Tic Tac Toe");
    private final AI opponent = new AI();

    private GameLogic gameLogic;

    /**
     * Passing the game object when initializing this class.
     * @param game Game class constructor.
     */
    public GameBoard(Game game) {
        this.savedGameList = new ArrayList<>();
        this.backBtn = new JButton("Back");
        this.saveBtn = new JButton("Save");
        this.game = game;
        initialize();
    }

    /**
     * Setting the mode based on the user's selection.
     * @param hardMode Hard mode of the game
     */
    public void setHardMode(boolean hardMode) {
        this.hardMode = hardMode;
    }

    /**
     * Passing frame to Game Controller class.
     * @return frame of this class.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Initialize the board and configure all the components to the JFrame.
     */
    public void initialize() {

        gameLogic = new GameLogic('X', 'O');
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gameBoard = new JPanel(new GridLayout(3, 3));
        frame.add(mainPanel);

        gameBoard.setPreferredSize(new Dimension(320, 320));


        mainPanel.add(gameBoard, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(resetBtn);
        buttonPanel.add(saveBtn);
        buttonPanel.add(backBtn);

        mainPanel.add(buttonPanel);

        //Initialize all the buttons
        for (int i = 0; i < 9; i++) {
            boardButtons[i] = new JButton();
            boardButtons[i].setBackground(Color.BLACK);
            boardButtons[i].setText("");
            boardButtons[i].setVisible(true);

            gameBoard.add(boardButtons[i]);
            boardButtons[i].addActionListener(new buttonsActionExecute());
            boardButtons[i].setFont(new Font("Tahoma", Font.BOLD, 75));
        }

        resetBtn.addActionListener(new buttonsActionExecute());
        handleSaveEvent();
        handleBackEvent();
    }

    /**
     * Inner class that handles ActionEvent.
     */
    private class buttonsActionExecute implements ActionListener {
        public void actionPerformed(ActionEvent action) {
            if (hardMode) {
                hardMode(action);
            } else {
                easyMode(action);
            }
        }
    }

    /**
     * Setting the hard mode game. The game automatically generates randomly the valid moves.
     * @param action ActionEvent of Mouse click.
     */
    private void hardMode(ActionEvent action) {
        int computerMove;
        //Display the human's piece on the buttons
        for (int i = 0; i < 9; i++) {
            if (action.getSource() == boardButtons[i] && gameLogic.isPositionAvailable(i)) {
                //human turn
                gameLogic.generateNewPiece(gameLogic.getHuman(), i);
                boardButtons[i].setText(Character.toString(gameLogic.getHuman()));
                boardButtons[i].setForeground(Color.BLUE);

                //if human has won, end game
                if (gameLogic.isWinner(gameLogic.getHuman())) {
                    gameOver();
                    break;
                }

                //HardAI turn
                computerMove = opponent.getIndexOfBestMove(gameLogic);

                //if AI has a legal move
                if (computerMove != -1) {
                    gameLogic.generateNewPiece(gameLogic.getOpponent(), computerMove);
                    boardButtons[computerMove].setText(Character.toString(gameLogic.getOpponent()));
                    boardButtons[computerMove].setForeground(Color.RED);

                    //if AI has won, end game
                    if (gameLogic.isWinner(gameLogic.getOpponent())) {
                        gameOver();
                        //if game over, stop loop
                        break;
                    }
                } else {
                    gameOver();
                    //if game over, stop loop
                    break;
                }
            }
        }
        reset(action);
    }

    /**
     * When the reset button is clicked, reset the board and the display.
     * @param action ActionEvent of Mouse click.
     */
    private void reset(ActionEvent action) {
        if (action.getSource() == resetBtn) {
            for (int i = 0; i < 9; i++) {
                boardButtons[i].setText("");
                boardButtons[i].setEnabled(true);
                boardButtons[i].updateUI();
                frame.setTitle("CS151 Team-2 Tic Tac Toe");
            }
            gameLogic.reset();
        }
    }

    /**
     * When the back button is clicked, reset the board and the display.
     */
    public void reset() {
        for (int i = 0; i < 9; i++) {
            boardButtons[i].setText("");
            boardButtons[i].setEnabled(true);
            boardButtons[i].updateUI();
            frame.setTitle("CS151 Team-2 Tic Tac Toe");
        }
        gameLogic.reset();
    }


    /**
     * Setting the easy mode game. The game automatically generates randomly the valid moves.
     * @param action ActionEvent of Mouse click.
     */
    private void easyMode(ActionEvent action) {
        int computerMove;

        //Display the human's piece on the buttons
        for (int i = 0; i < 9; i++) {
            if (action.getSource() == boardButtons[i] && gameLogic.isPositionAvailable(i)) {
                //human turn
                gameLogic.generateNewPiece(gameLogic.getHuman(), i);
                boardButtons[i].setText(Character.toString(gameLogic.getHuman()));
                boardButtons[i].setForeground(Color.BLUE);

                //if human has won, end game
                if (gameLogic.isWinner(gameLogic.getHuman())) {
                    gameOver();
                    break;
                }

                //HardAI turn
                computerMove = opponent.getRandomMove(gameLogic);

                //if AI has a legal move
                if (computerMove != -1) {
                    gameLogic.generateNewPiece(gameLogic.getOpponent(), computerMove);
                    boardButtons[computerMove].setText(Character.toString(gameLogic.getOpponent()));
                    boardButtons[computerMove].setForeground(Color.RED);

                    //if AI has won, end game
                    if (gameLogic.isWinner(gameLogic.getOpponent())) {
                        gameOver();
                        //if game over, stop loop
                        break;
                    }
                } else {
                    gameOver();
                    //if game over, stop loop
                    break;
                }
            }
        }
        reset(action);
    }

    /**
     * When the game is over, display any winners in the title.
     */
    private void gameOver() {
        for (int i = 0; i < 9; i++) {
            boardButtons[i].setEnabled(false);
        }
        if (gameLogic.isWinner(gameLogic.getHuman())) {
            JOptionPane.showMessageDialog(frame, "Congratulation! You Win!");
            frame.setTitle("Human Being Win ");
        } else if (gameLogic.isWinner(gameLogic.getOpponent())) {
            frame.setTitle("AI Wins");
            JOptionPane.showMessageDialog(frame, "Bad luck. You Lose.");

        } else {
            JOptionPane.showMessageDialog(frame, "Draw.");
            frame.setTitle("IT'S A DRAW");
        }
    }

    /**
     * Handling the event of save button.
     */
    private void handleSaveEvent() {
        saveBtn.addActionListener(e -> {
            StringBuilder steps = new StringBuilder();
            for (int i = 0; i < boardButtons.length; i++) {
                if (boardButtons[i].getText().equals("")) {
                    steps.append(".");
                } else {
                    steps.append(boardButtons[i].getText());
                }
            }
            savedGameList.add(steps.toString());
            game.setSavedGameList(savedGameList);
            frame.setVisible(false);
            game.setState("menu");
        });
    }

    /**
     * Handling the event of back button.
     */
    private void handleBackEvent() {
        for (int i = 0; i < 9; i++) {
            boardButtons[i].setText("");
            boardButtons[i].setEnabled(true);
            boardButtons[i].updateUI();
        }
        gameLogic.reset();

        backBtn.addActionListener(e -> {
            game.setState("menu");
            frame.setVisible(false);
        });

    }

    /**
     * Precondition checking whether there is a game to load.
     *
     * @param index index of the game.
     * @return the index is valid or not.
     */
    private boolean isValid(int index) {
        return index >= 0;
    }

    /**
     * Loading the game based on the user's selection.
     *
     * @param index index of the game in the list.
     * @precondition isValid(index)
     */
    public void loadGame(int index) {
        assert (isValid(index)) : "There is no game to load.";
        String str = savedGameList.get(index);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'X') {
                boardButtons[i].setText("X");
                boardButtons[i].setForeground(Color.BLUE);
            } else if (str.charAt(i) == 'O') {
                boardButtons[i].setText("O");
                boardButtons[i].setForeground(Color.RED);
            } else {
                boardButtons[i].setText("");
                boardButtons[i].setEnabled(true);
            }
        }
        frame.setVisible(true);
    }
}
