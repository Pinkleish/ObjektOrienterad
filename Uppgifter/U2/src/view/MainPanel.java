package view;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private JButton[][] buttons;
    private FrameOne frameOne;
    private Controller controller;




    public MainPanel(int height, int width, FrameOne frameOne,Controller controller) {

        this.controller = controller;
        this.frameOne = frameOne;



    }



    public void createGUI(int height,int width){
        this.setLayout(new GridLayout(height, width));
        buttons = new JButton[height][width];
        for (int i = 0; i < buttons.length;i++){
            for (int j = 0; j < buttons[0].length;j++){
                final int height_pressed = i;
                final int width_pressed = j;
                buttons[i][j] = new JButton(); // Se till att denna fylls
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

    public void setColorMap(int height,int width){
     int p = -1;
        for(int row = 0; row < height; row ++){
            p++;
         for(int col = 0; col < width; col ++){

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
