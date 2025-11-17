package L3Uppgift1;

public class DogOwner {
    private String address;
    private String name;
    private int numberOfDogs;
    private Dog dogOne;
    private Dog dogTwo;

    public void DogOwner(String name, String address, int numberOfDogs){
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
