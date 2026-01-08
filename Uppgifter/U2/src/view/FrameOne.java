package view;
import Controller.Controller;

import javax.swing.*;
import java.awt.*;

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
        setLayout(new GridLayout(4,4));
        JButton[] buttons = new JButton[16];
        for(int i=0;i<4*4;i++){
            buttons[i] = new JButton("o");
            this.add(buttons[i]);

        }
    }
}