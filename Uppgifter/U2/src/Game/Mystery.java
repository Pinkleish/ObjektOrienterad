package Game;

public class Mystery implements PlaceablePosition, PlaceableIcon {
    private String mysteryIcon;
    private int mysteryHeight;
    private int mysteryWidth;

    public Mystery(String mysteryIcon){
        this.mysteryIcon = mysteryIcon;
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
