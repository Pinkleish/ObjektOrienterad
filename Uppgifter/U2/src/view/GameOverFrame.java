package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.Controller;

public class GameOverFrame extends JFrame {
    private JButton newGame;
    private Controller controller;


    public GameOverFrame(int x, int y,Controller controller, String playerOneIcon, String playerTwoIcon) {
        setLayout(new BorderLayout());
        setSize(400,300);
        setTitle("Game Over");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea label = new JTextArea();
        label.setEditable(false);
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.append("Player "+ playerOneIcon+ " score: " + x  + " Player "+ playerTwoIcon+ " score: " + y + "\n");
        label.append(controller.checkWinner());
        add(label, BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);
        newGame = new JButton("Start new game");

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newGame();
                dispose();
            }
        });
        add(newGame,BorderLayout.SOUTH);

    }


}
