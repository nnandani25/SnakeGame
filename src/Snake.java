import java.util.ArrayList;

public class Snake {

    int headX;
    int headY;
    int tailX;
    int tailY;
    int dx;
    int dy;
    ArrayList<Pixel> snakePieces = new ArrayList<Pixel>();

    public Snake()
    {

    }

    public int getHeadX() {
        return headX;
    }

    public int getHeadY() {
        return headY;
    }

    public int getTailX() {
        return tailX;
    }

    public int getTailY() {
        return tailY;
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

    public void move()
    {

    }

    public void draw()
    {


    }
}
