package Game;

/**
 * Representerar en spelarpjäs i spelet.
 * <p>
 * Klassen implementerar {@link PlaceablePosition} och innehåller information
 * om pjäsens höjd, bredd och vilket ID spelaren har.
 * </p>
 *
 * @author Axel Dahl
 */
public class PlayerPiece implements PlaceablePosition {

    private int playerPieceHeight;
    private int playerPieceWidth;
    private int playerID;

    /**
     * Skapar en ny spelarpjäs med angiven höjd och bredd.
     *
     * @param playerPieceHeight höjden på spelarpjäsen
     * @param playerPieceWidth  bredden på spelarpjäsen
     * @author Axel Dahl
     */
    public PlayerPiece(int playerPieceHeight, int playerPieceWidth){
        this.playerPieceHeight = playerPieceHeight;
        this.playerPieceWidth = playerPieceWidth;
    }

    /**
     * Sätter höjden på spelarpjäsen.
     *
     * @param height den nya höjden
     * @author Axel Dahl
     */
    @Override
    public void setPieceHeight(int height) {
        this.playerPieceHeight = height;
    }

    /**
     * Sätter bredden på spelarpjäsen.
     *
     * @param width den nya bredden
     * @author Axel Dahl
     */
    @Override
    public void setPieceWidth(int width) {
        this.playerPieceWidth = width;
    }

    /**
     * Hämtar höjden på spelarpjäsen.
     *
     * @return höjden på spelarpjäsen
     * @author Axel Dahl
     */
    @Override
    public int getPieceHeight() {
        return playerPieceHeight;
    }

    /**
     * Hämtar bredden på spelarpjäsen.
     *
     * @return bredden på spelarpjäsen
     * @author Axel Dahl
     */
    @Override
    public int getPieceWidth() {
        return playerPieceWidth;
    }

    /**
     * Hämtar spelarens ID.
     *
     * @return spelarens ID
     * @author Axel Dahl
     */
    @Override
    public int getID() {
        return this.playerID;
    }

    /**
     * Sätter spelarens ID.
     *
     * @param ID det nya spelar-ID:t
     * @author Axel Dahl
     */
    @Override
    public void setID(int ID) {
        this.playerID = ID;
    }

}
