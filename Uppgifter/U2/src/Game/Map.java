package Game;
import java.util.Random;

public class Map {
    private String[][] map;
    private int nbrOfMysteries;

    // Konstruktorn skapar en ny map och kallar på tempoFillMap som fyller den med "O"
    public Map(int height, int width){
        this.map = new String[height][width];
        this.tempoFillMap();

    }

    // Simpel getter för mappen
    public String[][] getMap(){
        return this.map;
    }

    // Printar ut varje element bredvid varandra & printar ny rad innan varje rad, skapar en 8x8 box
    public void printMap(){
        System.out.println();
        for (int row = 0; row < this.map.length; row++){
            System.out.println("");
            for (int col = 0; col < this.map.length; col++){
                System.out.print(this.map[row][col] + " ");
            }
        }
    }

    // Sätter viss position på kartan till en viss ikon, t.ex Mystery ikon eller Player ikon
    public void mapSetLocation(String icon, int height, int width){
        this.map[height][width] = icon;
    }



    // TEMPORARY, KEEP AT THE BOTTOM - Fyller kartan med "O" för att lätt se den
    public void tempoFillMap(){
        for (int i = 0; i< this.map.length; i++){
            for (int j = 0; j < this.map.length; j++){
                this.map[i][j] =  "O";
            }
        }
    }
    public void setMysteries(){
        Random r = new Random();
        this.nbrOfMysteries = r.nextInt(5, 10);

    }
}
