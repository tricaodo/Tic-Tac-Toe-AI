import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameHistory extends JFrame {
    private JButton loadBtn;
    private Game game;
    private List<String> savedGames;
    private JComboBox gameHistoryCombo;
    public GameHistory(Game game){
        this.game = game;
        loadBtn = new JButton("Load Game");
        savedGames = new ArrayList<>();
    }

    private JPanel loadPanel() {
        JPanel loadPanel = new JPanel();
        loadPanel.setPreferredSize(new Dimension(400, 400));
        return loadPanel;
    }
    public void setNumberOfSavedGames(int numberOfSavedGames){
        savedGames.clear();

        for(int i = 1; i <= numberOfSavedGames; i++){
            savedGames.add("Game " + i);
        }
        gameHistoryCombo = new JComboBox(savedGames.toArray());
        JPanel panel = loadPanel();
        panel.add(gameHistoryCombo);
        add(panel);
    }
}
