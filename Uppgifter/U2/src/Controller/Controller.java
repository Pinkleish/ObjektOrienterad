package Controller;
import Game.*;
import view.FrameOne;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

// TODO "LOGBOK"
// Kolla om player & playerpiece har attribut de inte behöver. T.ex ID för playerpiece eller arraylisten "playerpieces" i player
// Ta bort generateMystery metod i map om den inte behövs
// FillMysteries genererar fler mysterium än den ska kunna göra - KANSKE FIXAT
// FillMysteries kan placerar mer änett mysterium objekt på samma position - orsakar att ArrayListan "mysteries" i map blir större än antalet mysterium på kartan - FIXAT!
// I metoden FillMysteries tog jag bort for loopen då den itererade över number utan anledning, la också till en "if" sats för att kolla att platsen inte redan är ett mysterium
// Tog bort objektet "mysteryOne" som användes för tester & tog bort ArrayListan mysteries från Controller
// Ta bort separata map.mapSet & updateGUIicon då det ska ersättas med en metod som anropar båda samtidigt
// Fundera på om det är snyggare att göra alla mysterium till metoder som anropas i vår switch case
// rad 247 & 261 i controller har olika "if statement" men verkar göra samma sak? Går det att göra till en enda metod?
// demagog1 ersatte inte vänster position med en fiende pjäs då det redan fanns en spelare1 pjäs - FIXAT
// Testat så att överraskning funkar i ALLA riktningar SAMTIDIGT, det funkade :)


public class Controller {
    private FrameOne frameOne;
    private Map map;
    private Player playerOne;
    private Player playerTwo;
    private int nbrMysteries;
    private Turn turn;
    private int nbrOfPiecesTotal;
    private int nbrOfPieces;
    private int nbrMysteriesTotal;
    String mysteryIcon = "?";
    String mapEmpty = " ";
    String playerOneIcon = "Z";
    String playerTwoIcon = "Q";



    public Controller() {

        frameOne = new FrameOne(750, 750, this);

        playerOne = new Player(playerOneIcon);
        playerTwo = new Player(playerTwoIcon);
        map = new Map(8,8,mapEmpty);
        turn = new Turn();

        nbrMysteriesTotal = map.getNbrOfMysteries();
        nbrOfPiecesTotal = countTurns(map);
        turn.checkTurn();

        // Test av överraskning i alla riktningar
        for (int i = -1;i <= 1; i++){
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j== 0){
                    map.mapSetLocation(" ",5+i,5+j);
                }
                else{
                    map.mapSetLocation(playerTwoIcon,5+i,5+j);
                    map.mapSetLocation(playerOneIcon,5+(2*i),5+(2*j));
                }

            }
        }

        System.out.println("TEST: ny map");
        map.printMap();


        frameOne.createGUI(8,8, map.getMap());
        frameOne.setColorMap(map.getMap());

    }


    public void buttonPressed(int height_pressed,int width_pressed){

        switch (turn.checkTurn()){
            case 1:
                newPlayerPiece(playerOne,height_pressed,width_pressed);
                break;

            case 2:
                newPlayerPiece(playerTwo,height_pressed,width_pressed);
        }
    }


    public void newPlayerPiece(Player player, int height, int width) {
        if (checkVacant(height, width) > 0) {

            if (player.getPlayerPieces().isEmpty()) {
                player.addPlayerPiece(height, width, player.getPlayerPieces().size());
                checkMystery(player,height,width);
                setIconMapAndGUI(player.getPlayerIcon(),height,width);
                map.printMap();
                System.out.println("FOR TESTING: Placerade första pjäs");
                turn.playTurn();
                return;
            }
            if (checkAdjacent(height, width)) {
                player.addPlayerPiece(height, width, player.getPlayerPieces().size());
                checkSurprise(player, height, width);
                checkMystery(player,height,width);
                map.printMap();
                System.out.println("FOR TESTING: Placerade en pjäs");
                setIconMapAndGUI(player.getPlayerIcon(),height,width);
                turn.playTurn();
                return;
            } else {
                System.out.println("Kunde inte placera pjäs");
                return;
            }
        }
        map.printMap();
        System.out.println("Platsen inte tom");
    }

    public int checkVacant(int height, int width){
        if (map.getMap()[height][width].equals(mapEmpty)){
            return 2; // tom plats
        } else if (map.getMap()[height][width].equals(mysteryIcon)){
            return 1; // mysterium
        }
        return 0; // plats inte ledig
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
                setIconMapAndGUI(player.getPlayerIcon(),height,width);
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
                else if(pieceIdentify(player, height + i, width + j) == 0){
                    return false;
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
    public void checkMystery(Player player, int height, int width) {
        if (map.getMap()[height][width].equals(mysteryIcon)){
            System.out.println("Mystery found!");
            nbrMysteriesTotal --;
            for (int i = 0; i < map.getList().size(); i++) {
                if (map.getList().get(i).getPieceHeight() == height && map.getList().get(i).getPieceWidth() == width) {
                    executeMystery(player, map.getList().get(i).getID(), height, width);
                    break;

                }

            }
            if (nbrMysteriesTotal == 0){
                System.out.print("Spelet avslutat");
                countScore(map);
            }


        }
    }

    public void executeMystery(Player player, int num, int height, int width){ // utlöser mysterium
            switch(num) {
                case 1:
                    // Ska skippa en tur
                    turn.playTurn();
                    System.out.print("Tidshopp");
                    break;
                case 2:
                    // Platserna ovanför, nedanför, till vänster, samt i mitten fylls med dina pjäser.
                    //map.mapSetLocation(player.getPlayerIcon(),height + 1,width); //
                    setIconMapAndGUI(player.getPlayerIcon(),height +1 ,width);// under
                   // map.mapSetLocation(player.getPlayerIcon(),height + -1,width);
                    setIconMapAndGUI(player.getPlayerIcon(),height -1,width);// ovanför
                    //map.mapSetLocation(player.getPlayerIcon(),height,width - 1);
                    setIconMapAndGUI(player.getPlayerIcon(),height,width -1);// vänster
                    //map.mapSetLocation(player.getPlayerIcon(),height,width + 1);
                    setIconMapAndGUI(player.getPlayerIcon(),height,width +1);// höger
                    //map.mapSetLocation(player.getPlayerIcon(),height,width);
                    setIconMapAndGUI(player.getPlayerIcon(),height,width); // mitten
                    System.out.print("AdditivaMetoder");
                    break;
                case 3:
                    // Mysteriets pjäs blir spelaren. Resten runt omkring blir motståndarens.
                    if(player.getPlayerIcon().equals(playerOneIcon)){
                        //map.mapSetLocation(playerTwoIcon,height + 1,width);
                        setIconMapAndGUI(playerTwoIcon,height +1 ,width); // under
                        //map.mapSetLocation(playerTwoIcon,height - 1,width);
                        setIconMapAndGUI(playerTwoIcon,height -1,width);// ovanför
                        //map.mapSetLocation(playerTwoIcon,height,width -1);
                        setIconMapAndGUI(playerTwoIcon,height,width -1);// vänster
                        //map.mapSetLocation(playerTwoIcon,height,width + 1);
                        setIconMapAndGUI(playerTwoIcon,height,width +1);// höger
                        //map.mapSetLocation(playerOneIcon,height,width);
                        setIconMapAndGUI(playerOneIcon,height,width); // mitten
                        System.out.println("Demagog1");

                    }
                    else if(player.getPlayerIcon().equals(playerTwoIcon)){
                        //map.mapSetLocation(playerTwoIcon,height + 1,width);
                        setIconMapAndGUI(playerOneIcon,height +1 ,width); // under
                        //map.mapSetLocation(playerTwoIcon,height - 1,width);
                        setIconMapAndGUI(playerOneIcon,height -1,width);// ovanför
                        //map.mapSetLocation(playerTwoIcon,height,width -1);
                        setIconMapAndGUI(playerOneIcon,height,width -1);// vänster
                        //map.mapSetLocation(playerTwoIcon,height,width + 1);
                        setIconMapAndGUI(playerOneIcon,height,width +1);// höger
                        //map.mapSetLocation(playerOneIcon,height,width);
                        setIconMapAndGUI(playerTwoIcon,height,width); // mitten
                        System.out.println("Demagog2");

                    }


                    break;
            }

        }

        public void countScore(Map map) {// Looping over map to count the cores.
            for (int row = 0; row < map.getMap().length; row++) {
                for (int col = 0; col < map.getMap().length; col++) {

                    if (map.getMap()[row][col].equals("Z")) {
                        playerOne.setScore();
                    } else if (map.getMap()[row][col].equals("Q")) {
                        playerTwo.setScore();
                    }


                }
            }
        }

    public int countTurns(Map map) {
        int counter = 0;
        for (int row = 0; row < map.getMap().length; row++) {
            for (int col = 0; col < map.getMap().length; col++)
                counter++;


        }
        return counter;
    }

    public void setIconMapAndGUI(String icon,int height,int width){
        map.mapSetLocation(icon,height,width);
        frameOne.updateMapPosition(icon,height,width);
    }
}
