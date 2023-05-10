import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeGame implements ActionListener {

    private SnakeGameViewer window;
    private Snake snake;
    private Board b;
    private  int delayInMilliSec = 100;
    public Timer clock;


    public SnakeGame()
    {
        b = new Board();
        snake = new Snake(b);
        window = new SnakeGameViewer(this,  snake);
        clock = new Timer(delayInMilliSec, this);

    }

    public void draw(Graphics g)
    {
        b.draw(g, 0, 0, window);
        if(window.start())
        {
            clock.start();
        }
        checkWin(g);
    }

    public void checkWin(Graphics g)
    {
        if(snake.getHasDied())
        {
            clock.stop();
            window.drawEndGame(g);
        }
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