/**
 * This class handles the main menu that is displayed in the 
 * beginning of the game.
 */
import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JButton startBtn;
    private JButton loadBtn;
    private JButton exitBtn;

    private final Game game;

    /**
     * Initializes all the attributes and setting all the functionalities.
     */
    public Menu(Game game) {
        this.game = game;

        startBtn = new JButton("Start Game");
        loadBtn = new JButton("Load Game");
        exitBtn = new JButton("Exit Game");

        menuPanel();

        // start event
        startBtn.addActionListener(e -> {
            this.setVisible(false);
            this.game.setState("mode");
        });

        // load event
        loadBtn.addActionListener(e -> {
            this.setVisible(false);
            this.game.setState("history");
        });

        // exit event
        exitBtn.addActionListener(e -> {
            System.exit(0);
        });

    }

    /**
     * A helper function setting the menu panel.
     */
    private void menuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setPreferredSize(new Dimension(340,340));
        GridBagConstraints gridConstraints = new GridBagConstraints();


        JLabel welcomeTitle = new JLabel("Welcome to");
        welcomeTitle.setFont(new Font("Verdana", 1, 40));

        JLabel tictactoeTitle = new JLabel("TicTacToe Game");
        tictactoeTitle.setFont(new Font("Verdana", 1, 30));

        // welcome title
        gridBagConstraints(1, 0.3, 0, 0, gridConstraints);
        menuPanel.add(welcomeTitle, gridConstraints);

        // titactoe title
        gridBagConstraints(1, 0.1, 0, 1, gridConstraints);
        menuPanel.add(tictactoeTitle, gridConstraints);

        // space label
        JLabel spaceLabel = new JLabel("");
        gridBagConstraints(1, 0.5, 0, 2, gridConstraints);
        menuPanel.add(spaceLabel, gridConstraints);

        // start button
        gridBagConstraints(1, 0.1, 0, 3, gridConstraints);
        menuPanel.add(startBtn, gridConstraints);

        // load button
        gridBagConstraints(1, 0.1, 0, 4, gridConstraints);
        menuPanel.add(loadBtn, gridConstraints);

        // exit button
        gridBagConstraints(1, 0.1, 0, 5, gridConstraints);
        menuPanel.add(exitBtn, gridConstraints);

        add(menuPanel);
    }


    /**
     * A helper function setting the configuration for gridBagConstraints.
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

}