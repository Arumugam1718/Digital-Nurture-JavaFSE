/**
 * Exercise08 - OperatorPrecedence
 * 
 * Objective: Explore how Java evaluates expressions using operator precedence and associativity.
 * 
 * Precedence hierarchy in Java (BODMAS):
 * 1. Parentheses ()
 * 2. Multiplicative: Multiplication (*), Division (/), Remainder/Modulo (%) (Evaluated Left-to-Right)
 * 3. Additive: Addition (+), Subtraction (-) (Evaluated Left-to-Right)
 */
public class OperatorPrecedence {

    public static void main(String[] args) {
        
        // Expression 1: 10 + 5 * 2
        // '*' has higher precedence than '+', so 5 * 2 is evaluated first (10), then 10 + 10 = 20.
        int result1 = 10 + 5 * 2;
        System.out.println("Expression 1: 10 + 5 * 2");
        System.out.println("Result: " + result1);
        System.out.println();

        // Expression 2: (10 + 5) * 2
        // Parentheses () have the highest precedence, forcing 10 + 5 to be evaluated first (15), then 15 * 2 = 30.
        int result2 = (10 + 5) * 2;
        System.out.println("Expression 2: (10 + 5) * 2");
        System.out.println("Result: " + result2);
        System.out.println();

        // Expression 3: 20 / 2 + 3
        // '/' has higher precedence than '+', so 20 / 2 is evaluated first (10), then 10 + 3 = 13.
        int result3 = 20 / 2 + 3;
        System.out.println("Expression 3: 20 / 2 + 3");
        System.out.println("Result: " + result3);
        System.out.println();

        // Additional Demonstration using subtraction (-) and modulo (%) to fulfill all operator requirements (+, -, *, /, %)
        // 10 % 3 is performed first (evaluates to 1), and then subtracted from 15 (15 - 1 = 14).
        int result4 = 15 - 10 % 3;

        // Display explanation
        System.out.println("Explanation:");
        System.out.println("Multiplication and division are performed before addition unless parentheses are used.");
    }
}
