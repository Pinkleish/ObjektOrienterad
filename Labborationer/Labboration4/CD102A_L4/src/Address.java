public class Address {
    private String street;
    private String zipCode;
    private String city;
    private Countries country;

    public Address() {

  }

    public Address(String street, String zipCode, String city, Countries country){

  }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {

    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {

    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {

    }

    public String toString(){
        return this.street+", "+this.zipCode+", "+this.city+", "+this.country.toString();
    }

}
