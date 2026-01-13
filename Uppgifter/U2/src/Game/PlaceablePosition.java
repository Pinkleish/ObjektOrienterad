package Game;

/**
 * Representerar en position som kan placeras på spelbrädet.
 * <p>
 * Interfacet definierar metoder för att sätta och hämta höjd, bredd
 * samt ett unikt ID för objekt som implementerar detta interface.
 * </p>
 *
 * @author Axel Dahl
 * @author Kasper Åkesson
 */
public interface PlaceablePosition {

    /**
     * Sätter höjden på objektet.
     *
     * @param height höjden som ska sättas
     * @author Axel Dahl
     */
    public void setPieceHeight(int height);

    /**
     * Sätter bredden på objektet.
     *
     * @param width bredden som ska sättas
     * @author Axel Dahl
     */
    public void setPieceWidth(int width);

    /**
     * Hämtar höjden på objektet.
     *
     * @return höjden på objektet
     * @author Axel Dahl
     */
    public int getPieceHeight();

    /**
     * Hämtar bredden på objektet.
     *
     * @return bredden på objektet
     * @author Axel Dahl
     */
    public int getPieceWidth();

    /**
     * Hämtar det unika ID:t för objektet.
     *
     * @return ID:t för objektet
     * @author Kasper Åkesson
     */
    public int getID();

    /**
     * Sätter ett unikt ID för objektet.
     *
     * @param ID ID:t som ska sättas
     * @author Kasper Åkesson
     */
    public void setID(int ID);
}
