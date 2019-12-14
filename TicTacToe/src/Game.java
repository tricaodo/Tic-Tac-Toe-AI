import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    private final Menu menu;
    private final Mode mode;
    private final GameBoard gameBoard;
    private final GameHistory gameHistory;
    private String state = "menu";
    private List<String> savedGameList;
    private int gameIndex = -1;

    /**
     * Initialize all the classes.
     */
    public Game() {
        menu = new Menu(this);
        mode = new Mode(this);
        gameBoard = new GameBoard(this);
        gameHistory = new GameHistory(this);
        savedGameList = new ArrayList<>();
        changeScene();
    }

    /**
     * Setting the configuration for this frame.
     */
    public void configureFrame(JFrame frame) {
        frame.setTitle("Tic-Tac-Toe Game");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Setting the state in order to display the scene.
     *
     * @param str string state.
     */
    public void setState(String str) {
        state = str;
        changeScene();
    }

    /**
     * Changing the scene based on the user's selection.
     */
    public void changeScene() {
        if (state.equals("mode")) {
            configureFrame(mode);
        } else if (state.equals("menu")) {
            configureFrame(menu);
        } else if (state.equals("easy")) {
            gameBoard.reset();
            gameBoard.setHardMode(false);
            configureFrame(gameBoard.getFrame());
        } else if (state.equals("hard")) {
            gameBoard.reset();
            gameBoard.setHardMode(true);
            configureFrame(gameBoard.getFrame());
        } else if (state.equals("history")) {
            gameHistory.setSavedGameList(savedGameList);
            configureFrame(gameHistory);
        } else if (state.equals("load") && gameIndex != -1) {
            gameBoard.loadGame(gameIndex);
        }
    }

    /**
     * Setting the history game list.
     *
     * @param savedGameList list of game history.
     */
    public void setSavedGameList(List<String> savedGameList) {
        this.savedGameList = savedGameList;
    }

    /**
     * Setting the game that the user wants to load.
     *
     * @param index the index of the game in the list.
     */
    public void setLoadGame(int index) {
        this.gameIndex = index;
    }
}
