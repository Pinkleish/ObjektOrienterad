package view;
import javax.swing.*;
import java.awt.*;

public class GameOverFrame extends JFrame {
    private JLabel playerScoreLabel;

    public GameOverFrame(int x, int y) {
        setLayout(new BorderLayout());
        playerScoreLabel = new JLabel("Player 1 Score: 0", SwingConstants.CENTER);
        setSize(400,300);
        setTitle("Game Over");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel("Player 1 score: " + x  + " Player 2 score: " + y, SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);

    }


}
