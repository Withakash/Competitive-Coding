// InfixToPostfix
// Infix to Postfix Conversion
//
// Starter Java template. Implement methods as required by the practical.
//
// Compile:
//   javac InfixToPostfix.java
// Run:
//   java InfixToPostfix
//
// Author: Akash Yadav


//https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1 GeekforGeeks Question

import java.util.Stack;

public class InfixToPostfix {

    // Function to return precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix to postfix
    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If ')', pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            }
            // Operator
            else {
                while (!stack.isEmpty() &&
                       precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "A+B*(C-D)";
        System.out.println("Postfix: " + infixToPostfix(infix));
    }
}
