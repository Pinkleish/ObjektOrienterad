package Controller;
import Game.*;
import view.FrameOne;

import java.util.ArrayList;

public class Controller {
    private FrameOne frameOne;
    private Map map;
    private Player playerOne;
    private Player playerTwo;
    private Mystery mysteryOne;
    private int nbrMysteries;
    private ArrayList<Mystery> mysteries = new ArrayList<>();
    private int Turn = 1;
    String mysteryIcon = "?";
    String mapEmpty = "O";
    String playerOneIcon = "p";
    String playerTwoIcon = "q";



    public Controller() {
        //frameOne = new FrameOne(300, 250, this);
        nbrMysteries = map.setMysteries();
        generateMysteries(nbrMysteries);
        map = new Map(8,8,mapEmpty);
        map.printMap();
        playerOne = new Player(playerOneIcon);
        playerTwo = new Player(playerTwoIcon);
        newPlayerPiece(playerOne,2,4);
        newPlayerPiece(playerOne,3,6);
        map.printMap();
        mysteryOne = new Mystery(mysteryIcon);
        setMysteryLocation(mysteryOne,4,2);
        map.printMap();

    }
    public void playTurn(int turn){
        if (turn % 2 == 0){
            newPlayerPiece(playerOne,2,2);

        }
        else{
            newPlayerPiece(playerTwo,2, 2);
        }

    }


    public void newPlayerPiece(Player player, int height, int width){
        if (checkVacant(height, width)) {

            if (player.getPlayerPieces().isEmpty()) {
                player.addPlayerPiece(height, width);
                map.mapSetLocation(player.getIcon(), height, width);
                map.printMap();
                System.out.println("FOR TESTING: Placerade första pjäs");
                Turn ++;
                return;
            }
            if (checkAdjacent(height,width)){
                player.addPlayerPiece(height, width);
                map.mapSetLocation(player.getIcon(), height, width);
                // TODO : En check om det blir överraskning
                map.printMap();
                System.out.println("FOR TESTING: Placerade en pjäs");
                Turn ++;
                return;
            }

        }
        map.printMap();
        System.out.println("Platsen inte tom");
    }


    public boolean checkVacant(int height, int width){
        if (map.getMap()[height][width].equals(mapEmpty)){
            return true;
        }
        return false;
    }


    public boolean checkAdjacent(int height, int width){
        // Kolla runtom vald position efter en player icon
        for (int i = -1;i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                if (map.getMap()[height + i][width + j].equals(playerOneIcon) || (map.getMap()[height + i][width + j].equals(playerTwoIcon))){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean pieceIdentifyOpponent(Player player, int height, int width){
        if (map.getMap()[height][width] != mapEmpty){
            if (map.getMap()[height][width] != mysteryIcon){
                if (map.getMap()[height][width] != player.getIcon()){
                    return true;
                }
            }
        }
        return false;
    }

    public void checkSurprise(Player player, int height, int width){
        // Kolla efter en motståndarpjäs
        // Hittas en så ska du fortsätta kolla bredvid den pjäsen i samma riktning
        // Stoppa när du hittar antingen en kant, en egen pjäs eller tom plats
        for (int i = -1;i <= 1; i++){
            for (int j = -1; j <= 1; j++) {
                if (pieceIdentifyOpponent(player ,height + i,width + j)){

                }
            }
        }
    }


    // PROOF OF CONCEPT
    public void setMysteryLocation(Mystery mystery, int height, int width){
        map.mapSetLocation(mystery.getMysteryIcon(), height, width);
        mystery.setPieceHeight(height);
        mystery.setPieceWidth(width);
    }

    public void generateMysteries(int number){
        for(int i = 0; i < number; i ++){
            Mystery k = new Mystery(mysteryIcon);
            mysteries.add(k);

        }

    }

}