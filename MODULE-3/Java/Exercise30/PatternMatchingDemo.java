/**
 * Exercise30 - PatternMatchingDemo
 * 
 * Objective: Simplify conditional logic using Java 21 Pattern Matching for switch.
 * 
 * Pattern Matching for switch (standard in Java 21) allows switch expressions and 
 * statements to be evaluated against patterns. This simplifies code by combining 
 * type checking (instanceof) and casting into a single step.
 */
public class PatternMatchingDemo {

    /**
     * Processes an object and prints a message based on its concrete type using
     * Java 21 switch pattern matching.
     * 
     * @param obj the object to process
     */
    public static void process(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("Integer Value: " + i);
            case String s  -> System.out.println("String Value: " + s);
            case Double d  -> System.out.println("Double Value: " + d);
            case Boolean b -> System.out.println("Boolean Value: " + b);
            case null      -> System.out.println("Null Value");
            default        -> System.out.println("Unknown Value: " + obj);
        }
    }

    public static void main(String[] args) {
        // Demonstrate pattern matching with various student-related data types
        process(100);       // Integer (e.g. Student Count / Score)
        process("Student"); // String (e.g. Student Name / Status)
        process(99.5);      // Double (e.g. Student Average Grade)
        process(true);      // Boolean (e.g. Student Enrollment Status)
    }
}
