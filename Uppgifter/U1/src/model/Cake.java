package model;


public class Cake extends Pastries{
    private Filling filling1;
    private Filling filling2;
    private Topping topping;
    private Size size;

    public Cake(String name){
        super(name);
        this.setCost(100);
        cakeCreate(this);
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

    public void calculateCost(Cake cake){
        this.setCost(cake.getCost() + cake.getTopping().getToppingPrice()+ cake.getFilling1().getFillingPrice()+ cake.getFilling2().getFillingPrice()+ cake.getSize().getSizePrice());
    }


    public void cakeCreate(Cake cake){
        if (this.getName().equals("Prinsesstårta")){
            this.setFilling1(Filling.GRADDE);
            this.setFilling2(Filling.MANDELMASSA);
            this.setTopping(Topping.MARSIPAN);
            this.setSize(Size.SIZE6);
        }
        else if (cake.getName().equals("Chokladtårta")){
            this.setFilling1(Filling.CHOKLAD);
            this.setFilling2(Filling.CHOKLAD);
            this.setTopping(Topping.CHOKLADSAS);
            this.setSize(Size.SIZE10);
        }
        else if (cake.getName().equals("Gräddtårta")){
            this.setFilling1(Filling.GRADDE);
            this.setFilling2(Filling.SYLT);
            this.setTopping(Topping.STROSSEL);
            this.setSize(Size.SIZE12);
        }

        calculateCost(cake);
    }

    @Override
    public String toString() {
        return getName() + ",  " + getSize() + ", " + getFilling1() + ", " + getFilling2() + ", " + getTopping() + ". Price: " + getCost();
    }
}
