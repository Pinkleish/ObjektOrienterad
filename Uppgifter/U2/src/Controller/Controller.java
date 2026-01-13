package Controller;
import Game.*;
import view.FrameOne;
import view.GameOverFrame;
import javax.swing.*;

/**
 * Controller ansvarar för att hantera spelets logik, turordning,
 * spelarinteraktioner samt kopplingen mellan spelmodellen och GUI:t.
 * Klassen koordinerar spelets tillstånd, poängräkning och avslut.
 *
 * @author Axel Dahl
 * @author Kasper Åkesson
 */
public class Controller {
    private FrameOne frameOne;
    private Map map;
    private Player playerOne;
    private Player playerTwo;
    private Turn turn;
    private int nbrOfPiecesTotal;
    private int nbrMysteriesTotal;
    private boolean gameOver = false;

    /** Mystery-symbol som representerar ett mysterium på spelplanen. */
    String mysteryIcon = "?";
    /** Tom ruta på spelplanen. */
    String mapEmpty = " ";
    /** Ikon för spelare ett. */
    String playerOneIcon = "O";
    /** Ikon för spelare två. */
    String playerTwoIcon = "X";

    /**
     * Skapar en ny Controller och initierar spelare, karta,
     * turordning och GUI.
     *
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
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

    /**
     * Hanterar knapptryckningar från GUI:t och placerar
     * spelarens pjäs baserat på aktuell tur.
     *
     * @param height_pressed den rad som trycktes
     * @param width_pressed den kolumn som trycktes
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
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

    /**
     * Försöker placera en ny pjäs för angiven spelare på
     * angiven position.
     *
     * @param player spelaren som placerar pjäsen
     * @param height radposition
     * @param width kolumnposition
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
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

    /**
     * Kontrollerar om en position är ledig, innehåller
     * mysterium eller är blockerad.
     *
     * @param height radposition
     * @param width kolumnposition
     * @return heltal som representerar platsens status
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public int checkVacant(int height, int width) {
        if (map.getMap()[height][width].equals(mapEmpty)) {
            return 2;
        } else if (map.getMap()[height][width].equals(mysteryIcon)) {
            return 1;
        }
        return 0;
    }

    /**
     * Kontrollerar om vald position är intill en befintlig pjäs.
     *
     * @param height radposition
     * @param width kolumnposition
     * @return true om angränsande pjäs finns
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public boolean checkAdjacent(int height, int width) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (((height + i) < (map.getMap().length) && (height + i) >= 0)
                        && (width + j) < (map.getMap()[0].length) && (width + j) >= 0) {
                    if (map.getMap()[height + i][width + j].equals(playerOneIcon)
                            || map.getMap()[height + i][width + j].equals(playerTwoIcon)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Identifierar vilken typ av pjäs som finns på angiven position.
     *
     * @param player aktuell spelare
     * @param height radposition
     * @param width kolumnposition
     * @return heltal som representerar pjäsens typ
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public int pieceIdentify(Player player, int height, int width) {
        if (map.getMap()[height][width] != mapEmpty) {
            if (map.getMap()[height][width] != mysteryIcon) {
                if (map.getMap()[height][width] != player.getPlayerIcon()) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }

    /**
     * Utför konvertering av pjäser vid giltig surprise-effekt.
     *
     * @param player aktuell spelare
     * @param height startposition rad
     * @param width startposition kolumn
     * @param i riktning i radled
     * @param j riktning i kolumnled
     * @author¨Axel Dahl
     * @author Kasper Åkesson
     */
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

    /**
     * Kontrollerar om en surprise-effekt är giltig i given riktning.
     *
     * @param player aktuell spelare
     * @param height radposition
     * @param width kolumnposition
     * @param i riktning i radled
     * @param j riktning i kolumnled
     * @return true om surprise är giltig
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
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

    /**
     * Kontrollerar och utför alla möjliga surprise-effekter
     * runt en nyligen placerad pjäs.
     *
     * @param player aktuell spelare
     * @param height radposition
     * @param width kolumnposition
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
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

    /**
     * Kontrollerar om ett mysterium aktiveras på angiven position.
     *
     * @param player aktuell spelare
     * @param height radposition
     * @param width kolumnposition
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public void checkMystery(Player player, int height, int width) {
        if (map.getMap()[height][width].equals(mysteryIcon)) {
            nbrMysteriesTotal--;
            for (int i = 0; i < map.getList().size(); i++) {
                if (map.getList().get(i).getPieceHeight() == height
                        && map.getList().get(i).getPieceWidth() == width) {
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

    /**
     * Utför effekten av ett specifikt mysterium.
     *
     * @param player aktuell spelare
     * @param num mysteriets ID
     * @param height radposition
     * @param width kolumnposition
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public void executeMystery(Player player, int num, int height, int width) { // utlöser mysterium
        switch (num) {
            case 1:
                // Ska skippa en tur
                turn.playTurn();

                frameOne.populateLiveFeed("Player " + player.getPlayerIcon() + " Has activated Tidshopp!");
                break;
            case 2:
                // Platserna ovanför, nedanför, till vänster, samt i mitten fylls med dina pjäser.
                setIconMapAndGUI(player.getPlayerIcon(), height + 1, width);// under
                setIconMapAndGUI(player.getPlayerIcon(), height - 1, width);// ovanför
                setIconMapAndGUI(player.getPlayerIcon(), height, width - 1);// vänster
                setIconMapAndGUI(player.getPlayerIcon(), height, width + 1);// höger
                setIconMapAndGUI(player.getPlayerIcon(), height, width); // mitten


                frameOne.populateLiveFeed("Player " + player.getPlayerIcon() + " Has activated AdditivaMetoder!");


                break;
            case 3:
                // Mysteriets pjäs blir spelaren. Resten runt omkring blir motståndarens.
                if (player.getPlayerIcon().equals(playerOneIcon)) {
                    setIconMapAndGUI(playerTwoIcon, height + 1, width); // under
                    setIconMapAndGUI(playerTwoIcon, height - 1, width);// ovanför
                    setIconMapAndGUI(playerTwoIcon, height, width - 1);// vänster
                    setIconMapAndGUI(playerTwoIcon, height, width + 1);// höger
                    setIconMapAndGUI(playerTwoIcon, height -1, width - 1);  // vänster uppe
                    setIconMapAndGUI(playerTwoIcon, height -1, width  + 1); // höger uppe
                    setIconMapAndGUI(playerTwoIcon, height + 1, width - 1); // vänster nere
                    setIconMapAndGUI(playerTwoIcon, height + 1 , width + 1); // höger nere
                    setIconMapAndGUI(playerOneIcon, height, width); // mitten behöver ingen check


                    frameOne.populateLiveFeed("Player " + player.getPlayerIcon() + " Has activated demagog!");
                    countScore(map);
                    frameOne.updateScore(playerTwoIcon, playerTwo.getScore());


                } else if (player.getPlayerIcon().equals(playerTwoIcon)) {
                    setIconMapAndGUI(playerOneIcon, height + 1, width); // under
                    setIconMapAndGUI(playerOneIcon, height - 1, width);// ovanför
                    setIconMapAndGUI(playerOneIcon, height, width - 1);// vänster
                    setIconMapAndGUI(playerOneIcon, height, width + 1);// höger
                    setIconMapAndGUI(playerOneIcon, height -1, width - 1);  // vänster uppe
                    setIconMapAndGUI(playerOneIcon, height -1, width  + 1); // höger uppe
                    setIconMapAndGUI(playerOneIcon, height + 1, width - 1); // vänster nere
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

    /**
     * Räknar poängen för båda spelarna baserat på kartans innehåll.
     *
     * @param map spelkartan
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public void countScore(Map map) {
        int temp1 = 0;
        int temp2 = 0;
        for (int row = 0; row < map.getMap().length; row++) {
            for (int col = 0; col < map.getMap().length; col++) {
                if (map.getMap()[row][col].equals(playerOneIcon)) {
                    temp1++;
                    playerOne.setScore(temp1);
                }
                else if (map.getMap()[row][col].equals(playerTwoIcon)) {
                    temp2++;
                    playerTwo.setScore(temp2);
                }
            }
        }
    }

    /**
     * Räknar antalet möjliga drag på kartan.
     *
     * @param map spelkartan
     * @return totalt antal rutor
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public int countTurns(Map map) {
        int counter = 0;
        for (int row = 0; row < map.getMap().length; row++) {
            for (int col = 0; col < map.getMap().length; col++)
                counter++;
        }
        return counter;
    }

    /**
     * Uppdaterar både spelkartan och GUI:t med vald ikon.
     *
     * @param icon ikon som ska placeras
     * @param height radposition
     * @param width kolumnposition
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public void setIconMapAndGUI(String icon, int height, int width) {
        map.mapSetLocation(icon, height, width);
        frameOne.updateMapPosition(icon, height, width);
    }

    /**
     * Kontrollerar om spelet är slut.
     *
     * @param map spelkartan
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public void checkGameOver(Map map) {
        if (nbrMysteriesTotal == 0){
            executeGameOver();
            return;
        }
        for (int row = 0; row < map.getMap().length; row++) {
            for (int col = 0; col < map.getMap().length; col++) {
                if (map.getMap()[row][col].equals(mapEmpty) || map.getMap()[row][col].equals(mysteryIcon)) {
                    return;
                }
            }
        }
        executeGameOver();
    }

    /**
     * Avslutar spelet och visar slutresultatet.
     *
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public void executeGameOver() {
        countScore(map);
        updateTotalScore(playerOne.getScore(), playerTwo.getScore());
        frameOne.populateLiveFeed("Spelet avslutat");
        new GameOverFrame(playerOne.getScore(), playerTwo.getScore(),this, playerOneIcon, playerTwoIcon);
        gameOver = true;
    }

    /**
     * Uppdaterar totalpoängen i GUI:t.
     *
     * @param playerOneScore poäng för spelare ett
     * @param playerTwoScore poäng för spelare två
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public void updateTotalScore(int playerOneScore, int playerTwoScore) {
        frameOne.updateScore(playerOneIcon, playerOneScore);
        frameOne.updateScore(playerTwoIcon, playerTwoScore);
    }

    /**
     * Startar ett nytt spel och återställer alla värden.
     *
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
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

    /**
     * Avgör vinnaren baserat på poäng.
     *
     * @return text som beskriver vinnaren
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public String checkWinner(){
        if (playerOne.getScore() == playerTwo.getScore()) {
            return "Its a tie. Both players have " + playerOne.getScore() + " points";
        } else if (playerTwo.getScore() > playerOne.getScore()) {
            return "Game over. Player "+ playerTwoIcon + " wins with " + playerTwo.getScore() + " points";
        } else{
            return "Game over. Player " + playerOneIcon +  " wins with " + playerOne.getScore() + " points";
        }
    }

    /**
     * Returnerar spelaren vars tur det är.
     *
     * @return aktuell spelare
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public Player getPlayersTurn(){
        if (turn.checkTurn() == 1){
            return playerOne;
        } else{
            return playerTwo;
        }
    }
}
