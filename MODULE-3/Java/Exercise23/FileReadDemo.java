import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Exercise23 - FileReadDemo
 * 
 * Objective: Read data from a file.
 * 
 * This program reads student data from the "output.txt" created in Exercise22
 * using BufferedReader. It includes robust file-checking to locate the file in
 * either the current directory or the relative Exercise22 folder.
 */
public class FileReadDemo {

    public static void main(String[] args) {
        String fileName = "output.txt";
        File file = new File(fileName);
        
        // Robust check: if output.txt isn't in current directory, check in Exercise22 directory
        if (!file.exists()) {
            file = new File("../Exercise22/output.txt");
        }
        
        System.out.println("Reading " + fileName);
        System.out.println(); // Blank line for formatting
        
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            System.out.println("Please run Exercise22 first to generate output.txt.");
        }
    }
}
