import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Brick {
    private int x, y;
    private final int WIDTH = 50, HEIGHT = 15;

    //initial position of each brick
    public Brick(){
        x = 0;
        y = 0;

    }


    //set position relative to middle of the brick
    public void setPosition(int x, int y){
        this.x = x - WIDTH/2;
        this.y = y - HEIGHT/2;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g){
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

}