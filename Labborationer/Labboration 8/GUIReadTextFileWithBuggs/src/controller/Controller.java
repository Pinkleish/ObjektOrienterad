package controller;

import model.FileManager;
import view.MainFrame;

import javax.swing.*;

public class Controller
{
    private MainFrame view;
    private FileManager fileManager; //model


    public Controller()
    {
        view = new MainFrame(this);   //view
        fileManager = new FileManager();  //model
       }

    public void okButtonPressed()
    {
        readFile();
    }

    private void readFile()
    {
        String path =  System.getProperty("user.dir");//current dirctor
        String fileName = path +"\\data\\demodata.txt";
        String[] infoStrings = null;

        infoStrings = fileManager.readFile(fileName);
        view.fillListBoxWith(infoStrings);
        view.setMessage("Reading file successful!");

      }

    public void listPressed(int index)
    {
        view.setMessage(String.format("Item nr %d (counting fr 0) selected.", index));
    }
}
