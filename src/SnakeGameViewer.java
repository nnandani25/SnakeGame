import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeGameViewer extends JFrame{

    private SnakeGame game;
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

    public void drawEndGame(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.drawRect(0,0,800,800);
    }



//    @Override
//    public void paint(Graphics g)
//    {
//        b.draw(g, 0,0);
//    }
}
