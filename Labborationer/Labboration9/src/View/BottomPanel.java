package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BottomPanel extends JPanel implements ActionListener{

    private int width;
    private int height;

    private JList<String> systems;
    private JList<String> planets;

    private JButton showPlanet;
    private JButton showStar;

    private JList<String> planetInfo;

    private MainPanel mainPanel;

    public BottomPanel(int width, int height, MainPanel mp){
        super();
        this.mainPanel = mp;

        this.setLayout(new GridLayout(3,2));

        this.width = width;
        this.height = height;

        this.setSize(this.width, this.height);
        this.setVisible(true);

        createWidgets();
        placeWidgets();
    }

    private void createWidgets(){
        this.systems = new JList<String>();
        this.systems.setSize(this.width/2, this.height-20);
        this.planets = new JList<String>();
        this.planets.setSize(width/2, this.height-20);

        this.showPlanet = new JButton("Show planet");
        this.showStar = new JButton("Show system");

        this.planetInfo = new JList<String>();

        JButton myButton = new JButton();
        myButton.addActionListener(this);
    }

    private void placeWidgets(){
        this.add(this.systems);
        this.add(this.planets);

        this.add(this.showStar);
        this.add(this.showPlanet);

        this.add(this.planetInfo);

        this.systems.setVisible(true);
        this.planets.setVisible(true);

        this.showStar.setVisible(true);
        this.showPlanet.setVisible(true);

        this.planetInfo.setVisible(true);
    }

    protected int getSelectedStarSystem(){
        return this.systems.getSelectedIndex();
    }

    protected int getSelectedPlanet(){
        return this.planets.getSelectedIndex();
    }

    protected void setPlanetInfoLabel(String[] data){
        this.planetInfo.setListData(data);
    }

    protected void populatePlanetDisplay(String[] data){
        this.planets.setListData(data);
    }

    protected void populateStarDisplay(String[] data){
        this.systems.setListData(data);
    }

    public void actionPerformed(ActionEvent e){

    }


}
