package Game;
import java.util.ArrayList;
import java.util.Random;


/**
 * Representerar banan i spelet
 *
 * Klassen hanterar banans höjd, bredd, antal mysterium, en lista med mysterien
 * </p>
 *
 * @author Kasper Åkesson
 * @author Axel Dahl
 *
 */

public class Map {
    private String[][] map;
    private int nbrOfMysteries;
    private ArrayList<Mystery> mysteries = new ArrayList<>();
    private int height;
    private int width;

    /**
     * Skapar mappen med angiven höjd, bredd och ikoner till mysterie
     * @param height
     * @param width
     * @param mapFiller
     * @param mysteryIcon
     *
     * @author Kasper Åkesson
     * @author Axel Dahl
     */
    public Map(int height, int width, String mapFiller,String mysteryIcon) {
        this.height = height;
        this.width = width;
        this.map = new String[height][width];
        this.tempoFillMap(mapFiller);


        this.nbrOfMysteries = setMysteries();

        fillMysteries(this.nbrOfMysteries,mysteryIcon);


    }

    /**
     * hämtar höjden
     * @return int height
     */
    public int getHeight(){
        return this.height;
    }

    /**
     * håmtar bredden
     * @return int width
     * @author Kasper Åkesson
     * @author Axel Dahl
     */

    public int getWidth(){
        return this.width;
    }
    /**
     * håmtar specifik kordinat värde
     * @param row
     * @param col
     * @return String value
     * @author Kasper Åkesson
     * @author Axel Dahl
     */
    public String getValue(int row,int col){
        return map[row][col];
    }

    /**
     * håmtar mappen
     * @return String[][]
     * @author Kasper Åkesson
     * @author Axel Dahl
     */
    public String[][] getMap() {
        return this.map;
    }

    /**
     * Sätter en viss ikon på en specifik position i kartan
     * @param icon
     * @param height
     * @param width
     * @author Kasper Åkesson
     * @author Axel Dahl
     */
    public void mapSetLocation(String icon, int height, int width) {
        this.map[height][width] = icon;
    }

    /**
     * Fyller kartan med String du skickar in
     * @param mapFiller
     * @author Kasper Åkesson
     * @author Axel Dahl
     */
    public void tempoFillMap(String mapFiller) {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map.length; j++) {
                this.map[i][j] = mapFiller;
            }
        }
    }

    /**
     * Fyller kartan med mysterium samt skapar dem och lägger till mysteries arraylist
     *@param number
     * @param mysteryIcon
     * @author Kasper Åkesson
     *
     */
    public void fillMysteries(int number,String mysteryIcon) {
        Random p = new Random();
        int num = 0;
        while (num < number) {
            int a = 0;
            int temp = p.nextInt(0, 8);
            int temp2 = p.nextInt(0, 8);
            if (temp != 0 && temp != 7 && temp2 != 0 && temp2 != 7) {
                if (!(getMap()[temp][temp2].equals(mysteryIcon))) {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (getMap()[temp + i][temp2 + j].equals(mysteryIcon)) {
                                a++;
                            }


                        }

                    }
                    if (a == 0) {
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
    }

    /**
     * sätter antalet mysteries till spelet
     * @return int temp antalet mysteries
     *
     *  @author Kasper Åkesson
     */
    public int setMysteries() {
        Random r = new Random();
        int temp = r.nextInt(5, 10);
        return temp;
    }

    /**
     * hämtar antalet mysteries
     * @return int nbrOfMysteries
     * @author Kasper Åkesson
     */


    public int getNbrOfMysteries() {
        return this.nbrOfMysteries;
    }

    /**
     * hämtar listan med mysterie
     * @return mysteries
     * @author Kasper Åkesson
     */
    public ArrayList<Mystery> getList() {
        return this.mysteries;
    }
}










