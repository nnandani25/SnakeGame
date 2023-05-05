import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame implements KeyListener {

    private SnakeGameViewer window;
    private Snake snake;
    private Board b;


    public SnakeGame()
    {
        b = new Board();
        snake = new Snake(12,12, b);
        window = new SnakeGameViewer(this);
        window.addKeyListener(this);
    }

    public void draw(Graphics g)
    {
        b.draw(g, 0, 0);
        //Pixel p = new Pixel(Color.MAGENTA, false, true, 20,30);

        //320,360
//        if(snake.isApple())
//        {
//           b.eatApple();
//        }


    }


    public void checkWin(Graphics g)
    {
        if(!snake.onBoard())
        {
            window.drawEndGame(g);
        }
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
            snake.move();
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

}