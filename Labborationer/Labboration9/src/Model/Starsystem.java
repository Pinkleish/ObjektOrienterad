package Model;

public class Starsystem {

    private Planet[] planets;
    private String name;

    public Starsystem(){
        this("Unknown");
    }

    public Starsystem(String name){
        this.name = name;
        this.planets = new Planet[10];
    }

    public Starsystem(String name, Planet[] planets){
        this.name = name;
        this.planets = planets;
    }

    public String getName(){
        return this.name;
    }

    public double calculateMass(){
        double totalMass = 0;
        for (Planet planet: this.planets){
            if (planet != null){
                totalMass += planet.getMass();
            }
        }
        return totalMass;
    }

    public Planet getPlanet(String planetName){
        for (Planet planet: planets){
            if (planet != null){
                if (planet.getName().equals(planetName)){
                    return planet;
                }
            }
        }
        return null;
    }

    public void addPlanet(String planetName, double planetMass){
        for (int i = 0; i < planets.length; i++){
            if (planets[i] == null){
                planets[i] = new Planet(planetName, planetMass);
                return;
            }
        }
        // If the code reaches here the list was full
        Planet[] newList = new Planet[planets.length+1]; // We will find new planets so seldom this will work
        for (int i = 0; i < planets.length; i++){
            newList[i] = planets[i];
        }
        newList[planets.length] = new Planet(planetName, planetMass);
        planets = newList;
    }

    public Planet[] getPlanets(){
        return this.planets;
    }

    public String[] getPlanetNames(){
        String[] names = new String[this.planets.length];
        for (int i = 0; i < names.length; i++){
            names[i] = this.planets[i].getName();
        }
        return names;
    }

    public String toString(){
        String out = "";
        out += this.name;
        for (Planet planet: planets){
            out += ", " + planet;
        }
        return out;
    }

}
