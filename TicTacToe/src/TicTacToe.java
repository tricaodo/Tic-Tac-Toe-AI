import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToe extends JFrame implements MouseListener {

    private Cell[][] cells;
    private boolean isGameOver = false;
    private char token = 'X';
    private final int WIDTH = 420;
    private final int HEIGHT = 420;
    private final int DIMENSION = 140;

    public TicTacToe() {
        cells = new Cell[3][3];
        // create the panel for the board.
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                panel.add(cells[row][col] = new Cell(row, col, ' '));

        add(panel, BorderLayout.CENTER);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        // Calculate the coordinate of the cell.
        int col = e.getX() / DIMENSION;
        int row = e.getY() / DIMENSION;

        if (!isGameOver) {
            // Check game status
            if (isWon(token)) {
                isGameOver = true;
            } else if (isFull()) {
                isGameOver = true;
            } else {
                cells[row][col].setToken(token);
                token = (token == 'X') ? 'O' : 'X';
                computerTurn();
                token = (token == 'X') ? 'O' : 'X';
            }

        }

    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (cells[i][j].getToken() == ' ')
                    return false;
        return true;
    }

    public boolean isWon(char token) {
        // check rows
        for (int i = 0; i < 3; i++)
            if ((cells[i][0].getToken() == token)
                    && (cells[i][1].getToken() == token)
                    && (cells[i][2].getToken() == token)) {
                return true;
            }

        // check columns
        for (int j = 0; j < 3; j++)
            if ((cells[0][j].getToken() == token)
                    && (cells[1][j].getToken() == token)
                    && (cells[2][j].getToken() == token)) {
                return true;
            }
        // check diagonal
        if ((cells[0][0].getToken() == token)
                && (cells[1][1].getToken() == token)
                && (cells[2][2].getToken() == token)) {
            return true;
        }

        if ((cells[0][2].getToken() == token)
                && (cells[1][1].getToken() == token)
                && (cells[2][0].getToken() == token)) {
            return true;
        }

        return false;
    }

    private void computerTurn(){
        while(!isGameOver){
            int row = (int)(Math.random() * 3);
            int col = (int)(Math.random() * 3);
            if(cells[row][col].getToken() == ' '){
                cells[row][col].setToken(token);
                if(isGameOver){
                    System.out.println("Computer won!!!");
                }

                break;
            }
        }
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
