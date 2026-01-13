package Controller;
import Game.*;
import view.FrameOne;
import view.GameOverFrame;
import javax.swing.*;


// TODO "LOGBOK"
// Kolla om player & playerpiece har attribut de inte behöver. T.ex ID för playerpiece eller arraylisten "playerpieces" i player
// Ta bort onödiga metoder, attribut, kommentarer etc
// fixa javadoc



public class Controller {
    private FrameOne frameOne;
    private Map map;
    private Player playerOne;
    private Player playerTwo;
    private Turn turn;
    private int nbrOfPiecesTotal;
    private int nbrMysteriesTotal;
    private boolean gameOver = false;
    String mysteryIcon = "?";
    String mapEmpty = " ";
    String playerOneIcon = "O";
    String playerTwoIcon = "X";


    public Controller() {
        playerOne = new Player(playerOneIcon);
        playerTwo = new Player(playerTwoIcon);
        map = new Map(8, 8, mapEmpty, mysteryIcon);
        turn = new Turn();
        frameOne = new FrameOne(map.getHeight(), map.getWidth(), 750, 750, this,playerOneIcon,playerTwoIcon);

        nbrMysteriesTotal = map.getNbrOfMysteries();
        nbrOfPiecesTotal = countTurns(map);
        turn.checkTurn();



        frameOne.populateLiveFeed("Player " + getPlayersTurn().getPlayerIcon() + "'s turn");


        for (int row = 0; row < map.getHeight(); row++) {
            for (int col = 0; col < map.getWidth(); col++) {
                frameOne.updateMapPosition(map.getValue(row, col), row, col);
            }
        }


    }


    public void buttonPressed(int height_pressed, int width_pressed) {
        if (gameOver){
            return;
        }
        countScore(map);
        switch (turn.checkTurn()) {
            case 1:
                newPlayerPiece(playerOne, height_pressed, width_pressed);
                break;

            case 2:
                newPlayerPiece(playerTwo, height_pressed, width_pressed);

        }
    }


    public void newPlayerPiece(Player player, int height, int width) {
        if (checkVacant(height, width) > 0) {

            if (player.getPlayerPieces().isEmpty()) {
                frameOne.clearLiveFeed();
                frameOne.populateLiveFeed("Player " + player.getPlayerIcon() + " placerade sin första pjäs");
                player.addPlayerPiece(height, width);
                checkMystery(player, height, width);
                setIconMapAndGUI(player.getPlayerIcon(), height, width);


                turn.playTurn();
                countScore(map);
                frameOne.populateLiveFeed("Player " + getPlayersTurn().getPlayerIcon() + "'s turn");
                frameOne.updateScore(player.getPlayerIcon(), player.getScore());
                return;
            }
            if (checkAdjacent(height, width)) {
                frameOne.clearLiveFeed();
                frameOne.populateLiveFeed("Player " + player.getPlayerIcon() + " placerade en pjäs");
                player.addPlayerPiece(height, width);
                checkSurprise(player, height, width);
                checkMystery(player, height, width);


                setIconMapAndGUI(player.getPlayerIcon(), height, width);
                turn.playTurn();
                countScore(map);
                frameOne.populateLiveFeed("Player " + getPlayersTurn().getPlayerIcon() + "'s turn");
                frameOne.updateScore(player.getPlayerIcon(), player.getScore());
                checkGameOver(map);
                return;
            } else {

                frameOne.populateLiveFeed("Kunde inte placera pjäs");
                return;
            }
        }
        frameOne.populateLiveFeed("Platsen inte ledig");
    }

    public int checkVacant(int height, int width) {
        if (map.getMap()[height][width].equals(mapEmpty)) {
            return 2; // tom plats
        } else if (map.getMap()[height][width].equals(mysteryIcon)) {
            return 1; // mysterium
        }
        return 0; // plats inte ledig
    }


    public boolean checkAdjacent(int height, int width) {
        // Kolla runtom vald position efter en player icon
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (((height + i) < (map.getMap().length) && (height + i) >= 0) && (width + j) < (map.getMap()[0].length) && (width + j) >= 0) {
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

    public void surpriseCommit(Player player, int height, int width, int i, int j) {
        while (true) {
            height += i;
            width += j;
            if (pieceIdentify(player, height, width) == 2) {
                return;
            } else {
                setIconMapAndGUI(player.getPlayerIcon(), height, width);
                countScore(map);
                updateTotalScore(playerOne.getScore(), playerTwo.getScore());
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
                } else if (pieceIdentify(player, height + i, width + j) == 0) {
                    return false;
                }
            }
        }
        return false;
    }


    public void checkSurprise(Player player, int height, int width) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (checkSurpriseValidity(player, height, width, i, j)) {
                        surpriseCommit(player, height, width, i, j);

                    }
                } catch (ArrayIndexOutOfBoundsException e) {


                }
            }
        }
    }

    public void checkMystery(Player player, int height, int width) {
        if (map.getMap()[height][width].equals(mysteryIcon)) {

            nbrMysteriesTotal--;
            for (int i = 0; i < map.getList().size(); i++) {
                if (map.getList().get(i).getPieceHeight() == height && map.getList().get(i).getPieceWidth() == width) {
                    executeMystery(player, map.getList().get(i).getID(), height, width);
                    break;

                }

            }
            if (nbrMysteriesTotal == 0) {

                frameOne.populateLiveFeed("Spelet avslutat!");
                countScore(map);


            }


        }
    }

    public void executeMystery(Player player, int num, int height, int width) { // utlöser mysterium
        switch (num) {
            case 1:
                // Ska skippa en tur
                turn.playTurn();

                frameOne.populateLiveFeed("Player " + player.getPlayerIcon() + " Has activated Tidshopp!");
                break;
            case 2:
                // Platserna ovanför, nedanför, till vänster, samt i mitten fylls med dina pjäser.
                if (checkVacant(height + 1, width) == 1) {
                    nbrMysteriesTotal--;
                }
                setIconMapAndGUI(player.getPlayerIcon(), height + 1, width);// under
                if (checkVacant(height - 1, width) == 1) {
                    nbrMysteriesTotal--;
                }
                setIconMapAndGUI(player.getPlayerIcon(), height - 1, width);// ovanför
                if (checkVacant(height, width - 1) == 1) {
                    nbrMysteriesTotal--;
                }
                setIconMapAndGUI(player.getPlayerIcon(), height, width - 1);// vänster
                if (checkVacant(height, width + 1) == 1) {
                    nbrMysteriesTotal--;

                }
                setIconMapAndGUI(player.getPlayerIcon(), height, width + 1);// höger
                setIconMapAndGUI(player.getPlayerIcon(), height, width); // mitten


                frameOne.populateLiveFeed("Player " + player.getPlayerIcon() + " Has activated AdditivaMetoder!");


                break;
            case 3:
                // Mysteriets pjäs blir spelaren. Resten runt omkring blir motståndarens.
                if (player.getPlayerIcon().equals(playerOneIcon)) {
                    if (checkVacant(height + 1, width) == 1) {
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerTwoIcon, height + 1, width); // under
                    if (checkVacant(height - 1, width) == 1) {
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerTwoIcon, height - 1, width);// ovanför
                    if (checkVacant(height, width - 1) == 1) {
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerTwoIcon, height, width - 1);// vänster
                    if (checkVacant(height, width + 1) == 1) {
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerTwoIcon, height, width + 1);// höger

                    if (checkVacant(height - 1, width - 1) == 1) { // vänster uppe
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerTwoIcon, height -1, width - 1);  // vänster uppe
                    if (checkVacant(height - 1, width + 1) == 1) {
                        nbrMysteriesTotal --;
                    }
                    setIconMapAndGUI(playerTwoIcon, height -1, width  + 1); // höger uppe
                    if(checkVacant(height + 1, width - 1) == 1){
                        nbrMysteriesTotal --;
                    }
                    setIconMapAndGUI(playerTwoIcon, height + 1, width - 1); // vänster nere
                    if(checkVacant(height + 1, width + 1) == 1){
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerTwoIcon, height + 1 , width + 1); // höger nere

                    setIconMapAndGUI(playerOneIcon, height, width); // mitten behöver ingen check


                    frameOne.populateLiveFeed("Player " + player.getPlayerIcon() + " Has activated demagog!");
                    countScore(map);
                    frameOne.updateScore(playerTwoIcon, playerTwo.getScore());


                } else if (player.getPlayerIcon().equals(playerTwoIcon)) {
                    if (checkVacant(height + 1, width) == 1) {
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerOneIcon, height + 1, width); // under
                    if (checkVacant(height - 1, width) == 1) {
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerOneIcon, height - 1, width);// ovanför
                    if (checkVacant(height, width - 1) == 1) {
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerOneIcon, height, width - 1);// vänster
                    if (checkVacant(height, width + 1) == 1) {
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerOneIcon, height, width + 1);// höger
                    if (checkVacant(height - 1, width - 1) == 1) { // vänster uppe
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerOneIcon, height -1, width - 1);  // vänster uppe
                    if (checkVacant(height - 1, width + 1) == 1) {
                        nbrMysteriesTotal --;
                    }
                    setIconMapAndGUI(playerOneIcon, height -1, width  + 1); // höger uppe
                    if(checkVacant(height + 1, width - 1) == 1){
                        nbrMysteriesTotal --;
                    }
                    setIconMapAndGUI(playerOneIcon, height + 1, width - 1); // vänster nere
                    if(checkVacant(height + 1, width + 1) == 1){
                        nbrMysteriesTotal--;
                    }
                    setIconMapAndGUI(playerOneIcon, height + 1 , width + 1); // höger nere


                    setIconMapAndGUI(playerTwoIcon, height, width); // mitten

                    frameOne.populateLiveFeed("Player " + player.getPlayerIcon() + " Has activated demagog!");
                    countScore(map);
                    frameOne.updateScore(playerOneIcon, playerOne.getScore());

                }


                break;
        }
        countScore(map);

    }

    public void countScore(Map map) { // Looping over map to count the cores.
        int temp1 = 0;
        int temp2 = 0;
        for (int row = 0; row < map.getMap().length; row++) {
            for (int col = 0; col < map.getMap().length; col++) {

                if (map.getMap()[row][col].equals("Z")) {
                    temp1++;
                    playerOne.setScore(temp1);

                } else if (map.getMap()[row][col].equals("Q")) {
                    temp2++;
                    playerTwo.setScore(temp2);

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

    public void setIconMapAndGUI(String icon, int height, int width) {
        map.mapSetLocation(icon, height, width);
        frameOne.updateMapPosition(icon, height, width);
    }

    public void checkGameOver(Map map) {
        if (nbrMysteriesTotal == 0){
            executeGameOver();
            return;
        }

        for (int row = 0; row < map.getMap().length; row++) {
            for (int col = 0; col < map.getMap().length; col++) {
                if (map.getMap()[row][col].equals(" ")) {
                    return;
                }
            }

        }
        executeGameOver();
        return;
    }

    public void executeGameOver() {
        countScore(map);
        updateTotalScore(playerOne.getScore(), playerTwo.getScore());
        frameOne.populateLiveFeed("Spelet avslutat");
        new GameOverFrame(playerOne.getScore(), playerTwo.getScore(),this, playerOneIcon, playerTwoIcon);
        gameOver = true;

    }


    public void updateTotalScore(int playerOneScore, int playerTwoScore) {
        frameOne.updateScore(playerOneIcon, playerOneScore);
        frameOne.updateScore(playerTwoIcon, playerTwoScore);
    }

    public void newGame(){
        frameOne.clearLiveFeed();
        playerOne = new Player(playerOneIcon);
        playerTwo = new Player(playerTwoIcon);
        map = new Map(8, 8, mapEmpty, mysteryIcon);
        turn = new Turn();

        gameOver = false;
        nbrMysteriesTotal = map.getNbrOfMysteries();
        nbrOfPiecesTotal = countTurns(map);
        turn.checkTurn();


        frameOne.populateLiveFeed("Player " + getPlayersTurn().getPlayerIcon() + "'s turn");


        for (int row = 0; row < map.getHeight(); row++) {
            for (int col = 0; col < map.getWidth(); col++) {
                frameOne.updateMapPosition(map.getValue(row, col), row, col);
                countScore(map);
                updateTotalScore(playerOne.getScore(), playerTwo.getScore());
            }
        }
    }
    public String checkWinner(){
        if (playerOne.getScore() == playerTwo.getScore()) {
            return "Its a tie. Both players have " + playerOne.getScore() + " points";

        } else if (playerTwo.getScore() > playerOne.getScore()) {
            return "Game over. Player "+ playerTwoIcon + " wins with " + playerTwo.getScore() + " points";

        } else{
            return "Game over. Player " + playerOneIcon +  " wins with " + playerOne.getScore() + " points";

        }
    }
    public Player getPlayersTurn(){
        if (turn.checkTurn() == 1){
            return playerOne;
        }
        else{
            return playerTwo;
        }
    }
}


