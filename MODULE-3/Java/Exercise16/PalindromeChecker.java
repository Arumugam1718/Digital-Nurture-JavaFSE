import java.util.Scanner;

/**
 * Exercise16 - PalindromeChecker
 * 
 * Objective: Combine string manipulation and conditional logic.
 * 
 * A palindrome is a word, phrase, number, or other sequence of characters 
 * that reads the same forward and backward, ignoring spaces, punctuation, and capitalization.
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a String:");
        if (scanner.hasNextLine()) {
            String originalString = scanner.nextLine();
            
            // Remove non-alphanumeric characters using regex, and convert to lowercase
            String cleanedString = originalString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            
            // Reverse the cleaned string to check if it matches
            String reversedCleanedString = new StringBuilder(cleanedString).reverse().toString();
            
            boolean isPalindrome = cleanedString.equals(reversedCleanedString);
            
            System.out.println(); // Blank line for formatting
            System.out.println("Result:");
            if (isPalindrome && !cleanedString.isEmpty()) {
                System.out.println(originalString + " is a Palindrome.");
            } else {
                System.out.println(originalString + " is Not a Palindrome.");
            }
        } else {
            System.out.println("\nInvalid input!");
        }
        
        scanner.close();
    }
}
