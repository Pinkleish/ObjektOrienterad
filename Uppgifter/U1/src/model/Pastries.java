package model;


public abstract class Pastries {
    private Filling filling1;
    private Filling filling2;
    private Topping topping;
    private int cost;
    private Size size;
    private String name;

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

    public Filling getFilling1(){
        return this.filling1;
    }

    public void setFilling1(Filling filling1){
        this.filling1 = filling1;
    }

    public Filling getFilling2(){
        return this.filling2;
    }

    public void setFilling2(Filling filling2) {
        this.filling2 = filling2;
    }

    public Topping getTopping(){
        return this.topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;

    }

    public Size getSize(){
        return this.size;
    }

    public void setSize(Size size){
        this.size = size;
    }

    public abstract String toString();

}
