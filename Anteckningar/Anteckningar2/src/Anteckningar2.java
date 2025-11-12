public class Anteckningar2{

    public static void main(String[] args) {
    /*
    We will use this file to test the rest of the classes created during the lecture
     */

        Bike myBike = new Bike("Svart", 7);
        Bike yourBike = new Bike("Blå", 2);
        // p.g.a att color i klassen Bike är private så kan bara Bike klassen få tillgång till den
        myBike.roll();
        yourBike.roll();
        System.out.println(myBike.getGears());


        Person me = new Person("Axel", 2003);

        System.out.println(me.getName());

        myBike.setOwner(me);
        System.out.println(myBike.getOwner());

        Bike[] bikes = new Bike[12];
        bikes[0] = new Bike("Vit", 2);
        bikes[1] = new Bike("Gul", 15);
        bikes[2] = new Bike("Orange", 9);
        bikes[3] = new Bike("Lila", 5);
        bikes[4] = new Bike("Grön", 1);
        // Print the bikes
        for (int i = 0; i < bikes.length; i++){
            System.out.println(bikes[i]);
        }


    }
}

