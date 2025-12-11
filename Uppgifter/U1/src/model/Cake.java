package model;

public class Cake extends Pastries{
    public Cake(String name){
        super(name);
        this.cost = 100;
        cakeCreate(this);


    }
    public Size getSize(){
        return size;
    }
    public Filling getFilling1(){
        return filling1;
    }

    public Filling getFilling2(){
        return filling2;
    }

    public Topping getTopping(){
        return topping;
    }

    public String getName(){
        return name;
    }
    public void calculateCost(Cake cake){
        this.cost += cost+ cake.topping.getToppingPrice()+ cake.filling1.getFillingPrice()+ cake.filling2.getFillingPrice()+ cake.size.getSizePrice();
    }

    public int getCost(){
        return cost;
    }

    public void setFilling1(Filling filling1){
        this.filling1 = filling1;
    }
    public void setFilling2(Filling filling2) {
        this.filling2 = filling2;
    }
    public void setTopping(Topping topping) {
        this.topping = topping;

    }
    public void setSize(Size size){
        this.size = size;
    }
    //public Size getSize(){
        //return Size.getSize();


    public void cakeCreate(Cake cake){
        if (cake.getName().equals("Prinsesstårta")){
            cake.setFilling1(Filling.GRADDE);
            cake.setFilling2(Filling.MANDELMASSA);
            cake.setTopping(Topping.MARSIPAN);
            cake.setSize(Size.SIZE6);
        }
        else if (cake.getName().equals("Chokladtårta")){
            cake.setFilling1(Filling.CHOKLAD);
            cake.setFilling2(Filling.CHOKLAD);
            cake.setTopping(Topping.CHOKLADSAS);
            cake.setSize(Size.SIZE10);
        }
        else if (cake.getName().equals("Gräddtårta")){
            cake.setFilling1(Filling.GRADDE);
            cake.setFilling2(Filling.SYLT);
            cake.setTopping(Topping.STROSSEL);
            cake.setSize(Size.SIZE12);
        }
        calculateCost(cake);
    }

    @Override
    public String toString() {
        return name + ", Slices: " + size + ", " + filling1 + ", " + filling2 + ", " + topping + ". Price: " + cost;
    }
}
