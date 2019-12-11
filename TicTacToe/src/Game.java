import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Menu menu;
    private final Mode mode;
    private final Board board;
    private final GameHistory gameHistory;
    private String state = "menu";
    private List<String> savedGameList;
    private int gameIndex = -1;


    public Game() {
        menu = new Menu(this);
        mode = new Mode(this);
        board = new Board(this);
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

    public void setState(String str){
        state = str;
        changeScene();
    }

    public void changeScene(){
        if(state.equals("mode")){
            configureFrame(mode);
        }else if(state.equals("menu")){
            configureFrame(menu);
        }else if(state.equals("easy")){
            board.reset();
            configureFrame(board);
        }else if(state.equals("hard")){
            board.reset();
        }else if(state.equals("history")){
            gameHistory.setSavedGameList(savedGameList);
            configureFrame(gameHistory);
        } else if(state.equals("load") && gameIndex != -1){
            board.loadGame(gameIndex);
            configureFrame(board);
        }
    }
    public void setSavedGameList(List<String> savedGameList){
        this.savedGameList = savedGameList;
    }

    public void setLoadGame(int index){
        this.gameIndex = index;
    }
}
