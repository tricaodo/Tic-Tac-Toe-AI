import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Menu menu;
    private final Mode mode;
    private final Board board;
    private String state = "menu";
    private List<String> gameHistory = new ArrayList<>();

    public Game() {
        menu = new Menu(this);
        mode = new Mode(this);
        board = new Board(this);
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
            configureFrame(board);
        }else if(state.equals("hard")){

        }else if(state.equals("load")){
            board.loadGame();
            configureFrame(board);
        }
    }

    public void setGameHistory(List<String> gameHistory){
        this.gameHistory = gameHistory;
        System.out.println(this.gameHistory);
    }
}
