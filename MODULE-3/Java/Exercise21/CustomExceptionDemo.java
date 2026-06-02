import java.util.Scanner;

/**
 * Custom Exception class representing an invalid age check.
 * Inherits from standard Exception class to create a checked exception.
 */
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

/**
 * Exercise21 - CustomExceptionDemo
 * 
 * Objective: Create and use custom exceptions.
 * 
 * Key Concepts:
 * 1. Custom Exception: User-defined exception classes (like InvalidAgeException) created by extending 
 *    the base Exception class to handle domain-specific rules.
 * 2. 'throw' Keyword: Used to explicitly throw an exception object (e.g. throw new InvalidAgeException(...)).
 * 3. try-catch Handling: Catches the custom exception thrown during execution and executes alternative code.
 */
public class CustomExceptionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Age: ");
        if (scanner.hasNextInt()) {
            int age = scanner.nextInt();
            System.out.println(); // Blank line for formatting
            
            try {
                // Run the validation check
                validateAge(age);
                
                // If validateAge does not throw an exception, user is eligible
                System.out.println("Age Validation Successful.");
                System.out.println("User is Eligible.");
            } catch (InvalidAgeException e) {
                // Catching and displaying the message of our custom exception
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("\nError: Please enter a valid integer for age.");
        }
        
        scanner.close();
    }

    /**
     * Validates age and throws custom exception if age is less than 18.
     * Uses 'throws' clause in method signature to declare that it may throw this checked exception.
     */
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Explicitly throw the custom exception
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }
}
