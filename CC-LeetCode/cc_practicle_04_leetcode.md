# CC_Practicle_04_Leetcode.md

## Practical 4 — LeetCode Problems (Circular Queue & Circular Game)

This file includes the required **two circular-structure problems** for Practical 4 with:
- Problem statements
- Concepts
- Input/output examples
- Clean Java solutions

---

# **1. Design Circular Deque — LeetCode #641**

### **Problem Statement**
Design a **circular deque** with the following operations:
- `insertFront()`
- `insertLast()`
- `deleteFront()`
- `deleteLast()`
- `getFront()`
- `getRear()`
- `isEmpty()`
- `isFull()`

### **Concept**
Use a **fixed-size circular array** with two pointers:
- `front`
- `rear`

Take care of wrap-around using modulo arithmetic.

### **Example**
**Input:**
```
["MyCircularDeque","insertLast","insertLast","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
[[3],[1],[2],[3],[],[],[],[4],[]]
```
**Output:**
```
[null,true,true,true,2,true,true,true,4]
```

### **Java Solution**
```java
class MyCircularDeque {
    private int[] arr;
    private int front, rear, size, capacity;

    public MyCircularDeque(int k) {
        arr = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        size++;
        if (size == 1) rear = front;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
```

---

# **2. Find the Winner of the Circular Game — LeetCode #1823**

### **Problem Statement**
Given `n` players in a circle, eliminate every `k`th player until only one remains.
Return the index of the last remaining player.

### **Concept**
This is the **Josephus problem**. Use:
- Queue simulation **OR**
- Mathematical recurrence: `res = (res + k) % i`

### **Example**
**Input:**
```
n = 5, k = 2
```
**Output:**
```
3
```

### **Java Solution (Efficient — O(n))**
```java
class Solution {
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res + k) % i;
        }
        return res + 1;
    }
}
```

---

If you want, I can also:
- Add C++ / Python versions
- Add explanation diagrams (especially for Josephus problem)
- Add viva/interview questions
- Combine all practicals into one final submission PDF