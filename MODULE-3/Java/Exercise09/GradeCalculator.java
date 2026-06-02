import java.util.Scanner;

/**
 * Exercise09 - GradeCalculator
 * 
 * Objective: Use conditional statements to determine student grades based on marks.
 * 
 * Grading Criteria:
 * - 90 to 100 -> Grade A
 * - 80 to 89  -> Grade B
 * - 70 to 79  -> Grade C
 * - 60 to 69  -> Grade D
 * - Below 60  -> Grade F
 */
public class GradeCalculator {

    public static void main(String[] args) {
        // Create Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter marks
        System.out.print("Enter Marks: ");
        
        // Validate that user entered an integer
        if (scanner.hasNextInt()) {
            int marks = scanner.nextInt();
            System.out.println(); // Blank line for formatting
            
            // Validate input: marks must be between 0 and 100
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid Marks! Marks must be between 0 and 100.");
            } else {
                char grade;
                
                // Determine grade using if-else-if statements
                if (marks >= 90) {
                    grade = 'A';
                } else if (marks >= 80) {
                    grade = 'B';
                } else if (marks >= 70) {
                    grade = 'C';
                } else if (marks >= 60) {
                    grade = 'D';
                } else {
                    grade = 'F';
                }
                
                // Display results
                System.out.println("Student Result");
                System.out.println("Marks : " + marks);
                System.out.println("Grade : " + grade);
            }
        } else {
            System.out.println("\nInvalid Input! Please enter a valid integer.");
        }
        
        // Close scanner
        scanner.close();
    }
}
