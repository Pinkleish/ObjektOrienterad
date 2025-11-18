package L3Uppgift1;

public class DogOwner {
    private String address;
    private String name;
    private int numberOfDogs;
    private Dog dogOne;
    private Dog dogTwo;

    public DogOwner(String name, String address, int numberOfDogs){
        this.name = name;
        this.address = address;
        this.numberOfDogs = numberOfDogs;
        if (numberOfDogs == 1){
            dogOne = new Dog();
        }
        else if (numberOfDogs == 2){
            dogOne = new Dog();
            dogTwo = new Dog();
        }
    }
    public String getAddress(){
        return this.address;
    }
    public String setAddress(String address){
        this.address = address;
        return this.address;
    }
    public Dog getDogOne(){
        return this.dogOne;
    }
    public Dog getDogTwo(){
        return this.dogTwo;
    }
    public String getName(){
        return this.name;
    }
    public int getNumberOfDogs(){
        return this.numberOfDogs;
    }
}
