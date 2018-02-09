import java.awt.*;

public class Ball {

    final int diameter = 35;
    int x, y;

    public Ball(){
        x = 0;
        y = 0;
    }

    //makes position relative to middle of the ball
    public void setPosition( int x, int y){
        this.x = x - diameter/2;
        this.y = y - diameter/2;
    }

    public void paint(Graphics g){
        g.fillOval(x, y, diameter, diameter);
    }

}
