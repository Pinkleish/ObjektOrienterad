package Game;

/**
 * Representerar turhanteringen i spelet.
 * <p>
 * Klassen håller reda på vilken spelares tur det är och uppdaterar turordningen
 * varje gång en tur spelas.
 * </p>
 *
 * @author Axel Dahl
 * @author Kasper Åkesson
 */
public class Turn {
    private int counter = 0;

    /**
     * Skapar ett nytt Turn-objekt och startar turräknaren på 1.
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public Turn(){
        this.counter = 1;
    }

    /**
     * Ökar turräknaren med 1 och returnerar det nya värdet.
     * <p>
     * Används när en spelare har genomfört sin tur.
     * </p>
     *
     * @return det nya värdet på turräknaren efter spelad tur
     * @author Kasper Åkesson
     */
    public int playTurn(){
        this.counter += 1;
        return this.counter;
    }

    /**
     * Kontrollerar vilken spelares tur det är baserat på turräknaren.
     *
     * @return 1 om det är spelarens 1 tur, 2 om det är spelarens 2 tur
     * @author Kasper Åkesson
     */
    public int checkTurn(){
        if (counter % 2 == 0){
            return 2;
        } else {
            return 1;
        }
    }
}
