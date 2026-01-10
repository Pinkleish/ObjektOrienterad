package Game;
import java.util.Random;

public class Mystery implements PlaceablePosition{
    private String mysteryIcon;
    private int mysteryHeight;
    private int mysteryWidth;
    private String mysteryName;
    private int mysteryID;


    public Mystery() {
        Random r = new Random();
        int selectedMystery = r.nextInt(1, 4);
        this.mysteryName = setMysteryName(selectedMystery);
        this.mysteryIcon = mysteryIcon;

    }


    public String setMysteryName(int number) {
        switch (number) {
            case 1:
                this.mysteryName = "Tidshopp";
                this.setID(1);
                // Skippar motståndarens tur
                break;
            case 2:
                this.mysteryName = "AdditivaMetoder";
                this.setID(2);
                //Alla platser runt om dig blir till motståndarens. Förutom mysteriumets.
                break;
            case 3:
                this.mysteryName = "Demagog";
                this.setID(3);
                break;


        }
        return this.mysteryName;
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
