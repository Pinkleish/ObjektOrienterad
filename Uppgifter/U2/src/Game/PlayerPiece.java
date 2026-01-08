package Game;

public class PlayerPiece implements PlaceablePosition {

    private int playerPieceHeight;
    private int playerPieceWidth;
    private String playerPieceIcon;
    private int playerID;

    public PlayerPiece(int playerPieceHeight, int playerPieceWidth,String playerPieceIcon){
        this.playerPieceHeight = playerPieceHeight;
        this.playerPieceWidth = playerPieceWidth;
        this.playerPieceIcon = playerPieceIcon;
    }
    
    // Måste inte height och width vara bestämt?


    @Override
    public void setPieceHeight(int height) {
        this.playerPieceHeight = height;
    }

    @Override
    public void setPieceWidth(int width) {
        this.playerPieceWidth = width;
    }

    @Override
    public int getPieceHeight() {
        return playerPieceHeight;
    }

    @Override
    public int getPieceWidth() {
        return playerPieceWidth;
    }

    @Override
    public int getID() {
        return this.playerID;
    }

    @Override
    public void setID(int ID) {
        this.playerID = ID;
    }

    @Override
    public void setIcon(String icon) {
        this.playerPieceIcon = icon;
    }

    @Override
    public String getIcon() {
        return this.playerPieceIcon;
    }
}
