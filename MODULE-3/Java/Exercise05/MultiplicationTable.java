import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for a number
        System.out.print("Enter a Number: ");
        int number = scanner.nextInt();
        
        // Print a clear and readable heading
        System.out.println("\nMultiplication Table of " + number + "\n");
        
        // Use a for loop to iterate from 1 to 10
        for (int i = 1; i <= 10; i++) {
            // Multiply the input number by the loop counter
            int result = number * i;
            
            // Display the result in a formatted manner
            System.out.println(number + " x " + i + " = " + result);
        }
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
