import java.util.Scanner;

public class Föreläsning1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // name = input("Vad heter du? ")
        System.out.println("Vad heter du?");
        String name = input.nextLine();

        // age = int(input("Hur gammal är du?"))
        System.out.println("Hur gammal är du?");
        int age = input.nextInt();

        // print(name,age)
        System.out.println(name + " " + age);
    }
    for (int i = 0; i < 10; i++){
        system.out.println(i);
    }

    public double myMethod(double par1, double par2){
        double result = par1+par2;
        return result;
    }
}