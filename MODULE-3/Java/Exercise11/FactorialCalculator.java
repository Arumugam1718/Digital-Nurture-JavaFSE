import java.util.Scanner;

/**
 * Exercise11 - FactorialCalculator
 * 
 * Objective: Use loops to perform repetitive calculations.
 * 
 * This program prompts the user to enter a non-negative integer,
 * validates the input, and calculates its factorial using a 'for' loop.
 */
public class FactorialCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a Number: ");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println(); // Blank line for formatting
            
            if (number < 0) {
                System.out.println("Invalid Input! Factorial is not defined for negative numbers.");
            } else {
                long factorialResult = 1;
                
                // Calculate factorial using a for loop
                for (int i = 1; i <= number; i++) {
                    factorialResult *= i;
                }
                
                System.out.println("Factorial of " + number + " = " + factorialResult);
            }
        } else {
            System.out.println("\nInvalid Input! Please enter a valid integer.");
        }
        
        scanner.close();
    }
}
