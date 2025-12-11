package model;

import static model.Filling.SYLT;

public abstract class Pastries {
    protected Filling filling1;
    protected Filling filling2;
    protected Topping topping;
    protected int cost;
    protected Size size;
    protected String name;

    public Pastries(String name){
        this.name = name;
    }


    public abstract String getName();

    public abstract int getCost();

    public abstract String toString();








}
