import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    Paddle pPaddle;

    public Board(){
        setPreferredSize(new Dimension(1000,800));
        setBackground(Color.BLACK);
        pPaddle = new Paddle();
    }

    //start the game
    public void GameStart(){
        //original rendering of graphics
        pPaddle.setPosition(50, getHeight()/2);
    }

    @Override
    public void paintComponent(Graphics g){
        //call JPANEL paint component
        super.paintComponent(g);
        //set render color to white
        g.setColor(Color.WHITE);
        //paint objects if the game is playing
            pPaddle.paint(g);
    }

















}
