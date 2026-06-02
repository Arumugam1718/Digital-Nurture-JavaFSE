/**
 * Exercise12 - MethodOverloading
 * 
 * Objective: Understand method overloading in Java.
 * 
 * Method overloading is a feature that allows a class to have more than one method
 * with the same name, as long as their parameter lists are different (differing in
 * number, type, or order of parameters). It is a form of compile-time polymorphism.
 */
public class MethodOverloading {

    // 1. Overloaded method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // 2. Overloaded method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // 3. Overloaded method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        
        // Calling and displaying results from each overloaded method
        System.out.println("Sum of Two Integers      : " + add(10, 20));
        System.out.println("Sum of Two Doubles       : " + add(12.3, 13.2));
        System.out.println("Sum of Three Integers    : " + add(10, 20, 30));
    }
}
