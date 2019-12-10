import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
        });
    }
}
