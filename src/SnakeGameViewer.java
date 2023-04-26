import javax.swing.*;
import java.awt.*;

public class SnakeGameViewer extends JFrame{

    private SnakeGame game;
    private Snake snake;
    private Board b;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;

    public SnakeGameViewer(SnakeGame game)
    {
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Snake Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        game.draw(g);
    }

    public void drawStartScreen()
    {

    }

    public void drawApple()
    {

    }

    public void drawPlayScreen()
    {

    }


}
