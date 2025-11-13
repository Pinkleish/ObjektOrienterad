import java.util.Scanner;
public class Labboration2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//Ta bort kommentarerna framför varje
// metod-anrop för att testa din kod.
//uppgift01();
//uppgift02();
//uppgift03();
//uppgift04(input);
//uppgift05(input);
//uppgift06();
uppgift07();
//uppgift08();
//uppgift09();
//uppgift10();
//uppgift11();
    }

    public static void uppgift01() {
        System.out.println("Uppgift 01");
// Skriv din kod här
        int a = 5;
        int b = 2;
        int c = 3;
        int d = 10;
        int e = a / b + c * d;
        System.out.println(e);
    }

    public static void uppgift02() {
        System.out.println("Uppgift 02");
// Skriv din kod här
        double a = 5;
        double b = 2;
        double c = 3;
        double d = 10;
        double e = a / b + c * d;
        System.out.println(e);
    }

    public static void uppgift03() {
        System.out.println("Uppgift 03");
// Skriv din kod här
        System.out.println("Uppgift 03");
        int a = 5;
        int b = 5;
        int c = 3;
        if (a > b && a > c) {
            System.out.println(a + (" is the largest"));
        } else if (a == b && b == c) {
            System.out.println("Every number is the largest!");
        } else if (a == b || a == c) {
            System.out.println("There are at least two occurrences of " + a);
        } else {
            System.out.println("Blimey, this was complicated");
            System.out.println();
        }
    }

    public static void uppgift04(Scanner input) {
        System.out.println("Uppgift 04");
// Skriv din kod här
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        int tot = x + y + z;
        System.out.println(tot);
    }

    public static void uppgift05(Scanner input) {
        System.out.println("Uppgift 05");
// Skriv din kod här
        while (true) {
            System.out.println("Enter an even integer");
            int x = input.nextInt();
            if (x % 2 == 0) {
                break;
            }
            System.out.println("Number not even");
        }
    }

    public static void uppgift06() {
        System.out.println("Uppgift 06");
// Skriv din kod här
        for (int i = -5; i <= 5; i++) {
            System.out.println(i);
        }
    }

    public static void uppgift07() {
        System.out.println("Uppgift 07");
        int[] first = new int[]{4, 6, 8, 2, 1, 3};
        int[] second = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            System.out.print(first[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < second.length; i++) {
            System.out.print(second[i] + " ");
        }
        System.out.println();
// Skriv din kod här
        for (int i = 0; i<second.length; i++){
            second[i] = 2*first[i];
            System.out.print(second[i] + " ");
        }
    }

    public static void uppgift08() {
        System.out.println("Uppgift 08");
        int[][] grid = new int[13][13];
// Skriv din kod här
        System.out.println();
    }

    public static void uppgift09() {
        System.out.println("Uppgift 09");
// Skriv din kod här
        System.out.println();
    }

    public static void uppgift10() {
        System.out.println("Uppgift 10");
// Skriv din kod här

    }
}


