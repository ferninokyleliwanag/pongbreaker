import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    //edgespace to push play paddle up
    private final int EDGESPAGE = 50;
    Paddle pPaddle;
    Paddle cPaddle;
    Ball ball;
    Brick brick;

    public Board(){
        setPreferredSize(new Dimension(1000,800));
        setBackground(Color.BLACK);
        pPaddle = new Paddle();
        cPaddle = new Paddle();
        ball = new Ball();
        brick = new Brick();
    }

    //start the game
    public void GameStart(){
        //original rendering of graphics
        pPaddle.setPosition(getWidth()/2, getHeight()-EDGESPAGE);
        cPaddle.setPosition(getWidth()/2, EDGESPAGE);
        ball.setPosition(getWidth()/2, getHeight()/2);
        brick.setPosition(getWidth()/2, getHeight()/2 + EDGESPAGE);
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
            //BRICK TEST
            brick.paint(g);
    }








}
