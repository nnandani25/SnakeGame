import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeGameViewer extends JFrame {

    private SnakeGame game;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private Image instructions;
    private Image start;
    private Image apple;

    public SnakeGameViewer(SnakeGame game)
    {
        instructions = new ImageIcon("Resources/Instructions.png").getImage();
        start = new ImageIcon("Resources/startingScreen.png").getImage();
        apple = new ImageIcon("Resources/apple.png").getImage();
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Snake Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.repaint();

    }

    public void paint(Graphics g)
    {
        g.drawImage(start, 0,0,800,800, this);
        g.drawImage(instructions,120, 150, 566, 488, this);
        if(game.getIsSpacePressed())
        {
            game.draw(g);
        }
    }

    public void drawStartScreen()
    {

    }

    public void drawApple(Graphics g, int x, int y)
    {
        g.drawImage(apple, x, y, 40, 40, this);
    }

    public void drawPlayScreen()
    {

    }



    public void drawEndGame(Graphics g)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("Public Pixel", Font.PLAIN, 80));
        g.drawString("Game Over", 40,400);
    }



//    @Override
//    public void paint(Graphics g)
//    {
//        b.draw(g, 0,0);
//    }
}
