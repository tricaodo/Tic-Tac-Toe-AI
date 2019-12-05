import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private JButton startBtn;
    private JButton loadBtn;
    private JButton exitBtn;
    public Menu(int width, int height){
        startBtn = new JButton("Start Game");
        loadBtn = new JButton("Load Game");
        exitBtn = new JButton("Exit Game");


        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(width, height));
        GridBagConstraints gridConstraints = new GridBagConstraints();

        JLabel welcomeTitle = new JLabel("Welcome to");
        welcomeTitle.setFont(new Font("Verdana",1,60));

        JLabel tictactoeTitle = new JLabel("TicTacToe Game");
        tictactoeTitle.setFont(new Font("Verdana",1,40));

        // welcome title
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 0.3;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.anchor = GridBagConstraints.CENTER;
        add(welcomeTitle, gridConstraints);

        // titactoe title
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 0.1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.anchor = GridBagConstraints.CENTER;
        add(tictactoeTitle, gridConstraints);

        // start button
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 0.1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.anchor = GridBagConstraints.CENTER;
        add(startBtn, gridConstraints);

        // load button
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 0.1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.anchor = GridBagConstraints.CENTER;
        add(loadBtn, gridConstraints);

        // exit button
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 0.1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.fill = GridBagConstraints.NONE;
        gridConstraints.anchor = GridBagConstraints.CENTER;
        add(exitBtn, gridConstraints);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello");
            }
        });
    }
}
