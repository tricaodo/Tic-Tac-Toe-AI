import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JButton startBtn;
    private JButton loadBtn;
    private JButton exitBtn;

    private JButton easyBtn;
    private JButton hardBtn;
    private JButton backBtn;

    private JLabel spaceLabel;

    public Menu(){
    }

    /**
     * Initialize all the attributes and setting all the functionalities.
     * @param width the dimension of the width.
     * @param height the dimension of the height.
     * @param titleGame the title of the game.
     */
    public Menu(int width, int height, String titleGame) {

        startBtn = new JButton("Start Game");
        loadBtn = new JButton("Load Game");
        exitBtn = new JButton("Exit Game");

        spaceLabel = new JLabel("");

        easyBtn = new JButton("Easy");
        hardBtn = new JButton("Hard");
        backBtn = new JButton("Back");

        JPanel menuPanel = menuPanel(width, height);
        JPanel levelPanel = levelPanel(width, height);

        setTitle(titleGame);
        add(menuPanel);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        // start event
        startBtn.addActionListener(e -> {
            updateUI(menuPanel, levelPanel);
        });

        // load event
        loadBtn.addActionListener(e -> {

        });

        // exit event
        exitBtn.addActionListener(e -> {
            System.exit(0);
        });

        // easy mode
        easyBtn.addActionListener(e -> {
            levelPanel.setVisible(false);
            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.setVisible(true);
            this.setVisible(false);
        });

        backBtn.addActionListener(e -> {
            updateUI(levelPanel, menuPanel);
        });

    }

    /**
     * Updating the panel.
     * @param firstPanel the panel will be hidden
     * @param secondPanel the panel will be visible
     */
    private void updateUI(JPanel firstPanel, JPanel secondPanel) {
        firstPanel.setVisible(false);
        add(secondPanel);
        secondPanel.updateUI();
        secondPanel.setVisible(true);
    }

    /**
     * Setting the menu panel.
     * @param width the dimension of the width.
     * @param height the dimension of the height.
     * @return the menu panel.
     */
    private JPanel menuPanel(int width, int height) {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setPreferredSize(new Dimension(width, height));
        GridBagConstraints gridConstraints = new GridBagConstraints();


        JLabel welcomeTitle = new JLabel("Welcome to");
        welcomeTitle.setFont(new Font("Verdana", 1, 60));

        JLabel tictactoeTitle = new JLabel("TicTacToe Game");
        tictactoeTitle.setFont(new Font("Verdana", 1, 40));

        // welcome title
        gridBagConstraints(1, 0.3, 0, 0, gridConstraints);
        menuPanel.add(welcomeTitle, gridConstraints);

        // titactoe title
        gridBagConstraints(1, 0.1, 0, 1, gridConstraints);
        menuPanel.add(tictactoeTitle, gridConstraints);

        // space label
        gridBagConstraints(1, 1, 0, 2, gridConstraints);
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

        return menuPanel;
    }

    /**
     * Setting the mode level panel.
     * @param width the dimension of the width.
     * @param height the dimension of the height.
     * @return the level panel.
     */
    private JPanel levelPanel(int width, int height) {
        JPanel levelPanel = new JPanel();
        levelPanel.setLayout(new GridBagLayout());
        levelPanel.setPreferredSize(new Dimension(300, 300));
        GridBagConstraints gridConstraints = new GridBagConstraints();

        // space label
        gridBagConstraints(1, 2, 0, 0, gridConstraints);
        levelPanel.add(spaceLabel, gridConstraints);

        // easy button
        gridBagConstraints(1, 0.1, 0, 1, gridConstraints);
        levelPanel.add(easyBtn, gridConstraints);

        // hard button
        gridBagConstraints(1, 0.1, 0, 2, gridConstraints);
        levelPanel.add(hardBtn, gridConstraints);

        // back button
        gridBagConstraints(1, 0.1, 0, 3, gridConstraints);
        levelPanel.add(backBtn, gridConstraints);

        return levelPanel;
    }

    /**
     * Setting the configuration for gridBagConstraints.
     * @param weightx weight x for gridBagConstraints.
     * @param weighty weight y for gridBagConstraints.
     * @param gridx grid x for gridBagConstraints.
     * @param gridy grid y for gridBagConstraints.
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
