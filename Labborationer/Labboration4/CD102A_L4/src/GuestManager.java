import javax.swing.*;
public class GuestManager {
  private int nbrOfGuests = 0;
  private Guest[] guestList;
  public GuestManager(int maxNbrOfGuests){
    guestList = new Guest[maxNbrOfGuests];
  }
  public int getNbrOfGuests(){
    return nbrOfGuests;
  }
  public void addGuest(String lastName, String firstName, String street, String zipCode, String city, Countries country){
    Guest newGuest = new Guest(lastName, firstName, street, zipCode, city, country);

  }
  public void deleteGuestAt(int index){
    moveElementsToLeft(index);
  }
  private void moveElementsToLeft(int index){

  }
  private void increaseGuestList(){

  }
  public Guest getGuestAt(int index){
    return null;
  }
  public String[] getInfoStrings() {
    String[] infoStrings = new String[nbrOfGuests];
       return infoStrings;
  }

}
