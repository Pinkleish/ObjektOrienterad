package View;

public enum ItemTypes {

    STARSYSTEM("Starsystem"),
    PLANET("Planet");

    String name;

    ItemTypes(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

}
