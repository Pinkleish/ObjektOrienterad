package view;
import Controller.Controller;

import javax.swing.*;

public class FrameOne extends JFrame {
    private MainPanel mainPanel;
    private Controller controller;

    public FrameOne(int width, int height, Controller controller) {
        super("Window one");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width, height);
        this.mainPanel = new MainPanel(width, height, this);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}