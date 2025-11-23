// MinStack
// MINSTACK Implementation
//
// Starter Java template. Implement methods as required by the practical.
//
// Compile:
//   javac MinStack.java
// Run:
//   java MinStack
//
// Author: AKash Yadav

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {}

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(5);
        s.push(3);
        s.push(7);

        System.out.println("Current Min: " + s.getMin()); // 3

        s.pop();
        System.out.println("Top: " + s.top());            // 3
        System.out.println("Current Min: " + s.getMin()); // 3
    }
}

