public class Apartment {

    private int apartmentNumber;
    private int area;
    private String tenant;
    private int rent;
    private String address;

    public Apartment(int apartmentNumber, int area, String adress){
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.address = address;
    }
    public int getApartmentNumber(){
        return this.apartmentNumber;
    }
    public int getArea(){
        return this.area;
    }
    public String getTenant(){
        return this.tenant;
    }
    public int getRent(){
        return rent;
    }
    public void setRent(int newRent){
        this.rent = newRent;
    }
}
