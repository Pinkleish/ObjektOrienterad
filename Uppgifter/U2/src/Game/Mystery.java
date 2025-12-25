package Game;
import java.util.Random;

public class Mystery implements PlaceablePosition, PlaceableIcon {
    private String mysteryIcon;
    private int mysteryHeight;
    private int mysteryWidth;
    private String mysteryName;


    public Mystery(String mysteryIcon) {
        Random r = new Random();
        int selectedMystery = r.nextInt(1, 7);
        setMysteryName(selectedMystery);
        this.mysteryIcon = mysteryIcon;
    }


    public String setMysteryName(int number) {
        switch (number) {
            case 1:
                this.mysteryName = "Tidshopp";

                break;
            case 2:
                this.mysteryName = "Narcissus";
                break;
            case 3:
                this.mysteryName = "AdditivaMetoder";
                break;
            case 4:
                this.mysteryName = "Multiplicitet";
                break;
            case 5:
                this.mysteryName = "Avgrundsvrål";
                break;
            case 6:
                this.mysteryName = "Demagog";
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
