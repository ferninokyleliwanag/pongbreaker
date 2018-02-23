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
    int playerScore = 0;
    int computerScore = 0;
    Paddle pPaddle;
    Paddle cPaddle;
    Ball ball;
    ArrayList<Brick> bricks;
    Timer timer;


    public Board(Game game){
        setPreferredSize(new Dimension(1000,800));
        setBackground(Color.BLACK);
        pPaddle = new Paddle(this, game, ball);
        cPaddle = new Paddle(this, game, ball);
        ball = new Ball(this);
        bricks = new ArrayList<Brick>();
    }

    //start the game
    public void GameStart(){
        //original rendering of graphics
        pPaddle.setPosition(getWidth()/2, getHeight()-EDGESPAGE);
        cPaddle.setPosition(getWidth()/2, EDGESPAGE);
        ball.setPosition(getWidth()/2, getHeight()/2);
        loadBricks();
        timer = new Timer(1000/60, this);
        playerScore = 0;
        computerScore = 0;
        timer.start();
    }

    public void resetBoard() {
        ball.setPosition(getWidth()/2, getHeight()/2);
        loadBricks();
    }

    @Override
    public void paintComponent(Graphics g){
        //call JPANEL paint component
        super.paintComponent(g);
        //set render color to white
        g.setColor(Color.WHITE);
        //end game when someone gets score
        if(computerScore >= 3 || playerScore >= 3) {
            GAMESTATES.endGame();
            GAMESTATES.stopMenu();
            GAMESTATES.stopPause();
            GAMESTATES.stopPlay();
        }
        //paint objects if the game is playing
        if(GAMESTATES.isPlay()) {
            pPaddle.paint(g);
            cPaddle.paint(g);
            ball.paint(g);
            for (int i = 0; i < bricks.size(); i++) {
                bricks.get(i).paint(g);
            }
            //paint score
            printSimpleString("Computer: " + computerScore, WIDTH, 50, 50, g);
            printSimpleString("Player: " + playerScore, WIDTH, 50, 700, g);
        }
        if(GAMESTATES.isPause()) {
            g.setFont(new Font("Comic Sans Ms", Font.BOLD, 30));
            printSimpleString("Game Paused", WIDTH, getWidth()/2, getHeight()/2, g);
            printSimpleString("Press P", WIDTH, getWidth()/2, getHeight()/2 + 30, g);
        }
        if(GAMESTATES.isEnd()) {
            g.setFont(new Font("Comic Sans Ms", Font.BOLD, 30));
            printSimpleString("Game Over", WIDTH, getWidth()/2, getHeight()/2 - 15, g);
            String winner = "Player";
            if(computerScore > playerScore) {
                winner = "Computer";
            }
            printSimpleString(winner + " wins", WIDTH, getWidth()/2, getHeight()/2 + 15, g);
            printSimpleString("ESC to Exit", WIDTH, getWidth()/2, getHeight()/2 + 50, g);
        }
        if(GAMESTATES.isMenu()) {
            g.setFont(new Font("Comic Sans Ms", Font.BOLD, 60));
            printSimpleString("V.S. Two Pong Breaker", WIDTH, getWidth()/2, getHeight()/2-50, g);
            g.setFont(new Font("Comic Sans Ms", Font.BOLD, 30));
            printSimpleString("Press Space", WIDTH, getWidth()/2, getHeight()/2+50, g);
        }
    }

    public void addBrick(int x, int y){
        Brick brick = new Brick();
        brick.setPosition(x,y);
        bricks.add(brick);
    }

    public void loadBricks() {
        bricks.clear();
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

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        //returns the LENGTH of the STRING parameter to the variable stringLen
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        //determines the center of the WIDTH parameter and subtracts the center of the length
        //to determine the X value to start the string
        int start = width/2 - stringLen/2;
        //prints s at the desired X position with adjustment and the desired y.
        g2d.drawString(s, start + XPos, YPos);
    }

}
