import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise28 - StreamDemo
 * 
 * Objective: Process collections using streams.
 * 
 * This program demonstrates using the Java Stream API to process a collection of
 * student IDs. It filters out the odd IDs and collects only the even IDs into a 
 * new list.
 */
public class StreamDemo {

    public static void main(String[] args) {
        // Populate a list of student IDs
        List<Integer> studentIds = new ArrayList<>();
        studentIds.add(101);
        studentIds.add(102);
        studentIds.add(103);
        studentIds.add(104);

        System.out.println("Student IDs:");
        for (int id : studentIds) {
            System.out.println(id);
        }
        System.out.println(); // Blank line for formatting

        // Processing the collection using streams
        List<Integer> evenIds = studentIds.stream()
                                          .filter(id -> id % 2 == 0)
                                          .collect(Collectors.toList());

        System.out.println("Even IDs:");
        for (int id : evenIds) {
            System.out.println(id);
        }
    }
}
