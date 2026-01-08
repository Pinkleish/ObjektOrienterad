package Game;


import java.util.ArrayList;

public class Player {
    // Har en icon, en lista av placerade pjäser & poäng(inte implementerat än)
    private String playerIcon;
    private ArrayList<PlayerPiece> playerPieces = new ArrayList<>();
    private int playerScore;

    // Konstruktorn ger spelaren en ikon när objektet skapas
    public Player(String playerIcon){
        this.playerIcon = playerIcon;
    }
    // Skapar nytt PlayerPiece objekt & sparar det i spelarens playerPieces lista
    public void addPlayerPiece(int height, int width,int ID){
        PlayerPiece playerPiece = new PlayerPiece(height, width,playerIcon);
        playerPieces.add(playerPiece);
    }

    // returnerar listan med pjäser
    public ArrayList<PlayerPiece> getPlayerPieces(){
        return playerPieces;
    }

    public String getPlayerIcon(){
        return this.playerIcon;
    }


}
