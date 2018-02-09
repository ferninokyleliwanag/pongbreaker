import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Brick {
    private int brickLife = 3;
    private int x, y;
    List<Brick> bricks = new ArrayList<Brick>();;
    private final int WIDTH = 50, HEIGTH = 15;

    public Brick(){
        x = 0;
        y = 0;
    }

    //set position relative to middle of the brick
    public void setPosition(int x, int y){
        this.x = x - WIDTH/2;
        this.y = y - HEIGTH/2;
    }

    public void paint(Graphics g){
        g.fillRect(x, y, WIDTH, HEIGTH);
    }

    //add bricks to bricksArrayList
    public void addBrick(Brick brick){
        for(int i = 0; i < 4; i++)
        bricks.add(0, brick);
    }

}