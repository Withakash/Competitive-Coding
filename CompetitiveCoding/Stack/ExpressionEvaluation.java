// ExpressionEvaluation
// Expression Evaluation Using Stack
//
// Starter Java template. Implement methods as required by the practical.
//
// Compile:
//   javac ExpressionEvaluation.java
// Run:
//   java ExpressionEvaluation
//
// Author: Akash Yadav

import java.util.Stack;

public class ExpressionEvaluation {

    // Method to evaluate postfix/RPN expression
    public static int evaluate(String[] exp) {
        Stack<Integer> stack = new Stack<>();

        for (String s : exp) {

            // If s is a number (multi-digit OR negative)
            if (s.length() > 1 || Character.isDigit(s.charAt(0))) {
                stack.push(Integer.parseInt(s));
            }
            else {
                // Operator case
                int b = stack.pop();
                int a = stack.pop();

                switch (s) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }


    // MAIN METHOD WITH EXAMPLES
    public static void main(String[] args) {

        // Example 1: multi-digit numbers
        String[] exp1 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        // Example 2: simple expression
        String[] exp2 = {"2", "1", "+", "3", "*"};

        // Example 3: includes negative numbers
        String[] exp3 = {"4", "13", "5", "/", "+"};

        System.out.println("Result 1: " + evaluate(exp1));  // Output: 22
        System.out.println("Result 2: " + evaluate(exp2));  // Output: 9
        System.out.println("Result 3: " + evaluate(exp3));  // Output: 6
    }
}
