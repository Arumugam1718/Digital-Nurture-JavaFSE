import java.util.ArrayList;
import java.util.List;

/**
 * Exercise29 - PersonRecordDemo
 * 
 * Objective: Use immutable data structures (Java Records).
 * 
 * Java Records (standard since Java 16) are a concise way to create immutable data carrier classes.
 * The compiler automatically generates the private final fields, getter methods (using accessor-style
 * naming like name() instead of getName()), constructors, toString(), equals(), and hashCode().
 */
public class PersonRecordDemo {

    // Define the Person record as an immutable data carrier
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        // Create list of students
        List<Person> studentList = new ArrayList<>();
        studentList.add(new Person("John", 20));
        studentList.add(new Person("Alex", 17));
        studentList.add(new Person("Maria", 22));

        System.out.println("All Students:");
        for (Person p : studentList) {
            System.out.println(p.name() + " " + p.age());
        }
        System.out.println(); // Blank line for formatting

        System.out.println("Eligible Students:");
        // Filter students older than 18 using the Stream API
        studentList.stream()
                   .filter(p -> p.age() > 18)
                   .forEach(p -> System.out.println(p.name()));
    }
}
