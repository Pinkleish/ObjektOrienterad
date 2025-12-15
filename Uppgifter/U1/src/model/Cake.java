package model;

public class Cake extends Pastries{
    public Cake(String name){
        super(name);
        this.setCost(100);
        cakeCreate(this);
    }

    public void calculateCost(Cake cake){
        this.setCost(cake.getCost() + cake.getTopping().getToppingPrice()+ cake.getFilling1().getFillingPrice()+ cake.getFilling2().getFillingPrice()+ cake.getSize().getSizePrice());
    }


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
        /*else if (cake.getName().equals("HemskTårta")){
            cake.setFilling1(Filling.VANILJKRAM);
            cake.setFilling2(Filling.SYLT);
            cake.setTopping(Topping.GRADDE);
            cake.setSize(Size.SIZE4);
        }*/
        calculateCost(cake);
    }

    @Override
    public String toString() {
        return getName() + ",  " + getSize() + ", " + getFilling1() + ", " + getFilling2() + ", " + getTopping() + ". Price: " + getCost();
    }
}
