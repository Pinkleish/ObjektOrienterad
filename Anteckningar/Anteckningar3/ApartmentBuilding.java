public class ApartmentBuilding {

    private String address;
    private int numberOfEntrances;
    private Apartment[] apartments;

    public ApartmentBuilding(int doors){
        this.numberOfEntrances = doors;
        this.address = "cool address";

        this.apartments = new Apartment[4];

        this.apartments[0] = new Apartment(1101,57,this.address);

        System.out.println(apartments);
        for ( int i = 0; i < this.apartments.length; i++){
            System.out.println(this.apartments[i]);
        }
    }
    public int getLiavableArea(){
        int area = 0;
        for (Apartment apartment : this.apartments){
            area += apartment.getArea();
        }
    }
}
