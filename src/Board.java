import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener{
    //edgespace to push play paddle up
    private final int EDGESPAGE = 50;
    private final int BRICKSROW = 3;
    private final int BRICKSCOLUMN = 10;
    Paddle pPaddle;
    Paddle cPaddle;
    Ball ball;
    Brick brick;
    ArrayList<Brick> bricks;
    Timer timer;


    public Board(Game game){
        setPreferredSize(new Dimension(1000,800));
        setBackground(Color.BLACK);
        pPaddle = new Paddle(this, game, ball);
        cPaddle = new Paddle(this, game, ball);
        ball = new Ball(this);
        brick = new Brick();
        bricks = new ArrayList<Brick>();
    }

    //start the game
    public void GameStart(){
        //original rendering of graphics
        pPaddle.setPosition(getWidth()/2, getHeight()-EDGESPAGE);
        cPaddle.setPosition(getWidth()/2, EDGESPAGE);
        ball.setPosition(getWidth()/2, getHeight()/2);
        //for the bricks
        int x = 0;
        int y = 0;
        for(int i = 0; i < BRICKSROW; i++){
            for(int j = 0; j < BRICKSCOLUMN; j++ ){
                addBrick(EDGESPAGE + x, 300 + y);
                x += 100;
            }
            x = 0;
            y += 100;
        }
        timer = new Timer(1000/60, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        //call JPANEL paint component
        super.paintComponent(g);
        //set render color to white
        g.setColor(Color.WHITE);
        //paint objects if the game is playing
        if(GAMESTATES.isPlay()) {
            pPaddle.paint(g);
            cPaddle.paint(g);
            ball.paint(g);
            for (int i = 0; i < bricks.size(); i++) {
                bricks.get(i).paint(g);
            }
        }
    }

    public void addBrick(int x, int y){
        Brick brick = new Brick();
        brick.setPosition(x,y);
        bricks.add(brick);
    }


    //game updating and rendering
    @Override
    public void actionPerformed(ActionEvent e) {

    if(GAMESTATES.isPlay()){
        ball.move();
        pPaddle.move();
        cPaddle.moveAI();
    }

    repaint();

    }

    public int getEDGESPAGE(){
        return EDGESPAGE;
    }

}
