/**
 * Exercise07 - TypeCastingExample
 * 
 * Objective: Practice type casting between different data types (Narrowing and Widening conversion).
 * 
 * This program demonstrates:
 * 1. Explicit casting (Narrowing) - converting a double (larger size) to an int (smaller size).
 * 2. Implicit casting (Widening) - converting an int (smaller size) to a double (larger size).
 */
public class TypeCastingExample {

    public static void main(String[] args) {
        
        // --- 1. Double to Int Conversion (Explicit / Narrowing Casting) ---
        // Declare a double variable with a decimal value
        double originalDoubleValue = 45.78;
        
        // Convert the double value to int using explicit type casting
        // Note: The fractional part (.78) will be truncated, not rounded
        int convertedIntValue = (int) originalDoubleValue;
        
        // Display both the original and converted values
        System.out.println("Original Double Value : " + originalDoubleValue);
        System.out.println("Converted Int Value   : " + convertedIntValue);
        
        System.out.println(); // Blank line for formatting
        
        // --- 2. Int to Double Conversion (Implicit / Widening Casting) ---
        // Declare an int variable
        int originalIntegerValue = 100;
        
        // Convert the int value to double using implicit casting (widening)
        // Since double is a larger data type, Java performs this automatically
        double convertedDoubleValue = originalIntegerValue;
        
        // Display both the original and converted values
        System.out.println("Original Integer Value: " + originalIntegerValue);
        System.out.println("Converted Double Value: " + convertedDoubleValue);
    }
}
