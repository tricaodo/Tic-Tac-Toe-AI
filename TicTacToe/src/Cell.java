import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Cell extends JPanel {
    private int x;
    private int y;
    private char token;
    public Cell(int x, int y, char token){
        this.x = x;
        this.y = y;
        this.token = token;
        setBorder(new LineBorder(Color.black, 1));
    }



    public void setToken(char token) {
        this.token = token;
        repaint();
    }

    public char getToken(){
        return token;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (token == 'X')
        {
            g.drawLine(0, 0, getWidth() - 10, getHeight() - 10);
            g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
        }

        else if (token == 'O')
        {
            g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
        }
    }
} // end class Cell