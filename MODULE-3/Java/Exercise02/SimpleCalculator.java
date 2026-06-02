import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("JAVA CALCULATOR");
        System.out.print(" Enter First Number  : ");
        double num1 = sc.nextDouble();

        System.out.print(" Enter Second Number : ");
        double num2 = sc.nextDouble();

        System.out.println("\n================ MENU ================");
        System.out.println(" 1. Addition");
        System.out.println(" 2. Subtraction");
        System.out.println(" 3. Multiplication");
        System.out.println(" 4. Division");
        System.out.println("======================================");

        System.out.print(" Select Operation (1-4): ");
        int choice = sc.nextInt();

        System.out.println("\n-------------- RESULT ----------------");

        switch (choice) {
            case 1:
                System.out.println(" Addition Result       : " + (num1 + num2));
                break;

            case 2:
                System.out.println(" Subtraction Result    : " + (num1 - num2));
                break;

            case 3:
                System.out.println(" Multiplication Result : " + (num1 * num2));
                break;

            case 4:
                if (num2 != 0) {
                    System.out.println(" Division Result       : " + (num1 / num2));
                } else {
                    System.out.println(" Error: Cannot divide by zero!");
                }
                break;

            default:
                System.out.println(" Invalid Choice!");
        }

        System.out.println("--------------------------------------");
        System.out.println(" Thank You for Using Calculator");
        System.out.println("**************************************************");

        sc.close();
    }
}