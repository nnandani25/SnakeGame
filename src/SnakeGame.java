import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame implements KeyListener, ActionListener {

    private SnakeGameViewer window;
    private Snake snake;
    private Board b;
    private  int delayInMilliSec = 150;
    private boolean spacePressed = false;
    private Timer clock;



    public SnakeGame()
    {
        b = new Board();
        snake = new Snake(b);
        window = new SnakeGameViewer(this);
        window.addKeyListener(this);
        //this.window = new SnakeGameViewerDoubleBuffered(this);
        clock = new Timer(delayInMilliSec, this);

    }

    public void draw(Graphics g)
    {
        b.draw(g, 0, 0, window);

        clock.start();
        if(b.getScore() % 5 == 0)
        {
            delayInMilliSec -= 25;
        }


        checkWin(g);
    }

    public void checkWin(Graphics g)
    {
        if(!snake.onBoard() || snake.getHasDied())
        {
            clock.stop();
            window.drawEndGame(g);
        }
    }

    public boolean getIsSpacePressed()
    {
        return spacePressed;

    }
    public void game()
    {
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE)
        {
            spacePressed = true;
            //snake.move();
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
        window.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args)
    {
        SnakeGame game = new SnakeGame();

    }

    public void actionPerformed(ActionEvent e)
    {
        window.repaint();
        snake.move();
    }



}