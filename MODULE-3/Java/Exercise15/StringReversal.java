import java.util.Scanner;

/**
 * Exercise15 - StringReversal
 * 
 * Objective: Manipulate strings.
 * 
 * This program prompts the user to enter a string and reverses it using
 * StringBuilder's efficient built-in reverse() method.
 */
public class StringReversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a String: ");
        if (scanner.hasNextLine()) {
            String originalString = scanner.nextLine();
            
            // Reversing the string using StringBuilder
            StringBuilder stringBuilder = new StringBuilder(originalString);
            String reversedString = stringBuilder.reverse().toString();
            
            System.out.println(); // Blank line for formatting
            System.out.println("Reversed String: " + reversedString);
        } else {
            System.out.println("\nInvalid input!");
        }
        
        scanner.close();
    }
}
