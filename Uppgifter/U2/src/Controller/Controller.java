package Controller;
import Game.*;
import view.FrameOne;

public class Controller {
    private FrameOne frameOne;
    private Map map;
    private Player playerOne;
    private Mystery mysteryOne;



    public Controller() {
        //frameOne = new FrameOne(300, 250, this);
        map = new Map(8,8);
        map.printMap();
        playerOne = new Player("P");
        newPlayerPiece(playerOne,2,4);
        newPlayerPiece(playerOne,3,6);
        map.printMap();
        mysteryOne = new Mystery("?");
        setMysteryLocation(mysteryOne,4,2);
        map.printMap();
    }

    // PROOF OF CONCEPT
    public void newPlayerPiece(Player player, int height, int width){
        // Kollar hur stor spelarens lista av pjäser är & om den är noll
        int nbrOfPieces = player.getPlayerPieces().size();
        if (nbrOfPieces == 0){
            // Kallar på metoden som skapar nytt pjäs objekt och lägger till i spelarens lista av pjäser
            player.addPlayerPiece();
            // Assignar variablen "currentPiece" till det objekt i spelarens lista av pjäser som finns på samma index som nbrOfPieces
            PlayerPiece currentPiece = player.getPlayerPieces().get(nbrOfPieces);
            // Sparar pjäsens position med setters (de sparas i klassen PlayerPiece)
            currentPiece.setPieceHeight(height);
            currentPiece.setPieceWidth(width);
            // Sätter positionen på mappen till spelarens ikon.
            map.mapSetLocation(player.getIcon(), height, width);
        }
        // Om storleken av spelarens lista av pjäser är större än noll:
        else{
            // Uppdaterar nbrOfPieces
            nbrOfPieces = player.getPlayerPieces().size();
            // Assignar en "previousPiece" variabel
            PlayerPiece previousPiece = player.getPlayerPieces().get(nbrOfPieces-1);
            // Kollar om höjden/bredden vi angav i början är inom intervallet +-1 av förra pjäsens position (adjacent)
            if ((previousPiece.getPieceHeight()-1 < height && height < previousPiece.getPieceHeight()+1) && (previousPiece.getPieceWidth()-1 < width && width < previousPiece.getPieceWidth()+1)){
               // Kollar om valda platsen är ledig
                if (map.getMap()[height][width].equals("O")){
                    PlayerPiece currentPiece = player.getPlayerPieces().get(nbrOfPieces);
                    currentPiece.setPieceHeight(height);
                    currentPiece.setPieceWidth(width);
                    map.mapSetLocation(player.getIcon(), height, width);
                }
                else{
                    System.out.println("Pos. not empty");
                }
            }
            else{
                System.out.println("Pos. not adjacent to other Piece");
            }
        }

        }
    public void checkAdjacent(){
        // Kolla runtom vald position efter en player icon

    }
    // PROOF OF CONCEPT
    public void setMysteryLocation(Mystery mystery, int height, int width){
        map.mapSetLocation(mystery.getMysteryIcon(), height, width);
        mystery.setPieceHeight(height);
        mystery.setPieceWidth(width);
    }

}