import java.util.ArrayList;
import java.util.Scanner;

/**
 * Exercise24 - ArrayListDemo
 * 
 * Objective: Use dynamic arrays.
 * 
 * This program prompts the user to enter student names, stores them in an ArrayList,
 * and iterates over them to display the final list.
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Number of Students: ");
        if (scanner.hasNextInt()) {
            int count = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            System.out.println(); // Blank line for formatting
            
            if (count <= 0) {
                System.out.println("Invalid number of students! Must be greater than 0.");
            } else {
                ArrayList<String> studentList = new ArrayList<>();
                
                System.out.println("Enter Name:");
                for (int i = 0; i < count; i++) {
                    String name = scanner.nextLine();
                    studentList.add(name);
                }
                
                System.out.println(); // Blank line for formatting
                System.out.println("Student List:");
                
                // Loop to iterate and print each element in the ArrayList
                for (String name : studentList) {
                    System.out.println(name);
                }
            }
        } else {
            System.out.println("\nInvalid input! Please enter a valid integer.");
        }
        
        scanner.close();
    }
}
