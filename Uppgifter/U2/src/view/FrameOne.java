package view;
import Controller.Controller;

import javax.swing.*;
import java.awt.*;


public class FrameOne extends JFrame {
    private MainPanel mainPanel;

    private BottomPanel bottomPanel;


    public FrameOne(int row, int col,int width, int height, Controller controller,String playerOneIcon,String playerTwoIcon) {
        super("Omvävlning");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setResizable(false);

        this.mainPanel = new MainPanel(controller);
        mainPanel.setPreferredSize(new Dimension(750, 750));
        this.add(mainPanel,BorderLayout.CENTER);

        this.bottomPanel = new BottomPanel(height,width,playerOneIcon,playerTwoIcon);
        bottomPanel.setPreferredSize(new Dimension(600, 50));
        this.add(bottomPanel,BorderLayout.SOUTH);

        mainPanel.createGUI(row,col);
        mainPanel.setColorMap(row,col);

        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);


    }
    public void updateMapPosition(String text, int row, int col) {
        mainPanel.updateMapPosition(text, row, col);
    }
    public void populateLiveFeed(String string){
        bottomPanel.populateLiveFeed(string);
    }
    public void clearLiveFeed(){
        bottomPanel.clearLiveFeed();
    }
    public void updateScore(String icon, int score){
        bottomPanel.updateScore(icon, score);
    }


}