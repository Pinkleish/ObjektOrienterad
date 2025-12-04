package model;

public enum Size {
    SIZE4(" 4 Slices",50),
    SIZE6(" 6 Slices",65),
    SIZE10(" 10 Slices",90),
    SIZE12(" 12 Slices",100),
    ;

    private final String name;
    private final int price;

    Size(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getSize(){
        return this.name;
    }

    public int getSizePrice(){
        return this.price;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}
