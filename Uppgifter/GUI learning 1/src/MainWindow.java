import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class MainWindow {

    public MainWindow() {

    JFrame frame = new JFrame("A frame");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());

        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel();
        frame.add((panelTop), BorderLayout.NORTH);
        frame.add((panelBottom), BorderLayout.CENTER);

        JButton buttonTop = new JButton("Top");
        JButton buttonBottom = new JButton("Bottom");

        panelTop.add(buttonTop);
        panelBottom.add(buttonBottom);

        buttonTop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Top button pressed");
            }
        });

        buttonBottom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bottom button pressed");
            }
        });










    }
}