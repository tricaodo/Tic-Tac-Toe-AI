import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JPanel {

    private JButton[][] cells;
    private boolean isGameOver;
    private String token;
    private final int DIMENSION;

    public TicTacToe() {
        cells = new JButton[3][3];
        isGameOver = false;
        token = "X";
        DIMENSION = 140;

        Dimension dimension = new Dimension(DIMENSION, DIMENSION);

        // create the panel for the board.
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        panel.setPreferredSize(new Dimension(440, 480));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                panel.add(cells[row][col] = new JButton(""));
                cells[row][col].setPreferredSize(dimension);
                int finalRow = row;
                int finalCol = col;
                cells[row][col].addActionListener(e -> {
                    System.out.println("Clicked");
                    mouseClickedEvent(finalRow, finalCol);
                });
            }
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void mouseClickedEvent(int row, int col) {
        if (!isGameOver) {
            // Check game status
            if (cells[row][col].getText().equals("")) {
                cells[row][col].setText(token);
                isGameOver = isWon();
                token = (token.equals("X")) ? "O" : "X";
                easyMode();
                isGameOver = isWon();
            }
        }
    }

//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//        // Calculate the coordinate of the cell.
//        int col = e.getX() / DIMENSION;
//        int row = e.getY() / DIMENSION;
//
//        if (!isGameOver) {
//            // Check game status
//            if (cells[row][col].getToken() == ' ') {
//                cells[row][col].setToken(token);
//                isGameOver = isWon();
//                token = (token == 'X') ? 'O' : 'X';
//                easyMode();
//                isGameOver = isWon();
//            }
//        }
//
//    }
//
//    /**
//     * Check if same character (X or O) on the same row.
//     *
//     * @return true if same character(X or O) on the row. Otherwise, false
//     */
    private boolean checkRows() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][0].getText().equals( cells[i][1].getText())
                    && cells[i][1].getText().equals(cells[i][2].getText())
                    && !cells[i][0].getText().equals("")) {
                return true;
            }
        }
        return false;
    }
//
//    /**
//     * Check if same character (X or O) on the same column.
//     *
//     * @return true if same character(X or O) on the column. Otherwise, false
//     */
    private boolean checkCols() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[0][i].getText().equals(cells[1][i].getText())
                    && cells[1][i].getText().equals(cells[2][i].getText())
                    && !cells[0][i].getText().equals("")) {
                return true;
            }
        }
        return false;
    }
//
//    /**
//     * Check if same character (X or O) on the same diagonal.
//     *
//     * @return true if same character(X or O) on the diagonal. Otherwise, false
//     */
    private boolean checkDiagonals() {
        if (cells[0][0].getText().equals(cells[1][1].getText()) &&
                cells[1][1].getText().equals(cells[2][2].getText()) &&
                !cells[0][0].getText().equals("")) {
            return true;
        }
        if (cells[2][0].getText().equals(cells[1][1].getText()) &&
                cells[1][1].getText().equals(cells[0][2].getText()) &&
                !cells[2][0].getText().equals("")) {
            return true;
        }
        return false;
    }
//
//    /**
//     * Check either rows, cols, or diagonals were filled with same character or not.
//     *
//     * @return true if same character on one of them (rows, cols, diagonals), otherwise false.
//     */
    public boolean isWon() {
        return checkCols() || checkRows() || checkDiagonals();
    }
//
//
//
//    /**
//     * Computer automatically plays after the user's turn.
//     */
    private void easyMode() {
        while (!isGameOver) {
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);
            if (cells[row][col].getText().equals("")) {
                cells[row][col].setText(token);
                token = (token.equals("X")) ? "O" : "X";
                break;
            }

        }
    }

    private void hardMode() {

    }

//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        System.out.println(e.getX() + " - " + e.getY());
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }


}
