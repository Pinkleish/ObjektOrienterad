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
    String mapEmpty = "I";
    String playerOneIcon = "Z";
    String playerTwoIcon = "Q";



    public Controller() {
        //frameOne = new FrameOne(300, 250, this);
        playerOne = new Player(playerOneIcon);
        playerTwo = new Player(playerTwoIcon);
        map = new Map(8,8,mapEmpty);
        mysteryOne = new Mystery(mysteryIcon);
        Turn turn = new Turn();

        System.out.println("TEST: ny map");

        map.printMap();
        //generateMysteries(map.getNbrOfMysteries());

        newPlayerPiece(playerOne,2,4);
        newPlayerPiece(playerTwo,3,4);
        map.printMap();
        newPlayerPiece(playerOne,2,3);
        newPlayerPiece(playerTwo,4,3);
        newPlayerPiece(playerOne,4,2);
        newPlayerPiece(playerOne,4,4);


        //setMysteryLocation(mysteryOne,4,2);


    }
    public void playTurn(int turn){
        if (turn % 2 == 0){
            newPlayerPiece(playerOne,2,2);

        }
        else{
            newPlayerPiece(playerTwo,2, 2);
        }

    }


    public void newPlayerPiece(Player player, int height, int width) {
        if (checkVacant(height, width)) {

            if (player.getPlayerPieces().isEmpty()) {
                player.addPlayerPiece(height, width, player.getPlayerPieces().size());
                map.mapSetLocation(player.getPlayerIcon(), height, width);
                map.printMap();
                System.out.println("FOR TESTING: Placerade första pjäs");
                Turn++;
                return;
            }
            if (checkAdjacent(height, width)) {
                player.addPlayerPiece(height, width, player.getPlayerPieces().size());
                map.mapSetLocation(player.getPlayerIcon(), height, width);
                checkSurprise(player, height, width);


                map.printMap();
                System.out.println("FOR TESTING: Placerade en pjäs");
                Turn++;
                return;
            } else {
                System.out.println("Kunde inte placera pjäs");
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
                if (((height+i) < (map.getMap().length) && (height+i) >= 0) && (width+j) < (map.getMap()[0].length) && (width+j) >= 0){
                    if (map.getMap()[height + i][width + j].equals(playerOneIcon) || (map.getMap()[height + i][width + j].equals(playerTwoIcon))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int pieceIdentify(Player player, int height, int width) {

            if (map.getMap()[height][width] != mapEmpty) {
                if (map.getMap()[height][width] != mysteryIcon) {
                    if (map.getMap()[height][width] != player.getPlayerIcon()) {
                        return 1; // motståndarens pjäsikon funnits
                    } else {
                        return 2; // egen pjäsikon funnits
                    }
                }
            }
        return 0; // inte en pjäsikon
    }

    public void surpriseCommit(Player player,int height,int width,int i,int j){
        while (true){
            height +=i;
            width +=j;
            if(pieceIdentify(player,height,width)== 2){
                return;
            }
            else{
                map.mapSetLocation(player.getPlayerIcon(),height,width);
                }
            }
        }


    public boolean checkSurpriseValidity(Player player, int height, int width, int i, int j) {
        if (pieceIdentify(player, height + i, width + j) == 1) {
            while (true) {
                height += i;
                width += j;
                if (pieceIdentify(player, height + i, width + j) == 2) {

                    return true;
                }
            }
        }
        return false;
    }



    public void checkSurprise(Player player, int height, int width) {
        // Kolla efter en motståndarpjäs
        // Hittas en så ska du fortsätta kolla bredvid den pjäsen i samma riktning
        // Stoppa när du hittar antingen en kant, en egen pjäs eller tom plats
for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (checkSurpriseValidity(player, height, width, i, j)) {
                        surpriseCommit(player,height,width,i,j);
                        System.out.println("Valid surprise");
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Check surprise out of bounds");

                }
            }
        }
    }


    // PROOF OF CONCEPT




}