import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;


public class SnakeGameViewer extends JFrame implements KeyListener {

    private SnakeGame game;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private Image instructions;
    private Image start;
    private Image apple;
    private Snake snake;
    private boolean spacePressed;
    private int num;
    private boolean keyStart;

    // Initializes the window and all the instance variables.
    public SnakeGameViewer(SnakeGame game, Snake snake)
    {
        instructions = new ImageIcon("Resources/Instructions.png").getImage();
        start = new ImageIcon("Resources/startingScreen.png").getImage();
        apple = new ImageIcon("Resources/apple.png").getImage();
        spacePressed = false;
        num = 0;
        keyStart = false;
        this.game = game;
        this.snake = snake;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Snake Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.addKeyListener(this);
        this.setVisible(true);
        this.createBufferStrategy(2);
        this.repaint();
    }

    // Implements a buffer strategy which makes the game run smoother.
    public void paint(Graphics g)
    {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
        Graphics g2 = null;
        try {
            g2 = bf.getDrawGraphics();
            myPaint(g2);
        }
        finally {
            g2.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }

    // Draws the instructions and then calls the game draw method if space is pressed because that means the game has
    // started.
    public void myPaint(Graphics g)
    {
        g.drawImage(start, 0,0,800,800, this);
        g.drawImage(instructions,120, 150, 566, 488, this);
        if(spacePressed == true)
        {
            game.draw(g);
        }
    }

    // Draws the "Game Over" once the snake has died.
    public void drawEndGame(Graphics g)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("Public Pixel", Font.PLAIN, 80));
        g.drawString("Game Over", 40,400);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // Returns the keyStart variable;
    public boolean keyStart()
    {
        return keyStart;
    }

    // Performs certain actions when certain keys are pressed.
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // If the space is pressed, it sets spacePressed to true which activates the home screen to switch to the board.
        if (keyCode == KeyEvent.VK_SPACE)
        {
            spacePressed = true;
        }

        // If the arrow keys are pressed, it changes the direction of the snake.
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

        // Makes keyStart true if the arrow keys are pressed for the first time. This is so the snake only starts moving
        // For the first time once you press an arrow key instead of automatically moving once the game screen changes.
        if(num == 1)
        {
            keyStart = true;

        }
        num++;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
