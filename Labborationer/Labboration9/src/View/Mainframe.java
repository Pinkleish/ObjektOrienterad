package View;

import javax.swing.*;

import Controller.Controller;

public class Mainframe extends JFrame {

    Controller controller;

    private MainPanel mainPanel;
    private int height;
    private int width;


    public Mainframe(Controller controller, int width, int height){
        super("Milky Way");
        this.controller = controller;

        this.width = width;
        this.height = height;

        this.setSize(this.width, this.height);



        this.mainPanel = new MainPanel(this.width, this.height, this);
        this.setContentPane(this.mainPanel);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getBodyName(){
        return this.mainPanel.getBodyName();
    }

    public double getMass(){
        return this.mainPanel.getMass();
    }

    public void populatePlanetDisplay(String[] data){
        this.mainPanel.populatePlanetDisplay(data);
    }

    public void populateStarDisplay(String[] data){
        this.mainPanel.populateStarDisplay(data);
    }

    public int getSelectedStarSystem(){
        return this.mainPanel.getSelectedStarSystem();
    }

    public int getSelectedPlanet(){
        return this.mainPanel.getSelectedPlanet();
    }

    public void setPlanetInfoLabel(String[] data){
        this.mainPanel.setPlanetInfoLabel(data);
    }

}
