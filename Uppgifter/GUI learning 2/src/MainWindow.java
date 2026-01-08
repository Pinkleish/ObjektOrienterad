import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    JButton[] buttons = new JButton[9];
    JButton[] activeButtons = new JButton[3];

    public MainWindow(){
       setTitle("3x3");
       setSize(400,300);
       setVisible(true);
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       JPanel panel = new JPanel();
       panel.setLayout(new GridLayout(3,3));

       for (int i=0; i<9; i++){
           final int index = i;
           buttons[i] = new JButton("button");
           buttons[i].setBackground(Color.gray);
           panel.add(buttons[i]);
           buttons[i].addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   System.out.println("Button "+ (index+1) + " clicked");
                   listRemoveOldest(buttons[index],index);


               }
           });
       }
       add(panel);
    }


    public void listRemoveOldest(JButton button,int index) {
        int i = 0;
        for (int j = 0;j<activeButtons.length;j++){
            if (activeButtons[j] == button){
                return;
            }
        }
        while (true){
            if (activeButtons[i] == null) {
                activeButtons[i] = button;
                buttons[index].setBackground(Color.green);
                return;
            }
            else if (i==2) {
                activeButtons[0].setBackground(Color.gray);
                activeButtons[0] = activeButtons[1];
                activeButtons[1] = activeButtons[2];
                activeButtons[2] = button;
                activeButtons[2].setBackground(Color.green);
                return;

            }
            i++;
        }

    }








}
