package L3Uppgift1;
import java.util.Scanner;

public class DogDayCare {
    private int costForOneDog = 500;
    private DogOwner dogOwner;

    public DogDayCare(){
        memberRegistration();
    }
    private void addDog(Dog dog, int number){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Name of dog " + number +": ");
        String dogName = scanner2.nextLine();
        dog.setName(dogName);

        System.out.println("Gender of dog " + number + ": ");
        String dogGender = scanner2.nextLine();
        dog.setGender(dogGender);

        System.out.println("Age of dog " + number + ": ");
        int dogAge = scanner2.nextInt();
        dog.setAge(dogAge);
    }
    private void calculateCost(DogOwner dogOwner){
        System.out.println("Cost for " + dogOwner.getName() + " is: " + dogOwner.getNumberOfDogs()* costForOneDog);
    }
    private void memberRegistration(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your name please: ");
        String name = scanner.nextLine();

        System.out.println("What's your address: ");
        String address = scanner.nextLine();


        int numberOfDogs = 0;
        while (true){
            System.out.println("Do you have 1 or 2 dogs: ");
            numberOfDogs = scanner.nextInt();
            if (numberOfDogs <= 2 && numberOfDogs >= 1){
                dogOwner = new DogOwner(name,address,numberOfDogs);
                break;
            }
        }
        addDog(dogOwner.getDogOne(),1);
        if (numberOfDogs == 2){
            addDog(dogOwner.getDogTwo(),2);
        }
        printDogOwnerStats(dogOwner);
    }

    private void printDogOwnerStats(DogOwner dogOwner){
        System.out.println("You are now a member!");
        System.out.println("Name: " + dogOwner.getName());
        System.out.println("Address: " + dogOwner.getAddress());
        System.out.println("Number of dogs you own: " + dogOwner.getNumberOfDogs());
        System.out.println("Dog Info: (Name, Gender, Age)");
        System.out.println(dogOwner.getDogOne().getName()+", "+dogOwner.getDogOne().getGender()+", "+dogOwner.getDogOne().getAge());
        if (dogOwner.getNumberOfDogs()==2){
            System.out.println(dogOwner.getDogTwo().getName()+", "+dogOwner.getDogTwo().getGender()+", "+dogOwner.getDogTwo().getAge());
        }
        calculateCost(dogOwner);

    }
}
