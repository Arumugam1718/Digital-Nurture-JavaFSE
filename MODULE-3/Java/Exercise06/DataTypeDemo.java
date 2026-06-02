/**
 * Exercise06 - DataTypeDemo
 * 
 * Objective: Understand Java's primitive data types.
 * This program demonstrates the declaration, initialization, and display 
 * of five common primitive data types in Java: int, float, double, char, and boolean.
 */
public class DataTypeDemo {

    public static void main(String[] args) {
        
        System.out.println("Java Primitive Data Types");
        System.out.println(); // Prints a blank line for formatting

        // 1. Integer (int) data type: used for storing whole numbers without decimals.
        // Range: -2^31 to 2^31 - 1
        int integerVar = 100;

        // 2. Single-precision Floating-Point (float) data type: used for storing fractional numbers.
        // Requires 'f' or 'F' suffix at the end of the literal value.
        float floatVar = 99.5f;

        // 3. Double-precision Floating-Point (double) data type: used for storing high-precision fractional numbers.
        // This is the default type for fractional numbers in Java.
        double doubleVar = 12345.6789;

        // 4. Character (char) data type: used to store a single character.
        // Must be enclosed in single quotes.
        char charVar = 'A';

        // 5. Boolean (boolean) data type: used for storing logical values (true or false).
        boolean booleanVar = true;

        // Displaying the names and values of the declared variables
        System.out.println("Integer Value : " + integerVar);
        System.out.println("Float Value   : " + floatVar);
        System.out.println("Double Value  : " + doubleVar);
        System.out.println("Character     : " + charVar);
        System.out.println("Boolean Value : " + booleanVar);
    }
}
