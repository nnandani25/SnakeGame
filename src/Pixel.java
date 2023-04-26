import javax.swing.*;
import java.awt.*;

public class Pixel {
    private Color color;
    private boolean hasApple;
    private boolean isSnake;

    public static final int SIZE = 80;

    public Pixel(Color color, boolean hasApple, boolean isSnake)
    {
        this.color = color;
        this.hasApple = hasApple;
        this.isSnake = isSnake;
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

    public boolean isSnake() {
        return isSnake;
    }

    public void setSnake(boolean snake) {
        isSnake = snake;
    }

    public void draw(Graphics g, int x, int y)
    {
        g.setColor(color);
        g.fillRect(x, y, SIZE, SIZE);
    }

}
