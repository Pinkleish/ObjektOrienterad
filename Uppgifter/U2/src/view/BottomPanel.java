package view;

import javax.swing.*;
import java.awt.*;

/**
 * Representerar bottenpanelen i spelets GUI.
 * <p>
 * Klassen ansvarar för att visa spelarpoäng och en live feed
 * som kan uppdateras under spelets gång.
 * </p>
 *
 * @author Axel Dahl
 * @author Kasper Åkesson
 */
public class BottomPanel extends JPanel {
    private JLabel playerOneScoreLabel;
    private JLabel playerTwoScoreLabel;
    private JTextArea liveFeedArea;
    private String playerOneIcon;
    private String playerTwoIcon;

    /**
     * Skapar en BottomPanel med spelarnas ikoner och initialiserar poäng och live feed.
     *
     * @param height         höjden på panelen
     * @param width          bredden på panelen
     * @param playerOneIcon  ikon för spelare 1
     * @param playerTwoIcon  ikon för spelare 2
     * @author Axel Dalh
     * @author Kasper Åkesson
     */
    public BottomPanel(int height, int width, String playerOneIcon, String playerTwoIcon){
        setLayout(new BorderLayout());
        this.playerOneIcon = playerOneIcon;
        this.playerTwoIcon = playerTwoIcon;

        playerOneScoreLabel = new JLabel("Player " + playerOneIcon + " Score: 0", SwingConstants.CENTER);
        playerOneScoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(playerOneScoreLabel, BorderLayout.WEST);

        playerTwoScoreLabel = new JLabel("Player " + playerTwoIcon +" Score: 0", SwingConstants.CENTER);
        playerTwoScoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(playerTwoScoreLabel, BorderLayout.EAST);

        liveFeedArea = new JTextArea();
        liveFeedArea.setEditable(false);
        liveFeedArea.setLineWrap(true);
        liveFeedArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(liveFeedArea);
        add(scrollPane, BorderLayout.CENTER);

        setPreferredSize(new Dimension(width, height - 100));
    }

    /**
     * Lägger till ett meddelande i live feeden.
     *
     * @param message texten som ska läggas till i live feeden
     * @author Axel Dahl
     */
    public void populateLiveFeed(String message) {
        liveFeedArea.append(message + "\n");
    }

    /**
     * Rensar all text från live feeden.
     * <p>
     * Tar bort alla meddelanden som tidigare visats.
     * </p>
     * @author Axel Dahl
     */
    public void clearLiveFeed(){
        liveFeedArea.setText("");
    }

    /**
     * Uppdaterar poängen för en spelare.
     *
     * @param icon  spelarens ikon som identifierar vilken poäng som ska uppdateras
     * @param score spelarens nya poäng
     * @author Axel Dahl
     * @author Kasper Åkesson
     */
    public void updateScore(String icon, int score){
        if (icon.equals(playerOneIcon)){
            playerOneScoreLabel.setText("Player " + icon + " score: " + score);
        }
        else if(icon.equals(playerTwoIcon)){
            playerTwoScoreLabel.setText("Player " + icon + " score: " + score);
        }
    }
}
