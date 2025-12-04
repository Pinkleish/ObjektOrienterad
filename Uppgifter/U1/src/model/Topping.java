package model;

public enum Topping {
    STROSSEL("Strössel",5),
    MARSIPAN("Marsipan",10),
    GLASSYR("Glassyr",12),
    CHOKLADSAS("Chokladsås",15),
    GRADDE("Grädde",5);

    private final String name;
    private final int price;

    Topping(String name,int price){
        this.name = name;
        this.price = price;
    }

    public String getToppingName(){
        return this.name;
    }
    public int getToppingPrice(){
        return this.price;
    }


    @Override
    public String toString() {
        return name + " ";
    }
}
