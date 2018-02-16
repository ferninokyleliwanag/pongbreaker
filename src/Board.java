import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    //edgespace to push play paddle up
    private final int EDGESPAGE = 50;
    private final int BRICKNUMBER = 7;
    Paddle pPaddle;
    Paddle cPaddle;
    Ball ball;
    Brick brick;
    ArrayList<Brick> bricks;


    public Board(){
        setPreferredSize(new Dimension(1000,800));
        setBackground(Color.BLACK);
        pPaddle = new Paddle();
        cPaddle = new Paddle();
        ball = new Ball();
        brick = new Brick();
        bricks = new ArrayList<Brick>();
    }

    //start the game
    public void GameStart(){
        //original rendering of graphics
        pPaddle.setPosition(getWidth()/2, getHeight()-EDGESPAGE);
        cPaddle.setPosition(getWidth()/2, EDGESPAGE);
        ball.setPosition(getWidth()/2, getHeight()/2);
        //set bricks separately;
        int x = 0;
        for(int i = 0; i <= BRICKNUMBER; i++){
            for(int j= 0; j <= BRICKNUMBER; j++) {
                addBrick(50 + x, getHeight()/2);
                x += 100;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g){
        //call JPANEL paint component
        super.paintComponent(g);
        //set render color to white
        g.setColor(Color.WHITE);
        //paint objects if the game is playing
            pPaddle.paint(g);
            cPaddle.paint(g);
            ball.paint(g);
            for(int i = 0; i<bricks.size(); i++){
                bricks.get(i).paint(g);
            }
    }

    public void addBrick(int x, int y){
        Brick brick = new Brick();
        brick.setPosition(x,y);
        bricks.add(brick);
    }






}
