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
        if(computerScore >= 1 || playerScore >= 1) {
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
            g.drawString("Computer: " + computerScore, 50, 50);
            g.drawString("Player: " + playerScore, 50, 700);
        }
        if(GAMESTATES.isPause()) {
            g.setFont(new Font("Comic Sans Ms", Font.BOLD, 30));
            g.drawString("Game Paused", getWidth()/2 - 105, getHeight()/2 - 15);
            g.drawString("Press P", getWidth()/2 - 60, getHeight()/2 + 15);
        }
        if(GAMESTATES.isEnd()) {
            g.setFont(new Font("Comic Sans Ms", Font.BOLD, 30));
            g.drawString("Game Over", getWidth()/2 - 105, getHeight()/2 - 15);
            String winner = "Player";
            if(computerScore > playerScore) {
                winner = "Computer";
            }
            g.drawString(winner + " wins", getWidth()/2 - 105, getHeight()/2 + 15);
            g.drawString("ESC to Exit", getWidth()/2 - 105, getHeight()/2 + 50);
        }
        if(GAMESTATES.isMenu()) {
            g.setFont(new Font("Comic Sans Ms", Font.BOLD, 60));
            g.drawString("V.S. Two Pong Breaker", getWidth()/7, getHeight()/2-50);
            g.setFont(new Font("Comic Sans Ms", Font.BOLD, 30));
            g.drawString("Press Space", getWidth()/2 - 105, getHeight()/2+50);
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

}
