package Game;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    private String[][] map;
    private int nbrOfMysteries;
    private ArrayList<Mystery> mysteries = new ArrayList<>();
    private int height;
    private int width;


    // Konstruktorn skapar en ny map och kallar på tempoFillMap som fyller den med "O"
    public Map(int height, int width, String mapFiller,String mysteryIcon) {
        this.height = height;
        this.width = width;
        this.map = new String[height][width];
        this.tempoFillMap(mapFiller);


        this.nbrOfMysteries = setMysteries();

        fillMysteries(this.nbrOfMysteries,mysteryIcon);


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


    // Sätter viss position på kartan till en viss ikon, t.ex Mystery ikon eller Player ikon
    public void mapSetLocation(String icon, int height, int width) {
        this.map[height][width] = icon;
    }


    public void tempoFillMap(String mapFiller) {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map.length; j++) {
                this.map[i][j] = mapFiller;
            }
        }
    }

    public void fillMysteries(int number,String mysteryIcon) {
        Random p = new Random();
        int num = 0;
        while (num < number) {
            int temp = p.nextInt(0, 8);
            int temp2 = p.nextInt(0, 8);
            if (temp != 0 && temp != 7 && temp2 != 0 && temp2 != 7) {
                if (!(getMap()[temp][temp2].equals(mysteryIcon))){
                    mapSetLocation(mysteryIcon, temp, temp2);
                    Mystery k = new Mystery();
                    mysteries.add(k);
                    this.mysteries.get(num).setPieceHeight(temp);
                    this.mysteries.get(num).setPieceWidth(temp2);
                    num++;
                }

                }
        }
    }


    public int setMysteries() {
        Random r = new Random();
        int temp = r.nextInt(5, 10);
        return temp;
    }


    public int getNbrOfMysteries() {
        return this.nbrOfMysteries;
    }


    public ArrayList<Mystery> getList() {
        return this.mysteries;
    }
}










