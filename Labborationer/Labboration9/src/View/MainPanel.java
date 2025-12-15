package View;

import javax.swing.*;

public class MainPanel extends JPanel{

    private int width;
    private int height;

    private TopPanel topPanel;
    private BottomPanel bottomPanel;

    private JComboBox<ItemTypes> listChoice;
    private JButton addItem;

    private Mainframe view;

    public MainPanel(int width, int height, Mainframe view){
        super();

        this.view = view;

        this.width = width;
        this.height = height;

        this.createWidgets();
        this.placeWidgets();
    }

    private void createWidgets(){
        this.topPanel = new TopPanel(this.width, this.height/2-25, this);
        this.bottomPanel = new BottomPanel(this.width, this.height/2, this);
    }

    private void placeWidgets(){
        this.add(this.topPanel);
        this.add(this.bottomPanel);
    }

    protected int getSelectedStarSystem(){
        return this.bottomPanel.getSelectedStarSystem();
    }

    protected int getSelectedPlanet(){
        return this.bottomPanel.getSelectedPlanet();
    }

    protected void populatePlanetDisplay(String[] data){
        this.bottomPanel.populatePlanetDisplay(data);
    }

    protected void populateStarDisplay(String[] data){
        this.bottomPanel.populateStarDisplay(data);
    }

    protected void setPlanetInfoLabel(String[] data){
        this.bottomPanel.setPlanetInfoLabel(data);
    }

    protected String getBodyName(){
        return this.topPanel.getBodyName();
    }

    protected double getMass(){
        return this.topPanel.getMass();
    }

}
