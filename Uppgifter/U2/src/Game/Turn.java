package Game;
import java.util.Random;


public class Turn {
    private int counter = 0;


    public Turn(){
        //counter = startingTurn();
        this.counter = 0;

    }
    public int playTurn(){
        this.counter += 1;
        return this.counter;
    }

    public int checkTurn(){
        if (counter % 2 == 0){
            return 2;
        }
        else{
            return 1;
        }
    }

    public int startingTurn(){
        Random random = new Random();
        int start = random.nextInt(1, 3);
        return start;
    }

    public int getTurn(){
        return counter;
    }

    public int skipTurn(){
        counter = counter + 2;
        return counter;
    }

}


