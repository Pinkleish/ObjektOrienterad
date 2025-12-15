package Model;

public class Planet {

    private String name;
    private double mass;

    public Planet(){
        this("Unknown", 0);
    }

    public Planet(String name, double mass){
        this.name = name;
        this.mass = mass;
    }

    public String getName(){
        return this.name;
    }

    public double getMass(){
        return this.mass;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setMass(double newMass){
        this.mass = newMass;
    }

    public String toString(){
        return this.name;
    }
}
