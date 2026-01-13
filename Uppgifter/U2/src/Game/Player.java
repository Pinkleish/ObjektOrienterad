package Game;

import java.util.ArrayList;

/**
 * Representerar en spelare i spelet.
 * <p>
 * Klassen hanterar spelarens ikon, poäng och de spelarpjäser som tillhör spelaren.
 * </p>
 *
 * @author Axel Dahl
 * @author Kasper Åkesson
 */
public class Player {
    private String playerIcon;
    private ArrayList<PlayerPiece> playerPieces = new ArrayList<>();
    private int playerScore;

    /**
     * Skapar en ny spelare med angiven ikon.
     *
     * @param playerIcon spelarens ikon som används för att identifiera spelaren
     * @author Axel Dahl
     */
    public Player(String playerIcon){
        this.playerIcon = playerIcon;
    }

    /**
     * Lägger till en ny spelarpjäs för spelaren med angiven höjd och bredd.
     *
     * @param height höjden på den nya spelarpjäsen
     * @param width  bredden på den nya spelarpjäsen
     * @author Axel Dahl
     */
    public void addPlayerPiece(int height, int width){
        PlayerPiece playerPiece = new PlayerPiece(height, width);
        playerPieces.add(playerPiece);
    }

    /**
     * Hämtar en lista över spelarens alla spelarpjäser.
     *
     * @return en ArrayList med spelarens spelarpjäser
     * @author Axel Dahl
     */
    public ArrayList<PlayerPiece> getPlayerPieces(){
        return playerPieces;
    }

    /**
     * Hämtar spelarens ikon.
     *
     * @return spelarens ikon som en sträng
     * @author Axel Dahl
     */
    public String getPlayerIcon(){
        return this.playerIcon;
    }

    /**
     * Sätter spelarens poäng.
     *
     * @param score den nya poängen för spelaren
     * @author Kasper Åkesson
     */
    public void setScore(int score){
        this.playerScore = score;
    }

    /**
     * Hämtar spelarens poäng.
     *
     * @return spelarens aktuella poäng
     * @author Kasper Åkesson
     */
    public int getScore(){
        return this.playerScore;
    }
}
