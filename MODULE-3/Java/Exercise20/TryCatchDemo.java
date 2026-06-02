import java.util.Scanner;

/**
 * Exercise20 - TryCatchDemo
 * 
 * Objective: Understand exception handling using try-catch blocks.
 * 
 * Exception handling is a mechanism in Java that allows programs to handle runtime 
 * errors gracefully (like dividing by zero) without crashing.
 * 
 * Key Concepts:
 * 1. try block: Contains a block of code where exceptions might occur.
 * 2. catch block: Defines the handler for a specific type of exception thrown in the try block.
 */
public class TryCatchDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter First Number: ");
        if (scanner.hasNextInt()) {
            int firstNumber = scanner.nextInt();
            
            System.out.print("Enter Second Number: ");
            if (scanner.hasNextInt()) {
                int secondNumber = scanner.nextInt();
                System.out.println(); // Blank line for formatting
                
                try {
                    // This division will throw an ArithmeticException if secondNumber is 0
                    int result = firstNumber / secondNumber;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    // Handling the division by zero exception gracefully
                    System.out.println("Error: Cannot divide by zero.");
                }
            } else {
                System.out.println("\nError: Please enter a valid integer for the second number.");
            }
        } else {
            System.out.println("\nError: Please enter a valid integer for the first number.");
        }
        
        scanner.close();
    }
}
