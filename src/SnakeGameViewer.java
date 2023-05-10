import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeGameViewer extends JFrame implements KeyListener {

    private SnakeGame game;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private Image instructions;
    private Image start;
    private Image apple;
    private Snake snake;
    private boolean spacePressed = false;
    private int num = 0;
    private boolean b = false;

    public SnakeGameViewer(SnakeGame game, Snake snake)
    {
        instructions = new ImageIcon("Resources/Instructions.png").getImage();
        start = new ImageIcon("Resources/startingScreen.png").getImage();
        apple = new ImageIcon("Resources/apple.png").getImage();
        this.game = game;
        this.snake = snake;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Snake Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.addKeyListener(this);
        this.setVisible(true);
        this.repaint();
    }

    public void paint(Graphics g)
    {
        g.drawImage(start, 0,0,800,800, this);
        g.drawImage(instructions,120, 150, 566, 488, this);
        if(spacePressed == true)
        {
            game.draw(g);
        }

    }

    public void drawEndGame(Graphics g)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("Public Pixel", Font.PLAIN, 80));
        g.drawString("Game Over", 40,400);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public boolean start()
    {
        return b;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE)
        {
            spacePressed = true;
        }

        if (keyCode == KeyEvent.VK_LEFT)
        {
            snake.setDirection(3);
        }

        if (keyCode == KeyEvent.VK_RIGHT)
        {
            snake.setDirection(1);
        }

        if (keyCode == KeyEvent.VK_UP)
        {
            snake.setDirection(0);
        }

        if (keyCode == KeyEvent.VK_DOWN)
        {
            snake.setDirection(2);
        }

        this.repaint();
        if(num == 1)
        {
            b = true;

        }


        num++;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
