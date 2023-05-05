import javax.swing.*;
import java.awt.*;

public class Pixel {
    private Color color;
    private boolean hasApple;
    private boolean isSnake;

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
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void shiftXLeft()
    {
        row-=1;
    }

    public void shiftXRight()
    {
        row+=1;
    }


    public Color getColor() {
        return color;
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

    public void draw(Graphics g, int x, int y)
    {
        if(this.isSnake)
        {
            g.setColor(Color.MAGENTA);
        }

        else if(this.hasApple)
        {
            g.setColor(Color.RED);
        }

        else
        {
            g.setColor(color);
        }

        g.fillRect(x, y, SIZE, SIZE);
    }

}
