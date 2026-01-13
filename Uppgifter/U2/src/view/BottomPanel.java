package view;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    private JLabel playerOneScoreLabel;
    private JLabel playerTwoScoreLabel;
    private JTextArea liveFeedArea;
    private String playerOneIcon;
    private String playerTwoIcon;


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


    public void populateLiveFeed(String message) {
        liveFeedArea.append(message + "\n");
    }
    public void clearLiveFeed(){
        liveFeedArea.setText("");
    }
    public void updateScore(String icon, int score){
        if (icon.equals(playerOneIcon)){
            playerOneScoreLabel.setText(String.valueOf("Player "+ icon + " score: " +score));
        }
        else if(icon.equals(playerTwoIcon)){
            playerTwoScoreLabel.setText(String.valueOf("Player "+ icon +" score: " +score));
        }

    }
}
