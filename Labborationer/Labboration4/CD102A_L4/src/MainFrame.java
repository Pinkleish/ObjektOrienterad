import javax.swing.*;

public class MainFrame extends JFrame {
    private int width = 810;
    private int height = 410;
    Controller controller;
    public MainFrame(Controller controller) {
        this.controller = controller;
        setupFrame();
    }
    public void setupFrame() {

    }
    public String getFirstNameText() {
        return "";
    }
    public void setFirstNameText(String str) {

    }
    public String getLastNameText() {
        return "";
    }
    public void setLastNameText(String str) {

    }
    public String getStreetText() {
       return "";
    }
    public void setStreetText(String str) {

    }
    public String getCityText() {
        return "";
    }
    public void setCityText(String str) {

    }
    public String getZipCodeText() {
        return "";
    }
    public void setZipCodeText(String str) {

    }
    public void setNumGuest(String str) {

    }
    public Object getCountriesItem(){
        return "";
    }
    public void setCountriesItem(Object item){

    }
    public void errMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    public void updateGuestList(String [] stringList) {

    }
    public int getListIndex() {
        return -1;
    }
}
