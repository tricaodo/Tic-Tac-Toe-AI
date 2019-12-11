import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class GameHistory extends JFrame implements ItemListener {
    private JButton loadBtn;
    private JButton backBtn;
    private Game game;
    private int gameIndex = -1;

    private JComboBox gameHistoryCombo;

    public GameHistory(Game game){

        this.game = game;
        loadBtn = new JButton("Load Game");
        backBtn = new JButton("Back    ");

        gameHistoryCombo = new JComboBox();

        comboBoxPanel();

        backButtonEvent();
        loadButtonEvent();

        gameHistoryCombo.addItemListener(this);
    }

    private void backButtonEvent(){
        backBtn.addActionListener(e -> {
            this.setVisible(false);
            game.setState("menu");
        });
    }

    private void loadButtonEvent(){
        loadBtn.addActionListener(e -> {
            game.setLoadGame(gameIndex - 1);
            this.setVisible(false);
            game.setState("load");
        });
    }

    public void setSavedGameList(List<String> savedGameList){
        gameHistoryCombo.removeAllItems();
        for(int i = 0; i < savedGameList.size(); i++){
            gameHistoryCombo.addItem("Game " + (i + 1));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String str = (String) e.getItem();
        gameIndex = Integer.parseInt(str.split(" ")[1]);;
    }

    /**
     * Setting the configuration for gridBagConstraints.
     *
     * @param weightx            weight x for gridBagConstraints.
     * @param weighty            weight y for gridBagConstraints.
     * @param gridx              grid x for gridBagConstraints.
     * @param gridy              grid y for gridBagConstraints.
     * @param gridBagConstraints gridBagConstraints input.
     */
    private void gridBagConstraints(double weightx, double weighty, int gridx, int gridy, GridBagConstraints gridBagConstraints) {
        gridBagConstraints.weightx = weightx;
        gridBagConstraints.weighty = weighty;
        gridBagConstraints.gridx = gridx;
        gridBagConstraints.gridy = gridy;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
    }

    private void comboBoxPanel() {
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new GridBagLayout());
        comboBoxPanel.setPreferredSize(new Dimension(400, 400));
        GridBagConstraints gridConstraints = new GridBagConstraints();


        JLabel gameTitle = new JLabel("Game History");
        gameTitle.setFont(new Font("Verdana", 1, 40));

        // Game title
        gridBagConstraints(1, 0.3, 0, 0, gridConstraints);
        comboBoxPanel.add(gameTitle, gridConstraints);

        // Combobox title
        gridBagConstraints(1, 0.1, 0, 1, gridConstraints);
        comboBoxPanel.add(gameHistoryCombo, gridConstraints);

        // load button
        gridBagConstraints(1, 0.1, 0, 2, gridConstraints);
        comboBoxPanel.add(loadBtn, gridConstraints);

        gridBagConstraints(1, 0.1, 0, 3, gridConstraints);
        comboBoxPanel.add(backBtn, gridConstraints);

        add(comboBoxPanel);
    }
}
