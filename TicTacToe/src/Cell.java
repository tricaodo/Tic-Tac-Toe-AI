import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Cell extends JPanel {
    private char token;
    public Cell(char token){
        this.token = token;
        setBorder(new LineBorder(Color.black, 1));
    }

    public void setToken(char token) {
        this.token = token;
        this.repaint();
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
            g.setColor(Color.BLUE);
            g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
            g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
        }

        else if (token == 'O')
        {
            g.setColor(Color.RED);
            g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
        }
    }
} // end class Cell