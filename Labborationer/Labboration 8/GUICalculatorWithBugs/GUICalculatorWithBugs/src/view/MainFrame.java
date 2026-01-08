package view;

import controller.Controller;
import view.MainPanel;

import javax.swing.*;
import java.sql.PreparedStatement;


public class MainFrame
{
    private JFrame frame;
    private MainPanel panel;

    private int width = 800;
    private int height = 400;

    //default konstruktor
    public MainFrame(Controller controller)
    {
        frame = new JFrame("Calculator");
        frame.setSize(width, height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(150, 150);

        //skapa ett objekt av panelen
        panel = new MainPanel(controller, width, height);
        //lägg till panelen på mainFrame

        frame.setContentPane(panel);
        //frame.add(panel);
        frame.pack();
        //frame.setResizable(false);
        frame.setVisible(true);
    }

    public void setInputLabels(String strLabel1, String strLabel2)
    {
        panel.setInputLabels(strLabel1,strLabel2);
    }
    public void setResult(String result)
    {
        panel.setResult(result);
    }
}

