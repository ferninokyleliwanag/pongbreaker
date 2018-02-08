import java.awt.*;

public class Paddle {
    //paddle coordinates
    private int x, y;
    //paddle size
    private final int WIDTH = 100, HEIGTH = 25;

    public Paddle(){
        //original coordinates
        x = 0;
        y = 0;
    }

    //set position of paddle
    public void setPosition(int x, int y){
        //position is set relative to middle of paddle
        this.x = x - WIDTH/2;
        this.y = y - HEIGTH/2;
    }

    //paint paddle
    public void paint(Graphics g){
        g.fillRect(x, y, WIDTH, HEIGTH);
    }
}
