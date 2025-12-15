package model;

import java.util.ArrayList;

public class Order {
    private ArrayList<Pastries> pastries = new ArrayList<>();



    public void addToOrder(Pastries pastries){
        this.pastries.add(pastries);
    }

    public double getCost(){
        return pastries.stream().mapToDouble(Pastries::getCost).sum();
    }

    public String[] toStringArray(){
       return pastries.stream().map(Pastries::toString).toArray(String[]::new);
    }


}
