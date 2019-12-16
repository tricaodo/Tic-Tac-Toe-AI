import javax.swing.*;

public class Main {
    /**
     * The main method is in this class.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
        });
    }
}