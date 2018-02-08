import javax.swing.*;

public class Game extends JFrame {

    private Board board;

    public Game(){
        setResizable(false);
        setVisible(true);
        setFocusable(true);
        setTitle("V.S. Two Pong Breaker");
        board = new Board();
        add(board);
        pack();
        setLocationRelativeTo(null);
        board.GameStart();
    }

    public static void main (String[] args){
        new Game();
    }
}
