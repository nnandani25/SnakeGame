import javax.swing.*;
import java.awt.*;

public class Pixel {
    private Color color;
    private boolean hasApple;
    private boolean isSnake;
    private Image apple;
    private int row;
    private int col;
    public final static int SIZE = 40;
    private boolean isHead;
    private int headDirection;

    // Constructor takes in variables and initializes them.
    public Pixel(Color color, boolean hasApple, boolean isSnake, int row, int col)
    {
        this.color = color;
        this.hasApple = hasApple;
        this.isSnake = isSnake;
        this.row = row;
        this.col = col;
        isHead = false;
        headDirection = 0;
        apple = new ImageIcon("Resources/apple.png").getImage();
    }

    // Sets the setHead variable.
    public void setHead(boolean head) {
        isHead = head;
    }

    // Sets the headDirection variable.
    public void setHeadDirection(int headDirection) {
        this.headDirection = headDirection;
    }

    // Returns the row the pixel is in.
    public int getRow() {
        return row;
    }

    // Returns the row the pixel is in.
    public int getCol() {
        return col;
    }

    // Returns the isSnake Variable.
    public boolean getIsSnake()
    {
        return isSnake;
    }

    // Returns the hasApple variable.
    public boolean isHasApple() {
        return hasApple;
    }

    // Sets the hasApple variable.
    public void setHasApple(boolean hasApple) {
        this.hasApple = hasApple;
    }

    // Sets the isSnake variable.
    public void setSnake(boolean snake) {
        isSnake = snake;
    }

    // Draws the pixel depending on if it is a snake, an apple, the head, or an average board piece.
    public void draw(Graphics g, int x, int y, SnakeGameViewer viewer)
    {
        // Makes the color of the snake.
        Color blue = new Color(3,252,186);

        // Sets the color of the pixel to blue if it is part of the snake.
        if(this.isSnake)
        {
            g.setColor(blue);

        }

        // Sets the color to the board color.
        else
        {
            g.setColor(color);
        }

        // Draws the pixel.
        g.fillRect(x, y, SIZE, SIZE);

        // If the pixel is an apple and not a snake it draws the apple image.
        if(this.hasApple && !this.isSnake)
        {
            g.drawImage(apple, x, y, SIZE, SIZE, viewer);
        }

        // Changes the color of the pixel and draws the head with eyes if it is the head.
        if(this.isHead)
        {
            g.setColor(Color.MAGENTA);
            g.setColor(Color.BLACK);
            int diameter = SIZE/4;
            int distanceFromEdge = SIZE/8;

            // Calculates where to put the eyes on the head based on the direction the head is facing.
            // Uses the diameter and distance from the edge to calculate.
            if(headDirection == 0 ||headDirection == 3)
            {
                g.fillOval(x+distanceFromEdge, y+distanceFromEdge, diameter, diameter);
            }

            if(headDirection == 0 || headDirection == 1)
            {
                g.fillOval(x+SIZE - distanceFromEdge - diameter, y+distanceFromEdge, diameter, diameter);
            }

            if(headDirection == 2 || headDirection == 3)
            {
                g.fillOval(x+distanceFromEdge, y+SIZE-distanceFromEdge-diameter, diameter, diameter);
            }

            if(headDirection == 1 || headDirection == 2)
            {
                g.fillOval(x+SIZE - distanceFromEdge -diameter, y+SIZE - distanceFromEdge -diameter, diameter,
                        diameter);
            }

        }
    }

}
