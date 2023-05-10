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
        // Initializes the instance variables.
        b = new Board();
        snake = new Snake(b);
        window = new SnakeGameViewer(this,  snake);
        clock = new Timer(delayInMilliSec, this);

    }

    // Draws the game and starts the clock.
    public void draw(Graphics g)
    {
        b.draw(g, 0, 0, window);
        // If an arrow key is pressed for the first time, the clock starts.
        if(window.keyStart())
        {
            clock.start();
        }
        //Constantly checking if the player has died.
        checkWin(g);
    }

    // Checks if the player has won by checking if they have died.
    public void checkWin(Graphics g)
    {
        // If the snake dies it stops the clock and ends the game.
        if(snake.getHasDied())
        {
            clock.stop();
            window.drawEndGame(g);
        }
    }

    // Creates a new game object which runs the game.
    public static void main(String[] args)
    {
        SnakeGame game = new SnakeGame();

    }

    // Uses the clock and makes the snake constantly moving until the clock stops.
    public void actionPerformed(ActionEvent e)
    {
        // Repaints and moves the snake.
        window.repaint();
        snake.move();
    }

}