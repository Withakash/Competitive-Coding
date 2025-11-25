// Custom Min Stack Implementation WITHOUT using java.util.Stack

class ImplementMiStack {

    // --------------------------
    // Custom Stack Implementation
    // --------------------------
    static class MyStack {
        int[] arr;        // array to store stack elements
        int top;          // index of top element
        int capacity;     // stack size

        // Constructor: create stack of given size
        MyStack(int size) {
            arr = new int[size];
            top = -1;       // initially stack is empty
            capacity = size;
        }

        // Push element into stack
        void push(int x) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = x;  // increment top and add element
        }

        // Pop element from stack
        int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];   // return top element then decrease top
        }

        // Return top element
        int peek() {
            if (top == -1) return -1;
            return arr[top];
        }

        // Check empty
        boolean isEmpty() {
            return top == -1;
        }
    }

    // --------------------------
    // MinStack using Custom Stack
    // --------------------------
    static class Minstack {
        MyStack minstack = new MyStack(1000);
        MyStack mainstack = new MyStack(1000);

        public void push(int x) {
            mainstack.push(x);

            if (minstack.isEmpty() || minstack.peek() >= x) {
                minstack.push(x);
            }
        }

        public void pop() {
            int x = mainstack.pop();
            if (x == minstack.peek()) {
                minstack.pop();
            }
        }

        public int top() {
            return mainstack.peek();
        }

        public int getMin() {
            return minstack.peek();
        }
    }

    public static void main(String[] args) {
        Minstack m = new Minstack();

        m.push(10);
        m.push(5);
        m.push(11);

        System.out.println(m.getMin());  // 5
        m.pop();
        System.out.println(m.getMin());  // 5
    }
}
