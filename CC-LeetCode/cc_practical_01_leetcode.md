# CC_Practicle_01_Leetcode.md

## Practical 1 — LeetCode Problems

This file contains the required two LeetCode problems from Practical 1 along with their **problem statements**, **input/output expectations**, and **clean Java solutions**.

---

# **1. Min Stack — LeetCode #155**

### **Problem Statement**
Design a stack that supports the following operations in **O(1) time**:
- `push(x)` — Push element x onto stack
- `pop()` — Remove top element
- `top()` — Return top element
- `getMin()` — Retrieve minimum element in the stack

### **Concept**
Use an auxiliary structure (either another stack or store min with value) so that minimum retrieval is always constant time.

### **Input / Output Example**
**Input:**
```
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
```

**Output:**
```
[null,null,null,null,-3,null,0,-2]
```

---

## **Java Solution**
```java
class MinStack {
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
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```

---

# **2. Implement Queue using Stacks — LeetCode #232**

### **Problem Statement**
Implement a queue using **two stacks**. Queue supports:
- `push(x)` — Push element to back
- `pop()` — Remove front element
- `peek()` — Return front element
- `empty()` — Check if queue is empty

### **Concept**
Use two stacks:
- **Input stack** for pushing values
- **Output stack** for popping values
Transfer elements only when needed → maintains correct queue order.

### **Input / Output Example**
**Input:**
```
["MyQueue","push","push","peek","pop","empty"]
[[],[1],[2],[],[],[]]
```

**Output:**
```
[null,null,null,1,1,false]
```

---

## **Java Solution**
```java
class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MyQueue() {}

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        shiftStacks();
        return s2.pop();
    }

    public int peek() {
        shiftStacks();
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void shiftStacks() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}
```

---
