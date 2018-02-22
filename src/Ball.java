import java.awt.*;

public class Ball {

    final int diameter = 35;
    int x, y;
    final int SPEED = 3;
    double dx = SPEED, dy = SPEED;

    double MAXANGLE = 5*Math.PI/12;

    Board board;

    public Ball(Board board){
        this.board = board;
        x = 0;
        y = 0;
    }

    public void move(){
        //ball bounce top and bottom
        if( y+diameter > board.getHeight() || y < 0)
            dy *= -1;
        //ball bounce left and right
        if(x + diameter > board.getWidth() || x < 0){
            dx *= -1;
        }

        x += dx;
        y += dy;
    }

    //makes position relative to middle of the ball
    public void setPosition( int x, int y){
        this.x = x - diameter/2;
        this.y = y - diameter/2;
    }

    public void paint(Graphics g){
        g.fillOval(x, y, diameter, diameter);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getDiameter(){
        return diameter;
    }

}
