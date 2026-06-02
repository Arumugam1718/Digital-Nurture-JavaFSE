package com.greetings;

import com.utils.Utility;

/**
 * Exercise34 - Main (com.greetings module)
 * 
 * Objective: Understand the Java Platform Module System (JPMS).
 * 
 * The com.greetings module consumes the Utility class exported by the com.utils module.
 * This demonstrates the module system's encapsulation and explicit dependency declaration.
 */
public class Main {

    public static void main(String[] args) {
        // Call the greet method from the imported Utility class (com.utils module)
        Utility.greet();
        System.out.println();
        
        // Call the execute method to simulate running a utility operation
        Utility.execute();
    }
}
