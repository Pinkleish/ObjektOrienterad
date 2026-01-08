package view;

import controller.Controller;

import javax.swing.*;

public class MainFrame
{
    private JFrame frame;
    private MainPanel panel;

    private int width = 400;
    private int height = 600;

    //default konstruktor
    public MainFrame(Controller controller)
    {
        frame = new JFrame("Read text from file");
        frame.setSize(width, height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(150, 150);

        //skapa ett objekt av panelen
        panel = new MainPanel(controller, width, height);
        //lägg till panelen på mainFrame

        frame.setContentPane(panel);
        //frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
    //Controller calls these messages
    public void setMessage(String message)
    {
        panel.setMessage(message);
    }
    public void fillListBoxWith(String [] items)
    {
        panel.fillListWithData(items);
    }
}
