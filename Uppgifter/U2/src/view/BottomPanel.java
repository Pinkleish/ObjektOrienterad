package view;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    private FrameOne frameOne;
    private JLabel playerOneScoreLabel;
    private JLabel playerTwoScoreLabel;
    private JTextArea liveFeedArea;

    public BottomPanel(int height, int width, FrameOne frameOne){
        this.frameOne = frameOne;
        setLayout(new BorderLayout());

        playerOneScoreLabel = new JLabel("Player 1 Score: 0", SwingConstants.CENTER);
        playerOneScoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(playerOneScoreLabel, BorderLayout.WEST);

        playerTwoScoreLabel = new JLabel("Player 2 Score: 0", SwingConstants.CENTER);
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
}
