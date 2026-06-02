/**
 * Exercise38 - DecompileDemo
 * 
 * Objective: Reverse engineer compiled Java bytecode using a decompiler.
 * 
 * This program is intentionally structured so that when compiled and decompiled
 * (using JD-GUI or CFR), the reconstructed source closely matches the original.
 * 
 * ─────────────────────────────────────────────
 * DECOMPILATION WORKFLOW:
 * ─────────────────────────────────────────────
 * Step 1: Compile  → javac DecompileDemo.java
 * Step 2: Decompile using one of:
 *
 *   Option A - CFR (Command Line):
 *     java -jar cfr.jar DecompileDemo.class
 *
 *   Option B - JD-GUI (Visual Tool):
 *     Open JD-GUI, drag DecompileDemo.class into the tool.
 *
 * Step 3: Compare the decompiled output with this original source.
 * ─────────────────────────────────────────────
 * ANALYSIS REPORT:
 * ─────────────────────────────────────────────
 * - Class name, method names, and field names:  RECONSTRUCTED
 * - Method return types and parameter types:    RECONSTRUCTED
 * - Control flow (if/else, loops):              RECONSTRUCTED
 * - String literals and constants:              RECONSTRUCTED
 * - Local variable names (e.g. 'studentName'):  MAY differ — compiler replaces
 *   them with generic names like 'str' or 'n'
 * - Comments:                                   NOT preserved in bytecode
 * ─────────────────────────────────────────────
 */
public class DecompileDemo {

    private String studentName;
    private int    studentAge;

    public DecompileDemo(String studentName, int studentAge) {
        this.studentName = studentName;
        this.studentAge  = studentAge;
    }

    public void displayInfo() {
        System.out.println("Student Name : " + studentName);
        System.out.println("Student Age  : " + studentAge);
    }

    public boolean isEligible() {
        return studentAge >= 18;
    }

    public static void main(String[] args) {
        DecompileDemo student = new DecompileDemo("Alice", 20);

        System.out.println("Original Source");
        System.out.println("     \u2193");
        System.out.println("Compiled Bytecode");
        System.out.println("     \u2193");
        System.out.println("Decompiled Source");
        System.out.println();

        student.displayInfo();
        System.out.println("Eligible : " + student.isEligible());
        System.out.println();
        System.out.println("Analysis Report:");
        System.out.println("Structure successfully reconstructed.");
    }
}
