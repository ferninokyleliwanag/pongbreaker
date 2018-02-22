import java.awt.*;

public class Paddle {
    //paddle coordinates
    private int x, y;
    //paddle size
    private final int WIDTH = 100, HEIGTH = 15;
    Board board;
    Ball ball;
    Game game;

    public Paddle(Board board, Game game, Ball ball){
        this.board = board;
        this.game = game;
        this.ball = ball;
        //original coordinates
        x = 0;
        y = 0;
    }

    public void move(){
        //if left is pressed move left
        if(game.isLeftPressed()){
            if( x > 0){
                x -= 5;
            }
        }
        //if right is pressed move right
        if(game.isRightPressed()){
            if( x + WIDTH < board.getWidth()){
                x += 5;
            }
        }

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

    //AI MOVEMENT
    public void moveAI(){
        if(ball.getX() + ball.getDiameter() > board.getHeight()/2){
            if(ball.getY() > WIDTH/2){
                x += 3;
            }
            if(ball.getY() < WIDTH/2){
                x -= 3;
            }
        }
    }




}
