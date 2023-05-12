import java.awt.*;

public class Board{

    private Pixel[][] board;
    public final int NUM_ROWS = 20;
    private Color lightGreen = new Color(138,226,42);
    private Color darkGreen = new Color(112, 188, 30);
    private Snake s;
    private int score = 0;
    private int appleRow;
    private int appleCol;
    private int numApples = 1;

    public Board()
    {
        // Creates the board and sets the color of the pixels.
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
        // Initializes the first position of the apple and sets hasApple to true.
        appleRow = 8;
        appleCol = 12;
        board[appleRow][appleCol].setHasApple(true);
        // Creates a snake.
        s = new Snake(this);

    }

    // Draws the board by individually drawing the pixels and displays the score.
    public void draw(Graphics g, int x, int y, SnakeGameViewer v)
    {
        // Goes through the board and draws each pixel.
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                board[i][j].draw(g, x + j * Pixel.SIZE, y + i * Pixel.SIZE, v);
            }
        }

        // Draws the score and updates it.
        g.setColor(Color.BLACK);
        g.setFont(new Font("Public Pixel", Font.PLAIN, 20));
        g.drawString("Score: " + score, 600, 70);
    }

    // Adds an apple to the board at a random position.
    public void addApple()
    {
        score++;
        Pixel p = getPixel(appleRow, appleCol);

        // Ensures that there is only one apple on the board at a time.
        if(numApples == 0)
        {
            appleRow = (int)(Math.random()*NUM_ROWS);
            appleCol = (int)(Math.random()*NUM_ROWS);
            board[appleRow][appleCol].setHasApple(true);
            numApples++;
        }
        p.setHasApple(false);
    }

    // Subtracts one from the number of apples.
    public void changeNumApples()
    {
        numApples--;
    }

    // Returns the pixel based on the row and col.
    public Pixel getPixel(int row, int col)
    {
        return board[row][col];
    }


}
