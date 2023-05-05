import java.awt.*;

public class Board{

    private Pixel[][] board;
    private int width = 800;
    public final int NUM_ROWS = 20;
    private Color lightGreen = new Color(138,226,42);
    private Color darkGreen = new Color(112, 188, 30);
    private Snake s;
    int appleRow;
    int appleCol;
    private int numApples = 1;

    public Board()
    {
        board = new Pixel[NUM_ROWS][NUM_ROWS];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                if((i+j) % 2 == 0)
                {
                    Pixel p = new Pixel(lightGreen, false, false, i, j);
                    board[i][j] = p;
                }

                else
                {
                    Pixel p = new Pixel(darkGreen, false, false, i, j);
                    board[i][j] = p;
                }

            }
        }

        appleRow = (int)(Math.random()*NUM_ROWS);
        appleCol = (int)(Math.random()*NUM_ROWS);
        board[appleRow][appleCol].setHasApple(true);


    }

    public void draw(Graphics g, int x, int y)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                board[i][j].draw(g, x + j * Pixel.SIZE, y + i * Pixel.SIZE);
            }
        }
    }

    public void setBoard(int x, int y, Pixel p)
    {
        if(x <= board.length && y <= board.length)
        {
            board[x][y] = p;
        }
    }

    public void repaint()
    {
        this.repaint();
    }
    public Pixel[][] getBoard()
    {
        return board;

    }

    public int getAppleRow()
    {
        return appleRow;
    }

    public int getAppleCol()
    {
        return appleCol;
    }


//    public void eatApple()
//    {
//        board[appleRow][appleCol].setColor(Color.MAGENTA);
//        s.getSnakePieces().add(s.getSnakePieces().size(),board[][]);
//    }
    public void changeNumApples()
    {
        numApples--;
    }

    public Pixel getPixel(int row, int col)
    {
        return board[row][col];
    }
}
