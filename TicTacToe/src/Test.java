import javax.swing.*;

public class Test {
    private static int WIDTH = 420;
    private static int HEIGHT = 420;

    public static void main(String[] args) {

//        TicTacToe ticTacToe = new TicTacToe(WIDTH, HEIGHT);
//        ticTacToe.setTitle("TicTacToe Game");
//        ticTacToe.setSize(WIDTH, HEIGHT);
//        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ticTacToe.setLocationRelativeTo(null);
//        ticTacToe.setVisible(true);
        Menu menu = new Menu(WIDTH, HEIGHT);
        JFrame jFrame = new JFrame("Tic Tac Toe");
        jFrame.add(menu);
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
