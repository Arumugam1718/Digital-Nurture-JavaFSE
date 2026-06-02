import java.util.Scanner;

/**
 * Exercise14 - ArraySumAverage
 * 
 * Objective: Work with arrays and perform calculations.
 * 
 * This program prompts the user for the number of elements, stores them in an array, 
 * and calculates both the sum and the average of the elements using loops.
 */
public class ArraySumAverage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Number of Elements: ");
        if (scanner.hasNextInt()) {
            int size = scanner.nextInt();
            System.out.println(); // Blank line for formatting
            
            if (size <= 0) {
                System.out.println("Invalid size! Number of elements must be greater than 0.");
            } else {
                // Initialize the array
                int[] numbers = new int[size];
                
                System.out.println("Enter Elements:");
                for (int i = 0; i < size; i++) {
                    if (scanner.hasNextInt()) {
                        numbers[i] = scanner.nextInt();
                    } else {
                        System.out.println("Invalid input. Please enter integers only.");
                        scanner.close();
                        return;
                    }
                }
                System.out.println(); // Blank line for formatting
                
                // Calculate the sum of elements
                int sum = 0;
                for (int num : numbers) {
                    sum += num;
                }
                
                // Calculate the average of elements
                double average = (double) sum / size;
                
                // Display results
                System.out.println("Sum     = " + sum);
                System.out.println("Average = " + average);
            }
        } else {
            System.out.println("\nInvalid input. Please enter a valid integer.");
        }
        
        scanner.close();
    }
}
