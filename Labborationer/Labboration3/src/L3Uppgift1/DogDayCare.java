package L3Uppgift1;
import java.util.Scanner;

public class DogDayCare {
    private int costForOneDog;
    private DogOwner dogOwner;

    public DogDayCare(){
        memberRegistration();
    }
    private void addDog(Dog dog, int number){
    }
    private void calculateCost(DogOwner dogOwner){
    }
    private void memberRegistration(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your name please: ");
        String name = scanner.nextLine();

        System.out.println("Do you have 1 or 2 dogs: ");
        int numberOfDogs = scanner.nextInt();

        System.out.println("Name of dog 1: ");
        String nameDog1 = scanner.nextLine();

        System.out.println("Gender of dog 1: ");
        String genderDog1 = scanner.nextLine();

        System.out.println("Age of dog 1: ");
        int ageDog1 = scanner.nextInt();

        System.out.println("Name of dog 2: ");
        String nameDog2 = scanner.nextLine();

        System.out.println("Gender of dog 2: ");
        String genderDog2 = scanner.nextLine();

        System.out.println("Age of dog 2: ");
        int ageDog2 = scanner.nextInt();
    }
    private void printDogOwnerStats(DogOwner dogOwner){

    }
}
