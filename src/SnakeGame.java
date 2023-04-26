import javax.swing.*;
import java.awt.*;
public class SnakeGame {

    private SnakeGameViewer window;
    private Snake snake;
    private Board b;


    public SnakeGame()
    {
        b = new Board();
        window = new SnakeGameViewer(this);
    }

    public void draw(Graphics g)
    {
        b.draw(g, 0, 0);
    }


    public boolean checkWin()
    {
        return false;
    }


    public void game()
    {


    }

    public static void main(String[] args)
    {
        SnakeGame game = new SnakeGame();
    }

}