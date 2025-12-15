package Controller;

import View.*;
import Model.*;

public class    Controller {

    Mainframe mainFrame;

    Starsystem[] starsystems;
    int numberOfStarSystems = 0;

    public Controller(){
        this.mainFrame = new Mainframe(this, 300, 500);
        this.starsystems = new Starsystem[5];

        this.createStartingStarsytems();
        this.updateStarDisplay();
    }

    private void createStartingStarsytems(){
        createSolSystem();
        createProximaCentauriSystem();
    }

    private void createSolSystem(){
        Planet[] planets = {new Planet("Mercury", 0.06),
                            new Planet("Venus", 0.82),
                            new Planet("Earth", 1),
                            new Planet("Mars", 0.11),
                            new Planet("Jupiter", 317.89),
                            new Planet("Saturn", 95.17),
                            new Planet("Uranus", 14.56),
                            new Planet("Neptune", 17.24)};
        this.starsystems[0] = new Starsystem("Sol", planets);
        this.numberOfStarSystems++;
    }

    private void createProximaCentauriSystem(){
        Planet[] planets = new Planet[3];
        planets[0] = new Planet("Proxima d", 0.260);
        planets[1] = new Planet("Proxima b", 1.055);
        planets[2] = new Planet("Proxima c", 7);

        this.starsystems[1] = new Starsystem("Proxima Centauri", planets);
        this.numberOfStarSystems++;
    }

    public void addPlanetToSystem(){
        int index = this.mainFrame.getSelectedStarSystem();
        String name = this.mainFrame.getBodyName();
        double mass = this.mainFrame.getMass();
        this.starsystems[index].addPlanet(name, mass);

        this.displayStarSystem(index);
    }

    private void addNewSystem(){
        if (this.numberOfStarSystems == this.starsystems.length){
            this.expandSystemArray();
        }
        String starName = this.mainFrame.getBodyName();
        this.starsystems[numberOfStarSystems] = new Starsystem(starName);
        this.numberOfStarSystems++;

        this.updateStarDisplay();
    }

    private void updateStarDisplay(){
        String[] out = new String[this.numberOfStarSystems];
        for (int i = 0; i < this.numberOfStarSystems; i++){
            out[i] = this.starsystems[i].getName();
        }
        this.mainFrame.populateStarDisplay(out);
    }

    private void displayStarSystem(int selectedIndex){
        Planet[] planets = this.starsystems[selectedIndex].getPlanets();
        String[] out = new String[planets.length];

        for (int i = 0; i < planets.length; i++){
            if (planets[i] != null) {
                out[i] = planets[i].toString();
            }
        }
        this.mainFrame.populatePlanetDisplay(out);
    }

    private void viewStar(){
        int index = this.mainFrame.getSelectedStarSystem();
        if (0 <= index) {
            this.displayStarSystem(index);
        }
    }

    private void viewPlanet(){
        int starIndex = this.mainFrame.getSelectedStarSystem();
        int planetIndex = this.mainFrame.getSelectedPlanet();

        if (0 <= starIndex && 0 <= planetIndex) {
            Planet planet = this.starsystems[starIndex].getPlanets()[planetIndex];
            String[] data = new String[2];
            data[0] = "Planet name: " + planet.getName();
            data[1] = "Planet mass: " + planet.getMass();
            this.mainFrame.setPlanetInfoLabel(data);
        }
    }

    private void expandSystemArray(){
        Starsystem[] newArray = new Starsystem[this.starsystems.length+5];
        for (int i = 0; i < this.starsystems.length; i++){
            newArray[i] = this.starsystems[i];
        }
        this.starsystems = newArray;
    }

    public void buttonPressed(ActionType button){
        System.out.println("Controller, buttonPressed " + button);
    }
}
