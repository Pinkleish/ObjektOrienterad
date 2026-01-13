package Game;


import java.util.ArrayList;

public class Player {
    private String playerIcon;
    private ArrayList<PlayerPiece> playerPieces = new ArrayList<>();
    private int playerScore;


    public Player(String playerIcon){
        this.playerIcon = playerIcon;
    }
    public void addPlayerPiece(int height, int width){
        PlayerPiece playerPiece = new PlayerPiece(height, width);
        playerPieces.add(playerPiece);
    }


    public ArrayList<PlayerPiece> getPlayerPieces(){
        return playerPieces;
    }

    public String getPlayerIcon(){
        return this.playerIcon;
    }

    public void setScore( int score){
        this.playerScore = score;
    }

    public int getScore(){
        return this.playerScore;

    }


}
