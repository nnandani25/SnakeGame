import javax.swing.*;
import java.awt.*;

public class Pixel {
    private Color color;
    private boolean hasApple;
    private boolean isSnake;
    private Image apple;
    private int row;
    private int col;

    private Snake s;

    public static final int SIZE = 40;

    public Pixel(Color color, boolean hasApple, boolean isSnake, int row, int col)
    {
        this.color = color;
        this.hasApple = hasApple;
        this.isSnake = isSnake;
        this.row = row;
        this.col = col;
        apple = new ImageIcon("Resources/apple.png").getImage();
    }

    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }

    public boolean getIsSnake()
    {
        return isSnake;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isHasApple() {
        return hasApple;
    }

    public void setHasApple(boolean hasApple) {
        this.hasApple = hasApple;
    }


    public void setSnake(boolean snake) {
        isSnake = snake;
    }

    public void draw(Graphics g, int x, int y, SnakeGameViewer viewer)
    {
        int pink = (int)((Math.random()*234) + 22);
        Color randPink = new Color(252,3,107);
        Color blue = new Color(3,252,186);
        if(this.isSnake)
        {
            g.setColor(blue);

        }

        else if(this.hasApple)
        {
            g.setColor(randPink);
            viewer.drawApple(g, x, y);
        }

        else
        {
            g.setColor(color);
        }

        g.fillRect(x, y, SIZE, SIZE);
    }

}
