import java.awt.*;

public class Ball {

    final int diameter = 35;
    int x, y;
    final int SPEED = 5;
    double dx = SPEED, dy = SPEED;

    double MAXANGLE = 5*Math.PI/12;

    Board board;

    public Ball(Board board){
        this.board = board;
        x = 0;
        y = 0;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public void move(){
        int newX = x + diameter;
        int newY = y + diameter;
        if(y < 0) {
            board.playerScore++;
            board.resetBoard();
        }
        if(y > board.getHeight()) {
            board.computerScore++;
            board.resetBoard();
        }
        //ball bounce left and right
        if(newX > board.getWidth() || x < 0){
            dx *= -1;
        }
        //bounce off of ppaddle
        if(getRectangle().intersects(board.pPaddle.getRectangle())) {
            dy *= -1;
        }
        //bounce off of cpaddle
        if (getRectangle().intersects(board.cPaddle.getRectangle())) {
            dy *= -1;
        }
        for(int i = 0; i < board.bricks.size(); i++) {
           Brick brick = board.bricks.get(i);
           if(getRectangle().intersects(brick.getRectangle())) {
               board.bricks.remove(i);
               dy *= -1;
               break;
           }
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
