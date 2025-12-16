package model;


public abstract class Pastries {
    private String name;
    private int cost;

    public Pastries(String name){
        this.name = name;
    }


    public String getName(){
        return this.name;
    }

    public int getCost(){
        return this.cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }



    public abstract String toString();

}
