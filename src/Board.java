import java.awt.*;

public class Board{

    private Pixel[][] board;
    private int width = 800;

    public Board()
    {
        board = new Pixel[10][10];
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if((i+j) % 2 == 0)
                {
                    Pixel p = new Pixel(Color.green, false, false);
                    board[i][j] = p;
                }

                else
                {
                    Pixel p = new Pixel(Color.yellow, false, false);
                    board[i][j] = p;
                }

            }
        }
    }

    public void draw(Graphics g, int x, int y)
    {
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                board[i][j].draw(g, x+j*Pixel.SIZE, y+i*Pixel.SIZE);
            }
        }
    }



}
