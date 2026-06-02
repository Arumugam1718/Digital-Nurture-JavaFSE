import java.util.HashMap;
import java.util.Scanner;

/**
 * Exercise25 - HashMapDemo
 * 
 * Objective: Use key-value pairs.
 * 
 * This program stores student IDs and student names in a HashMap, allows the user 
 * to register a student, and then search for them by their unique ID.
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> studentMap = new HashMap<>();
        
        System.out.print("Enter Student ID: ");
        if (scanner.hasNextInt()) {
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume remaining newline
            
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();
            
            // Store details in HashMap using put(Key, Value)
            studentMap.put(studentId, studentName);
            System.out.println(); // Blank line for formatting
            
            System.out.print("Enter ID to Search: ");
            if (scanner.hasNextInt()) {
                int searchId = scanner.nextInt();
                System.out.println(); // Blank line for formatting
                
                // Check if key exists in the HashMap and retrieve the value
                if (studentMap.containsKey(searchId)) {
                    System.out.println("Student Found:");
                    System.out.println(studentMap.get(searchId));
                } else {
                    System.out.println("Student with ID " + searchId + " not found.");
                }
            } else {
                System.out.println("\nInvalid search ID entered.");
            }
        } else {
            System.out.println("\nInvalid student ID entered.");
        }
        
        scanner.close();
    }
}
