package view;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Representerar huvudpanelen för spelets GUI.
 * <p>
 * Klassen ansvarar för att skapa spelbrädet med knappar, uppdatera knappers
 * text och färger samt hantera knapptryck via en Controller.
 * </p>
 *
 * @author Axel Dahl
 * @author Kasper Åkesson
 */
public class MainPanel extends JPanel {
    private JButton[][] buttons;
    private Controller controller;

    /**
     * Skapar en MainPanel kopplad till en specifik Controller.
     *
     * @param controller controller som hanterar logiken för knapptryck
     * @author Axel Dahl
     */
    public MainPanel(Controller controller) {
        this.controller = controller;
    }

    /**
     * Skapar GUI:et med ett grid av knappar enligt angivna höjd och bredd.
     * <p>
     * Varje knapp får en ActionListener som anropar Controller när den trycks.
     * </p>
     *
     * @param height antal rader i gridlayouten
     * @param width  antal kolumner i gridlayouten
     * @author Axel Dahl
     */
    public void createGUI(int height, int width){
        this.setLayout(new GridLayout(height, width));
        buttons = new JButton[height][width];
        for (int i = 0; i < buttons.length; i++){
            for (int j = 0; j < buttons[0].length; j++){
                final int height_pressed = i;
                final int width_pressed = j;
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.buttonPressed(height_pressed, width_pressed);
                    }
                });
                this.add(buttons[i][j]);
            }
        }
        this.revalidate();
        this.repaint();
    }

    /**
     * Uppdaterar texten på en specifik knapp i gridlayouten.
     *
     * @param string texten som ska visas på knappen
     * @param height radindex för knappen som ska uppdateras
     * @param width  kolumnindex för knappen som ska uppdateras
     * @author Axel Dahl
     */
    public void updateMapPosition(String string, int height, int width){
        buttons[height][width].setText(string);
    }

    /**
     * Sätter färger på knapparna i gridlayouten enligt ett schackliknande mönster.
     * <p>
     * Växlar mellan gult och vitt beroende på knappens position.
     * </p>
     *
     * @param height antal rader i gridlayouten
     * @param width  antal kolumner i gridlayouten
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public void setColorMap(int height, int width){
        int p = -1;
        for(int row = 0; row < height; row++){
            p++;
            for(int col = 0; col < width; col++){
                if((col + p) % 2 == 0){
                    buttons[row][col].setBackground(Color.yellow);
                }
                if((col + p) % 2 == 1){
                    buttons[row][col].setBackground(Color.white);
                }
            }
        }
    }
}
