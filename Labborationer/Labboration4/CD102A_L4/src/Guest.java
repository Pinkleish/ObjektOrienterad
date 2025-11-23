public class Guest {
    private String firstName;
    private String lastName;
    private Address address;

    public Guest(){
        this(null, null, null);
    }

    public Guest(String lastName, String firstName, Address address){


    }

    public Guest(String lastName, String firstName, String street, String zipCode, String city, Countries country){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

    }

    public String getStreet() {
        return address.getStreet();
    }

    public void setStreet(String street) {
       address.setStreet(street);
    }

    public String getZipCode() {
        return address.getZipCode();
    }

    public void setZipCode(String zipCode) {
        address.setZipCode(zipCode);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public Countries getCountry() {
        return address.getCountry();
    }

    public void setCountry(Countries country) {
        address.setCountry(country);
    }

    public String toString(){
        return this.lastName+", "+this.firstName+", "+address.toString();
    }
}
