import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Game extends JFrame implements KeyListener{

    private Board board;
    private boolean leftPressed, rightPressed;

    public Game(){
        setResizable(false);
        setVisible(true);
        setFocusable(true);
        setTitle("V.S. Two Pong Breaker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board = new Board(this);
        add(board);
        addKeyListener(this);
        pack();
        setLocationRelativeTo(null);
        board.GameStart();
    }

    public static void main (String[] args){
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){

        if(GAMESTATES.isMenu()) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                GAMESTATES.startPlay();
                GAMESTATES.stopMenu();
            }

        }
        if(GAMESTATES.isEnd()) {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){

            }
        }
        if (GAMESTATES.isPlay() || GAMESTATES.isPause()) {
            if(e.getKeyCode() == KeyEvent.VK_P){
                GAMESTATES.togglePause();
                GAMESTATES.togglePlay();
            }
        }
        if(GAMESTATES.isPlay()) {
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                leftPressed = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                rightPressed = true;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }

    }

    public boolean isLeftPressed(){
        return leftPressed;
    }

    public boolean isRightPressed(){
        return rightPressed;
    }

}
