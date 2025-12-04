package model;

public enum Filling {
    SYLT("Sylt",50),
    GRADDE("Grädde",20),
    VANILJKRAM("Vaniljkräm",35),
    CHOKLAD("Choklad",60),
    MANDELMASSA("Mandelmassa",25);

    private final String name;
    private final int price;

    Filling(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getFillingName(){
        return this.name;
    }

    public int getFillingPrice(){
        return this.price;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}
