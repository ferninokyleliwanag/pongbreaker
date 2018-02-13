import java.util.ArrayList;
import java.util.List;

public class BrickArray {

    List<Brick> bricks;

    public BrickArray(){
        bricks = new ArrayList<Brick>();
    }

    public void addBrick(Brick b){

        if( b != null) {
            for(int i = 0; i < 10; i++)
            bricks.add(b);
        }

    }

    public void removeBrick(Brick b){


    }
}
