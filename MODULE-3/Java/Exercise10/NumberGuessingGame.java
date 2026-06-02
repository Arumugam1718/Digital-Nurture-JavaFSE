import java.util.Scanner;
import java.util.Random;

/**
 * Exercise10 - NumberGuessingGame
 * 
 * Objective: Implement loops and conditional logic.
 * 
 * This program generates a random number between 1 and 100.
 * The user has to guess the number. The program provides feedback if the guess
 * is too high or too low, and displays the total number of attempts upon success.
 */
public class NumberGuessingGame {

    public static void main(String[] args) {
        // Create Scanner and Random instances
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Generate random number between 1 and 100
        // random.nextInt(100) generates 0 to 99, adding 1 gives 1 to 100
        int targetNumber = random.nextInt(100) + 1;
        
        int attemptsCount = 0;
        int userGuess = 0;
        
        // Loop until the correct number is guessed
        while (userGuess != targetNumber) {
            System.out.print("Guess a Number Between 1 and 100: ");
            
            // Read user input
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                attemptsCount++;
                
                if (userGuess < targetNumber) {
                    System.out.println("Too Low! Try Again.");
                    System.out.println(); // Blank line for formatting
                } else if (userGuess > targetNumber) {
                    System.out.println("Too High! Try Again.");
                    System.out.println(); // Blank line for formatting
                } else {
                    // Correct guess
                    System.out.println(); // Blank line before success message
                    System.out.println("Congratulations! You guessed the number.");
                    System.out.println("Attempts Taken: " + attemptsCount);
                }
            } else {
                System.out.println("Please enter a valid integer.");
                scanner.next(); // Consume the invalid token
                System.out.println();
            }
        }
        
        // Close scanner
        scanner.close();
    }
}
