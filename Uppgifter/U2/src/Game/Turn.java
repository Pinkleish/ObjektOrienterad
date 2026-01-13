package Game;


public class Turn {
    private int counter = 0;


    public Turn(){
        this.counter = 1;

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



}


