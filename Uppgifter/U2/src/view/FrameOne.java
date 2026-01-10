package view;
import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameOne extends JFrame {
    private MainPanel mainPanel;
    //private LeftPanel leftPanel;
    //private RightPanel rightPanel;
    private BottomPanel bottomPanel;


    public FrameOne(int row, int col,int width, int height,Controller controller) {
        super("Window one");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setResizable(false);

        this.mainPanel = new MainPanel(height, width, this,controller);
        mainPanel.setPreferredSize(new Dimension(750, 750));
        this.add(mainPanel,BorderLayout.CENTER);

        this.bottomPanel = new BottomPanel(this);
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


}