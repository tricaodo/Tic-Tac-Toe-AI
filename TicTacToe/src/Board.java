import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JFrame {

    private ArrayList<String> savedGameList;
    private JButton[][] cells;
    private JButton saveBtn;
    private JButton backBtn;

    private boolean isGameOver;
    private String token;

    private final int DIMENSION;
    private final Game game;

    public Board(Game game) {
        // create the panel for the board.
        cells = new JButton[3][3];
        init();

        this.savedGameList = new ArrayList<>();
        this.game = game;

        backBtn = new JButton("Back");
        saveBtn = new JButton("Save");

        handleBackEvent();
        handleSaveEvent();

        add(saveBtn, BorderLayout.NORTH);
        add(backBtn, BorderLayout.CENTER);

        isGameOver = false;
        token = "X";

        DIMENSION = 140;

    }

    /**
     * Handling the event of save button.
     */
    private void handleSaveEvent(){
        saveBtn.addActionListener(e -> {
            StringBuilder steps = new StringBuilder();
            for(int i = 0; i < cells.length; i++){
                for(int j = 0; j < cells[i].length; j++){
                    JButton button = cells[i][j];
                    if(button.getText().equals("")){
                        steps.append(".");
                    }else {
                        steps.append(button.getText());
                    }
                }
            }
            savedGameList.add(steps.toString());
            game.setSavedGameList(savedGameList);
            this.setVisible(false);
            game.setState("menu");
        });
    }

    public void loadGame(int index){
        int i = 0;
        int j = 0;
        String str = savedGameList.get(index);
        System.out.println("str");
        for(int count = 0; count < str.length(); count++){
            if(j % 3 == 0 && j != 0){
                j = 0;
                i++;
            }
            if(str.charAt(count) == 'X'){
                cells[i][j].setText("X");
                cells[i][j].setEnabled(false);
            }else if(str.charAt(count) == 'O'){
                cells[i][j].setText("O");
                cells[i][j].setEnabled(false);
            }else{
                cells[i][j].setText("");
                cells[i][j].setEnabled(true);
            }
            j++;
        }
        isGameOver = isWon();
    }

    /**
     * Handling the event of back button.
     */
    private void handleBackEvent(){
        backBtn.addActionListener(e -> {
            game.setState("menu");
            this.setVisible(false);
        });
    }

    /**
     * Initialize the board and setting the panel for the board.
     */
    private void init(){

        Dimension dimension = new Dimension(DIMENSION, DIMENSION);
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        panel.setPreferredSize(new Dimension(440, 440));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                panel.add(cells[row][col] = new JButton(""));
                cells[row][col].setPreferredSize(dimension);
                int finalRow = row;
                int finalCol = col;
                cells[row][col].addActionListener(e -> {
                    mouseClickedEvent(finalRow, finalCol);
                    cells[finalRow][finalCol].setEnabled(false);
                });
            }
        }
        isGameOver = isWon();
        add(panel, BorderLayout.SOUTH);
    }

    public void reset(){
        token = "X";
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col].setText("");
                cells[row][col].setEnabled(true);
                cells[row][col].updateUI();
            }
        }
        isGameOver = isWon();
    }

    /**
     * Checking and setting the UI board
     * @param row nth row
     * @param col nth col
     */
    public void mouseClickedEvent(int row, int col) {
        if (!isGameOver) {
            // Check game status
            if (cells[row][col].getText().equals("")) {
                cells[row][col].setText(token);
                isGameOver = isWon();
                token = (token.equals("X")) ? "O" : "X";
                easyMode();
                isGameOver = isWon();
            }
        }
    }


    /**
     * Check if same character (X or O) on the same row.
     *
     * @return true if same character(X or O) on the row. Otherwise, false
     */
    private boolean checkRows() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][0].getText().equals( cells[i][1].getText())
                    && cells[i][1].getText().equals(cells[i][2].getText())
                    && !cells[i][0].getText().equals("")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if same character (X or O) on the same column.
     *
     * @return true if same character(X or O) on the column. Otherwise, false
     */
    private boolean checkCols() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[0][i].getText().equals(cells[1][i].getText())
                    && cells[1][i].getText().equals(cells[2][i].getText())
                    && !cells[0][i].getText().equals("")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if same character (X or O) on the same diagonal.
     *
     * @return true if same character(X or O) on the diagonal. Otherwise, false
     */
    private boolean checkDiagonals() {
        if (cells[0][0].getText().equals(cells[1][1].getText()) &&
                cells[1][1].getText().equals(cells[2][2].getText()) &&
                !cells[0][0].getText().equals("")) {
            return true;
        }
        if (cells[2][0].getText().equals(cells[1][1].getText()) &&
                cells[1][1].getText().equals(cells[0][2].getText()) &&
                !cells[2][0].getText().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * Check either rows, cols, or diagonals were filled with same character or not.
     *
     * @return true if same character on one of them (rows, cols, diagonals), otherwise false.
     */
    public boolean isWon() {
        return checkCols() || checkRows() || checkDiagonals();
    }

    /**
     * Computer automatically plays after the user's turn.
     */
    private void easyMode() {
        while (!isGameOver) {
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);
            if (cells[row][col].getText().equals("")) {
                cells[row][col].setText(token);
                cells[row][col].setEnabled(false);
                token = (token.equals("X")) ? "O" : "X";
                break;
            }

        }
    }

    private void hardMode() {

    }

}