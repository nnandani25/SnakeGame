import java.awt.*;
import java.util.ArrayList;

public class Snake {

    private int headX;
    private int headY;
    private int dx;
    private int dy;

    //North = 0 East = 1 South = 2 West = 3
    private int direction;
    private int lastDirection;
    private ArrayList<Pixel> snakePieces;
    private Board b;
    private SnakeGameViewer v;

    public Snake(int headX, int headY, Board b)
    {
        this.b = b;
        snakePieces = new ArrayList<Pixel>();
        int x = 8;
        int y = 9;
        for(int i = 0; i < 4; i++)
        {
            snakePieces.add(b.getPixel(x+i, y));
            b.getPixel(x+i, y).setSnake(true);
        }
        direction = 1;
        lastDirection = 0;
    }

    public ArrayList<Pixel> getSnakePieces()
    {
        return snakePieces;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public boolean hitWall()
    {
        return false;
    }

    public boolean touchingApple()
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

//    public void eatApple()
//    {
//        int r = snakePieces.get(0).getRow();
//        int c = snakePieces.get(0).getCol();
//        if(r == b.getAppleRow() && c+1 == b.getAppleCol())
//        {
//            b.getPixel(b.getAppleRow(), b.getAppleCol()).setColor(Color.MAGENTA);
//            snakePieces.add(b.getPixel(b.getAppleRow(), b.getAppleCol()));
//            b.changeNumApples();
//        }
//
//    }

    public boolean onBoard()
    {
        if(snakePieces.get(0).getRow() < b.NUM_ROWS || snakePieces.get(0).getRow() > b.NUM_ROWS)
        {
            return false;
        }

        if(snakePieces.get(snakePieces.size()).getRow() < b.NUM_ROWS || snakePieces.get(snakePieces.size()).getRow() > b.NUM_ROWS)
        {
            return false;
        }

        return true;
    }

//    public boolean isApple()
//    {
//        int r = snakePieces.get(0).getRow();
//        int c = snakePieces.get(0).getCol();
//        if(r == b.getAppleRow() && c == b.getAppleCol())
//        {
//            return true;
//        }
//        return false;
//    }

    public void move()
    {
        snakePieces.remove(snakePieces.size()-1).setSnake(false);
        int r = snakePieces.get(0).getRow();
        int c = snakePieces.get(0).getCol();
        if(snakePieces.get(0).isHasApple())
        {
            snakePieces.get(0).setColor(Color.MAGENTA);
        }

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
        snakePieces.add(0, b.getPixel(r,c));
        snakePieces.get(0).setSnake(true);
        lastDirection = direction;
    }



}
