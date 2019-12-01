import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        int WIDTH = 420;
        int HEIGHT = 420;
        TicTacToe ticTacToe = new TicTacToe(WIDTH, HEIGHT);
        ticTacToe.setTitle("TicTacToe Game");
        ticTacToe.setSize(WIDTH, HEIGHT);
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);
    }
}
