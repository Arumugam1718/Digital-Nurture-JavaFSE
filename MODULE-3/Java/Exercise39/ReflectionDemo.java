import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Exercise39 - ReflectionDemo
 * 
 * Objective: Use the Java Reflection API for dynamic class inspection and method invocation.
 * 
 * Java Reflection allows a program to inspect and manipulate classes, methods, and fields
 * at runtime — even when the class name is not known at compile time.
 * 
 * Key API calls used:
 * - Class.forName(String)      → Loads the class object dynamically by name.
 * - getDeclaredMethods()       → Returns all methods declared in the class (public & private).
 * - Method.invoke(Object, ...) → Calls the method on a given object instance.
 */

/**
 * The target class to be inspected via Reflection.
 */
class Student {

    /**
     * Prints the student's basic information.
     */
    public void displayInfo() {
        System.out.println("Student Information Displayed");
    }

    /**
     * Calculates and prints an indicative grade.
     */
    public void calculateGrade() {
        System.out.println("Grade Calculation Completed");
    }
}

/**
 * Main class demonstrating Reflection API usage.
 */
public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            // Step 1: Dynamically load the Student class by its fully-qualified name
            Class<?> studentClass = Class.forName("Student");
            System.out.println("Class Loaded Successfully");
            System.out.println();

            // Step 2: Retrieve all declared methods from the loaded class
            Method[] methods = studentClass.getDeclaredMethods();
            System.out.println("Methods Found:");
            for (Method method : methods) {
                System.out.println("  " + method.getName());
            }
            System.out.println();

            // Step 3: Create an instance of Student to invoke methods on
            Object studentInstance = studentClass.getDeclaredConstructor().newInstance();

            // Step 4: Get the displayInfo() method by name and invoke it dynamically
            System.out.println("Invoking displayInfo()");
            System.out.println();
            Method displayInfoMethod = studentClass.getMethod("displayInfo");
            displayInfoMethod.invoke(studentInstance);

        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found — " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("Error: Method not found — " + e.getMessage());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: Could not invoke method — " + e.getMessage());
        }
    }
}
