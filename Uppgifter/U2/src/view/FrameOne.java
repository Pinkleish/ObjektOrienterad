package view;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Representerar huvudfönstret för spelet.
 * <p>
 * Klassen ansvarar för att skapa och visa spelets huvudfönster,
 * inklusive huvudpanelen (MainPanel) och bottenpanelen (BottomPanel).
 * </p>
 *
 * @author Axel Dahl
 * @author Kasper Åkesson
 */
public class FrameOne extends JFrame {
    private MainPanel mainPanel;
    private BottomPanel bottomPanel;

    /**
     * Skapar ett nytt FrameOne-fönster med angivna dimensioner och spelikon.
     *
     * @param row            antal rader i spelbrädet
     * @param col            antal kolumner i spelbrädet
     * @param width          bredd på fönstret (används för inställningar av paneler)
     * @param height         höjd på fönstret (används för inställningar av paneler)
     * @param controller     controller som hanterar spel-logiken
     * @param playerOneIcon  ikon för spelare 1
     * @param playerTwoIcon  ikon för spelare 2
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public FrameOne(int row, int col, int width, int height, Controller controller, String playerOneIcon, String playerTwoIcon) {
        super("Omvävlning");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setResizable(false);

        this.mainPanel = new MainPanel(controller);
        mainPanel.setPreferredSize(new Dimension(750, 750));
        this.add(mainPanel, BorderLayout.CENTER);

        this.bottomPanel = new BottomPanel(height, width, playerOneIcon, playerTwoIcon);
        bottomPanel.setPreferredSize(new Dimension(600, 50));
        this.add(bottomPanel, BorderLayout.SOUTH);

        mainPanel.createGUI(row, col);
        mainPanel.setColorMap(row, col);

        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Uppdaterar texten på en specifik position i spelbrädet.
     *
     * @param text texten som ska visas på knappen
     * @param row  radindex för knappen som ska uppdateras
     * @param col  kolumnindex för knappen som ska uppdateras
     * @author Axel Dahl
     */
    public void updateMapPosition(String text, int row, int col) {
        mainPanel.updateMapPosition(text, row, col);
    }

    /**
     * Lägger till en rad i live feeden i bottenpanelen.
     *
     * @param string texten som ska läggas till i live feeden
     * @author Axel Dahl
     */
    public void populateLiveFeed(String string){
        bottomPanel.populateLiveFeed(string);
    }

    /**
     * Rensar live feeden i bottenpanelen.
     * <p>
     * Tar bort all text som visas i live feeden.
     * </p>
     * @author Axel Dahl
     */
    public void clearLiveFeed(){
        bottomPanel.clearLiveFeed();
    }

    /**
     * Uppdaterar poängen för en spelare i bottenpanelen.
     *
     * @param icon spelarens ikon som identifierar vilken poäng som ska uppdateras
     * @param score spelarens nya poäng
     * @author Kasper Åkesson
     */
    public void updateScore(String icon, int score){
        bottomPanel.updateScore(icon, score);
    }
}
