package model;

public class PerUnitItems extends Pastries {


    public PerUnitItems(String name){
        super(name);
        createPerUnitItem(this);
    }

    public void createPerUnitItem(PerUnitItems perUnitItem){
        if(perUnitItem.getName().equals("Vetebulle")){
            perUnitItem.setCost(15);
        }
        else if(perUnitItem.getName().equals("Pepparkaka")){
            perUnitItem.setCost(10);
        }
        else if(perUnitItem.getName().equals("Hallongrotta")){
            perUnitItem.setCost(25);
        }

    }

    @Override
    public String toString() {
        return getName() + ", Price: " + getCost();
    }
}

