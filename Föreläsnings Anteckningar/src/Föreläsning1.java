import java.util.Scanner;

public class Föreläsning1 {

    public static void main(String[] args) {
        /* Scanner input = new Scanner(System.in);
        // name = input("Vad heter du? ")
        System.out.println("Vad heter du?");
        String name = input.nextLine();

        // age = int(input("Hur gammal är du?"))
        System.out.println("Hur gammal är du?");
        int age = input.nextInt();

        // print(name,age)
        System.out.println(name + " " + age); */

        var kitty = new Kitty("Garcghomp", 15);
        System.out.println(kitty.Meow());

        var evilkitty = new Kitty("Larry", 90);
        System.out.println(evilkitty.Meow());

        var tigguh = new BigCat();
        System.out.println(tigguh.Meow());
    }
}