package view;
import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameOne extends JFrame {
    private MainPanel mainPanel;
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private BottomPanel bottomPanel;
    private Controller controller;
    private JButton[][] buttons;

    public FrameOne(int width, int height, Controller controller) {
        super("Window one");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width, height);
        this.mainPanel = new MainPanel(width, height, this);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8,8));


    }
    public void createGUI(int height,int width,String[][] map){
        buttons = new JButton[height][width];
        for (int i = 0; i < buttons.length;i++){
            for (int j = 0; j < buttons[0].length;j++){
                final int height_pressed = i;
                final int width_pressed = j;
                buttons[i][j] = new JButton(map[i][j]);
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Position: " + height_pressed + "," + width_pressed + " pressed");
                        controller.buttonPressed(height_pressed,width_pressed);
                    }
                });
                this.add(buttons[i][j]);
            }
        }
        this.revalidate();
        this.repaint();
    }
    public void updateMapPosition(String string,int height,int width){
        buttons[height][width].setText(string);


    }

    public void setColorMap(String[][] map){
        int p = -1;
        for(int row = 0; row < map.length; row ++){
            p++;
            for(int col = 0; col < map.length; col ++){

                if((col+p) % 2 == 0){
                    buttons[row][col].setBackground(Color.yellow);
                }
                if((col+p) % 2 == 1){
                    buttons[row][col].setBackground(Color.white);

                }
            }
        }
    }

}