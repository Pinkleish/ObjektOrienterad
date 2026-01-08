package Game;
import java.util.Random;

public class Mystery implements PlaceablePosition, PlaceableIcon {
    private String mysteryIcon;
    private int mysteryHeight;
    private int mysteryWidth;
    private String mysteryName;
    private int mysteryID;


    public Mystery(String mysteryIcon) {
        Random r = new Random();
        int selectedMystery = r.nextInt(1, 7);
        this.mysteryName = setMysteryName(selectedMystery);
        this.mysteryIcon = mysteryIcon;

    }


    public String setMysteryName(int number) {
        switch (number) {
            case 1:
                this.mysteryName = "Tidshopp";
                setID(1);
                // Skippar motståndarens tur
                break;
            case 2:
                this.mysteryName = "Narcissus";
                setID(2);
                // Skippar din tur
                break;
            case 3:
                this.mysteryName = "AdditivaMetoder";
                setID(3);
                // Alla platser fylls med dina pjäser. Förutom diagonalt.
                break;
            case 4:
                this.mysteryName = "Multiplicitet";
                setID(4);
                // Platserna diagonalt samt i mitten fylls med dina pjäser.
                break;
            case 5:
                this.mysteryName = "Avgrundsvrål";
                setID(5);
                // Alla pjäser försvinner runt dig.
                break;
            case 6:
                this.mysteryName = "Demagog";
                setID(6);
                // Alla platser runt om dig blir till motståndarens. Förutom mysteriumets.
                break;
        }
        return mysteryName;

    }

    @Override
    public void setPieceHeight(int height) {
        this.mysteryHeight = height;
    }

    @Override
    public void setPieceWidth(int width) {
        this.mysteryWidth = width;
    }

    @Override
    public int getPieceHeight() {
        return this.mysteryHeight;
    }

    @Override
    public int getPieceWidth() {
        return mysteryWidth;
    }


    public int getID() {
        return this.mysteryID;
    }

    public void setID(int ID) {
        this.mysteryID = ID;
    }

    public String getMysteryIcon(){
       return this.mysteryIcon;
    }

    @Override
    public void setIcon(String icon) {
        this.mysteryIcon = icon;
    }

    @Override
    public String getIcon() {
        return this.mysteryIcon;
    }

}
