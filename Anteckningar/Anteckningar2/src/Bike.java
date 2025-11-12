public class Bike {
    //Attribut
    private String color;
    private int gears;
    private String maker = "Monark";
    private Person owner;

    // Default konstruktor
    public Bike(){
        this.color = "black";
        this.gears = 1;
        this.maker = maker;
    }

    //Konstruktor
    public Bike(String color, int gears){
        this.color = color;
        this.gears = gears;
        this.maker = "Skeppshult";
    }

    // Metoder
    public void roll(){
        System.out.println("Min " + this.color + " cykel rullar");
    }
    public int getGears(){
        return this.gears;
    }
    public void setOwner(Person person){
        this.owner = person;
    }
    public Person getOwner(){
        return this.owner;
    }
}