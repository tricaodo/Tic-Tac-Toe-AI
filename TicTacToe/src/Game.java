import javax.swing.*;

public class Game {
    private final Menu menu;
    private final Mode mode;
    private final Board board;
    private final GameHistory gameHistory;
    private String state = "menu";
    private int numberOfSavedGames = 0;

    public Game() {
        menu = new Menu(this);
        mode = new Mode(this);
        board = new Board(this);
        gameHistory = new GameHistory(this);
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
            configureFrame(board);
        }else if(state.equals("hard")){

        }else if(state.equals("load")){
            gameHistory.setNumberOfSavedGames(numberOfSavedGames);
            configureFrame(gameHistory);
        }
    }

    public void setNumberOfSavedGames(int numberOfSavedGames){
        this.numberOfSavedGames = numberOfSavedGames;
    }
}
