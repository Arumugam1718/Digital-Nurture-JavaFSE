import java.util.Scanner;

public class EvenOddChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int number = sc.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " is an Even Number.");
        } else {
            System.out.println(number + " is an Odd Number.");
        }

        sc.close();
    }
}