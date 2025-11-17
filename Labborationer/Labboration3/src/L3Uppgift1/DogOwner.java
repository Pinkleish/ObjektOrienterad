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
        Dog dog1 = new Dog();
        if (numberOfDogs < 1){
            Dog dog2 = new Dog();
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
