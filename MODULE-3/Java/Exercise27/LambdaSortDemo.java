import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exercise27 - LambdaSortDemo
 * 
 * Objective: Use functional programming features.
 * 
 * This program demonstrates how to use a lambda expression as a Comparator to 
 * sort a list of student names alphabetically using Collections.sort().
 */
public class LambdaSortDemo {

    public static void main(String[] args) {
        // Create a list of student names
        List<String> studentNames = new ArrayList<>();
        studentNames.add("John");
        studentNames.add("Alex");
        studentNames.add("Maria");

        System.out.println("Before Sorting:");
        for (String name : studentNames) {
            System.out.println(name);
        }
        
        System.out.println(); // Blank line for formatting

        // Use Collections.sort with a lambda expression representing the Comparator
        Collections.sort(studentNames, (name1, name2) -> name1.compareTo(name2));

        System.out.println("After Sorting:");
        for (String name : studentNames) {
            System.out.println(name);
        }
    }
}
