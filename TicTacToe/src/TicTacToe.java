import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToe extends JPanel implements MouseListener {

    private Cell[][] cells;
    private boolean isGameOver;
    private char token;
    private final int DIMENSION;

    public TicTacToe(int WIDTH, int HEIGHT) {
        cells = new Cell[3][3];
        isGameOver = false;
        token = 'X';
        DIMENSION = 140;
        // create the panel for the board.
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                panel.add(cells[row][col] = new Cell(' '));
            }
        }

        add(panel, BorderLayout.CENTER);
        addMouseListener(this);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        // Calculate the coordinate of the cell.
        int col = e.getX() / DIMENSION;
        int row = e.getY() / DIMENSION;

        if (!isGameOver) {
            // Check game status
            if (cells[row][col].getToken() == ' ') {
                cells[row][col].setToken(token);
                isGameOver = isWon();
                token = (token == 'X') ? 'O' : 'X';
                easyMode();
                isGameOver = isWon();
            }
        }

    }

    /**
     * Check if same character (X or O) on the same row.
     *
     * @return true if same character(X or O) on the row. Otherwise, false
     */
    private boolean checkRows() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][0].getToken() == cells[i][1].getToken()
                    && cells[i][1].getToken() == cells[i][2].getToken()
                    && cells[i][0].getToken() != ' ') {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if same character (X or O) on the same column.
     *
     * @return true if same character(X or O) on the column. Otherwise, false
     */
    private boolean checkCols() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[0][i].getToken() == cells[1][i].getToken()
                    && cells[1][i].getToken() == cells[2][i].getToken()
                    && cells[0][i].getToken() != ' ') {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if same character (X or O) on the same diagonal.
     *
     * @return true if same character(X or O) on the diagonal. Otherwise, false
     */
    private boolean checkDiagonals() {
        if (cells[0][0].getToken() == cells[1][1].getToken() &&
                cells[1][1].getToken() == cells[2][2].getToken() &&
                cells[0][0].getToken() != ' ') {
            return true;
        }
        if (cells[2][0].getToken() == cells[1][1].getToken() &&
                cells[1][1].getToken() == cells[0][2].getToken() &&
                cells[2][0].getToken() != ' ') {
            return true;
        }
        return false;
    }

    /**
     * Check either rows, cols, or diagonals were filled with same character or not.
     *
     * @return true if same character on one of them (rows, cols, diagonals), otherwise false.
     */
    public boolean isWon() {
        return checkCols() || checkRows() || checkDiagonals();
    }


    /**
     * Computer automatically plays after the user's turn.
     */
    private void easyMode() {
        while (!isGameOver) {
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);
            if (cells[row][col].getToken() == ' ') {
                cells[row][col].setToken(token);
                token = (token == 'X') ? 'O' : 'X';
                break;
            }

        }
    }

    private void hardMode(){

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
