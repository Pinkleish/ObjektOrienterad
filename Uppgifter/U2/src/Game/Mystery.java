package Game;
import java.util.Random;

/**
 * Representerar ett mysterium i spelet
 * Klassen implementerar PlaceablePosition och innehåller information
 * om pjäsens höjd, bredd och vilket ID spelaren har.
 *
 * @author Kasper Åkesson
 * @author Axel Dahl
 */

public class Mystery implements PlaceablePosition{
    private int mysteryHeight;
    private int mysteryWidth;
    private String mysteryName;
    private int mysteryID;

    /**
     * Skapar en ny mysteriepjäs. Random mellan tishopp, additivametoder och demagog
     *
     * @author Kasper Åkesson
     */
    public Mystery() {
        Random r = new Random();
        int selectedMystery = r.nextInt(1, 4);
        this.mysteryName = setMysteryName(selectedMystery);

    }


    /**
     * Sätter namn och ID på mysteriet som skickas in
     * @param number vilket mysterie
     * @return mystery name
     *
     * @author Kasper Åkesson
     *
     */
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


    /**
     * Sätter höjd height på mysteriet
     * @param height
     * @author Kasper Åkesson
     * @author Axel Dahl
     */

    @Override
    public void setPieceHeight(int height) {
        this.mysteryHeight = height;
    }

    /**
     * Sätter bredd width på mysteriet
     * @param width
     * @author Kasper Åkesson
     * @author Axel Dahl
     */

    @Override
    public void setPieceWidth(int width) {
        this.mysteryWidth = width;
    }

    /**
     * hämtar höjd height på mysteriet
     * @return height
     * @author Kasper Åkesson
     * @author Axel Dahl
     */

    @Override
    public int getPieceHeight() {
        return this.mysteryHeight;
    }

    /**
     * hämtar bredden width på mysteriet
     * @return int width
     * @author Kasper Åkesson
     * @author Axel Dahl
     */

    @Override
    public int getPieceWidth() {
        return mysteryWidth;
    }


    /**
     * Hämtar ID på mysteriet
     * @return int ID
     *
     * @author Kasper Åkesson
     */

    public int getID() {
        return this.mysteryID;
    }
    /**
     * sätter ID på mysteriet
     * @param ID
     * @author Kasper Åkesson
     */

    public void setID(int ID) {
        this.mysteryID = ID;
    }







}
