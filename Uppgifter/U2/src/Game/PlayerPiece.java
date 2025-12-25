package Game;

public class PlayerPiece implements PlaceablePosition {

    private int playerPieceHeight;
    private int playerPieceWidth;

    public PlayerPiece(int playerPieceHeight, int playerPieceWidth){
        this.playerPieceHeight = playerPieceHeight;
        this.playerPieceWidth = playerPieceWidth;
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
}
