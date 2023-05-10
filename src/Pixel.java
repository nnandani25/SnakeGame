import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pixel {
    private Color color;
    private boolean hasApple;
    private boolean isSnake;
//    private static BufferedImage apple;
//    static {
//        try {
//            apple = ImageIO.read(new File("Resources/apple.png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    private Image apple;
    private int row;
    private int col;
    public final static int SIZE = 40;

    private boolean isHead = false;
    private int headDirection = 0;

    public Pixel(Color color, boolean hasApple, boolean isSnake, int row, int col)
    {
        this.color = color;
        this.hasApple = hasApple;
        this.isSnake = isSnake;
        this.row = row;
        this.col = col;
        apple = new ImageIcon("Resources/apple.png").getImage();
    }

    public void setHead(boolean head) {
        isHead = head;
    }

    public void setHeadDirection(int headDirection) {
        this.headDirection = headDirection;
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
        Color pink = new Color(252,3,107);
        Color blue = new Color(3,252,186);

        if(this.isSnake)
        {
            g.setColor(blue);

        }

        else
        {
            g.setColor(color);
        }

        g.fillRect(x, y, SIZE, SIZE);

        if(this.hasApple && !this.isSnake)
        {
//            g.setColor(pink);
//            viewer.drawApple(g, x, y);
        //g.drawImage(apple, x, y, 40, 40, viewer);
        //((Graphics2D)g).drawImage(apple, x,y,SIZE,SIZE,null);
            g.drawImage(apple, x, y, SIZE, SIZE, viewer);
        }

        if(this.isHead)
        {
            g.setColor(Color.MAGENTA);
            g.setColor(Color.BLACK);
            int c = SIZE/4;
            int d = SIZE/8;

            if(headDirection == 0 ||headDirection == 3)
            {
                g.fillOval(x+d, y+d, c, c);
            }

            if(headDirection == 0 || headDirection == 1)
            {
                g.fillOval(x+SIZE - d -c, y+d, c, c);
            }

            if(headDirection == 2 || headDirection == 3)
            {
                g.fillOval(x+d, y+SIZE-d-c, c, c);
            }

            if(headDirection == 1 || headDirection == 2)
            {
                g.fillOval(x+SIZE - d -c, y+SIZE - d -c, c, c);
            }

        }
    }

}
