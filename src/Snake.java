import java.awt.*;
import java.util.ArrayList;

public class Snake {


    //North = 0 East = 1 South = 2 West = 3
    private int direction;
    private int lastDirection;
    private ArrayList<Pixel> snakePieces;
    private Board b;
    private boolean hasDied = false;

    public Snake(Board b)
    {
        this.b = b;
        snakePieces = new ArrayList<Pixel>();
        int x = 8;
        int y = 10;
        for(int i = 0; i < 4; i++)
        {
            snakePieces.add(b.getPixel(x, y-i));
            b.getPixel(x, y-i).setSnake(true);
        }
        direction = 1;
        lastDirection = 0;

    }

    public ArrayList<Pixel> getSnakePieces()
    {
        return snakePieces;
    }

    public boolean hitWall()
    {
        return false;
    }


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


    public boolean onBoard()
    {
        if(snakePieces.get(0).getRow() <= 0 || snakePieces.get(0).getRow() >= b.NUM_ROWS-1)
        {
            return false;
        }

        if(snakePieces.get(0).getCol() <= 0 || snakePieces.get(0).getCol() >= b.NUM_ROWS-1)
        {
            return false;
        }

        return true;
    }


    public void move()
    {
        snakePieces.remove(snakePieces.size()-1).setSnake(false);
        int r = snakePieces.get(0).getRow();
        int c = snakePieces.get(0).getCol();

        if(direction == 0)
        {
            r--;
        }

        else if(direction == 1)
        {
            c++;
        }

        else if(direction == 2)
        {
            r++;
        }

        else
        {
            c--;
        }

        if(snakePieces.get(0).isHasApple())
        {
            snakePieces.add(b.getPixel(r+1,c));
            b.changeNumApples();
            b.addApple();
        }

        if(b.getPixel(r,c).getIsSnake() == false)
        {
            snakePieces.add(0, b.getPixel(r, c));
            snakePieces.get(0).setSnake(true);
            lastDirection = direction;
        }

        else
        {
            hasDied = true;
        }




    }

    public boolean getHasDied()
    {
        return hasDied;
    }


}
