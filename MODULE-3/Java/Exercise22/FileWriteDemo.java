import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Exercise22 - FileWriteDemo
 * 
 * Objective: Write data to a file.
 * 
 * This program prompts the user for student information and writes it to a file
 * named "output.txt" using FileWriter and BufferedWriter.
 */
public class FileWriteDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Student Information:");
        if (scanner.hasNextLine()) {
            String studentInfo = scanner.nextLine();
            String fileName = "output.txt";
            
            // try-with-resources statement ensures that resources are closed at the end of the program
            try (FileWriter fileWriter = new FileWriter(fileName);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                
                bufferedWriter.write(studentInfo);
                System.out.println(); // Blank line for formatting
                System.out.println("Data written successfully to " + fileName);
                
            } catch (IOException e) {
                System.out.println("\nError occurred while writing to the file: " + e.getMessage());
            }
        } else {
            System.out.println("\nInvalid input!");
        }
        
        scanner.close();
    }
}
