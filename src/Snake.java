import java.awt.*;
import java.util.ArrayList;

public class Snake {


    // North = 0 East = 1 South = 2 West = 3.
    private int direction;
    private int lastDirection;
    private ArrayList<Pixel> snakePieces;
    private Board b;
    private boolean hasDied;

    public Snake(Board b)
    {
        // Initializes the instance variables and the snakePieces arrayList.
        this.b = b;
        hasDied = false;
        snakePieces = new ArrayList<Pixel>();
        int x = 8;
        int y = 10;

        // Adds pixels to the arraylist which creates the snake.
        for(int i = 0; i < 4; i++)
        {
            snakePieces.add(b.getPixel(x, y-i));
            b.getPixel(x, y-i).setSnake(true);
        }

        // Sets the original direction.
        direction = 1;
        lastDirection = 0;
        snakePieces.get(0).setHead(true);
        snakePieces.get(0).setHeadDirection(direction);

    }

    // Returns the hasDied variable.
    public boolean getHasDied()
    {
        return hasDied;
    }

    // Sets the direction based on the direction it takes in and the last direction.
    public void setDirection(int direction)
    {
        if(direction == 0  && lastDirection != 2)
        {
            this.direction = 0;
        }

        if(direction == 1  && lastDirection != 3)
        {
            this.direction = 1;
        }

        if(direction == 2  && lastDirection != 0)
        {
            this.direction = 2;
        }
        if(direction == 3  && lastDirection != 1)
        {
            this.direction = 3;
        }
    }

    // Moves the snake by adding a piece to the front and removing one from the end.
    public void move()
    {
        int r = snakePieces.get(0).getRow();
        int c = snakePieces.get(0).getCol();

        // If the direction of the head is 0, subtract one from the row.
        if(direction == 0)
        {
            r--;
        }

        // If the direction of the head is 1, adds one from the col.
        else if(direction == 1)
        {
            c++;
        }

        // If the direction of the head is 2, adds one from the row.
        else if(direction == 2)
        {
            r++;
        }

        // If the direction of the head is 3, subtract one from the col.
        else
        {
            c--;
        }

        // If the head is on an apple, it doesn't remove a piece because the snake grows longer.
        if(snakePieces.get(0).isHasApple())
        {
            b.changeNumApples();
            b.addApple();
        }

        // Removes the last piece of the snake if the head is not part of the apple.
        else
        {
            snakePieces.remove(snakePieces.size()-1).setSnake(false);
        }

        // If its in bounds and the next piece is not part of the snake it adds a new piece to the front of the snake.
        if(r >= 0 && r < b.NUM_ROWS && c >= 0 && c < b.NUM_ROWS && b.getPixel(r,c).getIsSnake() == false)
        {
            // Sets the current head to false.
            snakePieces.get(0).setHead(false);
            // Adds a new piece as the head.
            snakePieces.add(0, b.getPixel(r, c));
            // Sets the necessary variables for the new head.
            snakePieces.get(0).setHead(true);
            snakePieces.get(0).setSnake(true);
            snakePieces.get(0).setHeadDirection(direction);
            lastDirection = direction;
        }

        // If it is not in bounds it sets the hasDied variable to true.
        else
        {
            hasDied = true;
        }

    }


}
