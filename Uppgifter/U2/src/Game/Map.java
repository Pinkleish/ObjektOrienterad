package Game;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    private String[][] map;
    private int nbrOfMysteries;
    private ArrayList<Mystery> mysteries = new ArrayList<>();
    private String mysteryIcon;
    private int height;
    private int width;


    // Konstruktorn skapar en ny map och kallar på tempoFillMap som fyller den med "O"
    public Map(int height, int width, String mapFiller) {
        this.height = height;
        this.width = width;
        this.map = new String[height][width];
        this.tempoFillMap(mapFiller);


        this.nbrOfMysteries = setMysteries();

        fillMysteries(this.nbrOfMysteries);


    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }
    public String getValue(int row,int col){
        return map[row][col];
    }

    // Simpel getter för mappen
    public String[][] getMap() {
        return this.map;
    }

    // Printar ut varje element bredvid varandra & printar ny rad innan varje rad, skapar en 8x8 box
    public void printMap() {
        System.out.println();
        for (int row = 0; row < this.map.length; row++) {
            System.out.println("");
            for (int col = 0; col < this.map.length; col++) {
                System.out.print(this.map[row][col] + " ");
            }
        }
    }

    // Sätter viss position på kartan till en viss ikon, t.ex Mystery ikon eller Player ikon
    public void mapSetLocation(String icon, int height, int width) {
        this.map[height][width] = icon;
    }


    // TEMPORARY, KEEP AT THE BOTTOM - Fyller kartan med "O" för att lätt se den
    public void tempoFillMap(String mapFiller) {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map.length; j++) {
                this.map[i][j] = mapFiller;
            }
        }
    }

    public void fillMysteries(int number) {
        Random p = new Random();
        int num = 0;
        while (num < number) {
            int temp = p.nextInt(0, 8);
            int temp2 = p.nextInt(0, 8);
            if (temp != 0 && temp != 7 && temp2 != 0 && temp2 != 7) {
                if (!(getMap()[temp][temp2].equals("?"))){
                    mapSetLocation("?", temp, temp2);
                    Mystery k = new Mystery();
                    mysteries.add(k);
                    this.mysteries.get(num).setPieceHeight(temp);
                    this.mysteries.get(num).setPieceWidth(temp2);
                    num++;
                }

                }


        }
        //generateMysteries(num);
    }


    public int setMysteries() {
        Random r = new Random();
        int temp = r.nextInt(5, 10);
        return temp;
    }


    public int getNbrOfMysteries() {
        return this.nbrOfMysteries;
    }

    //public void generateMysteries() {
        //for(int i = 0; i < number; i ++){
       // Mystery k = new Mystery();
       // this.mysteries.add(k);
   // }

    public ArrayList<Mystery> getList() {
        return this.mysteries;
    }
}










