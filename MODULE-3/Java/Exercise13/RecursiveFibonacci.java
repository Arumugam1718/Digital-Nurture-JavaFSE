import java.util.Scanner;

/**
 * Exercise13 - RecursiveFibonacci
 * 
 * Objective: Implement recursion in Java.
 * 
 * Recursion is a programming technique where a method calls itself to solve a smaller 
 * instance of the same problem. Every recursive method must have:
 * 1. A base case to terminate recursion and prevent stack overflow.
 * 2. A recursive step that moves the state closer to the base case.
 */
public class RecursiveFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(); // Blank line for formatting
            
            if (n <= 0) {
                System.out.println("Invalid Input! Please enter a positive integer greater than 0.");
            } else {
                int result = fibonacci(n);
                System.out.println(n + "th Fibonacci Number = " + result);
            }
        } else {
            System.out.println("\nInvalid Input! Please enter a valid integer.");
        }
        
        scanner.close();
    }

    /**
     * Recursive method to calculate the nth Fibonacci number.
     * 
     * Fibonacci sequence definition:
     * F(1) = 1, F(2) = 1, and F(n) = F(n-1) + F(n-2) for n > 2.
     * 
     * @param n the index in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        // Base case: F(1) and F(2) are both defined as 1. F(0) or less is defined as 0.
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        
        // Recursive call: sum of the two preceding Fibonacci numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
