# 🎯 Priority Queue Practical Flow (Teaching Notes)

## 🧩 STEP 1: Start with Problem (Hook Students)

**Problem:**

```
Find product of 3 largest distinct elements
arr = [2, 5, 3, 9, 5, 9]
```

**Ask Students:**
👉 How will you solve?

**Expected Answer:**

* Sorting

**Your Response:**
👉 "Good, but can we do better using a data structure?"

➡️ Introduce **Priority Queue**

---

## 🟡 STEP 2: What is Priority Queue?

### 🧠 Definition

> Elements are processed based on priority (not insertion order)

### 💡 Example

* Smallest first (Min Heap)
* Largest first (Max Heap)

---

## 🟡 STEP 3: Internal Working (IMPORTANT)

### 🧠 Key Point

> Priority Queue is implemented using a **Heap**

### 🎨 Complete Binary Tree

```
        1
      /   \
     5     3
    / \   /
   9   6 8
```

### 🧠 Concepts

1. **Complete Binary Tree**

   * Filled left → right (no gaps)

2. **Stored as Array**

```
[1, 5, 3, 9, 6, 8]
```

3. **Index Formula**

```
Parent = (i-1)/2
Left   = 2*i+1
Right  = 2*i+2
```

---

## 🟡 STEP 4: Heap Types

### 🔹 Min Heap

* Parent ≤ Children
* Top = smallest

### 🔹 Max Heap

* Parent ≥ Children
* Top = largest

### 🎯 Teaching Line

> Heap only guarantees TOP element

---

## 🟡 STEP 5: Heapify (CORE CONCEPT)

### 🔹 A. Heapify UP (Insertion)

### 🧠 Rule

> Insert at end → move UP

### 🎨 Example

```
Insert 2

        1
      /   \
     5     3
    / \   /
   9   6 8
            \
             2
```

👉 Swap UP:

```
2 ↔ 3
```

### 🧠 Line

> Fix from bottom to top

---

### 🔹 B. Heapify DOWN (Deletion)

### 🧠 Rule

> Remove root → move DOWN

### 🎨 Example

```
Remove 1 → replace with last (3)

        3
      /   \
     5     2
```

👉 Swap DOWN:

```
3 ↔ 2
```

### 🧠 Line

> Fix from top to bottom

---

## 🟡 STEP 6: Java Implementation

### 🔹 Min Heap (default)

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

### 🔹 Max Heap

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```

---

## 🟡 STEP 7: Comparator (IMPORTANT)

### 🧠 Definition

> Comparator decides ordering

### 🎯 Simple Table

| Comparator     | Behavior |
| -------------- | -------- |
| Default        | Min Heap |
| reverseOrder() | Max Heap |

### 🔥 Custom Comparator

```java
(a, b) -> b - a
```

👉 Bigger number = higher priority

---

## 🟡 STEP 8: Solve the Problem

### 🧠 Steps

1. Remove duplicates
2. Use Max Heap
3. Take top 3 elements
4. Multiply them

### 🎨 Dry Run

```
arr = [2, 5, 3, 9, 5]

Unique → [2, 5, 3, 9]

Heap Top → 9, 5, 3

Answer → 9 × 5 × 3 = 135
```

---

## 🟡 STEP 9: Code (Final)

```java
import java.util.*;

class Solution {
    public int maxProduct(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : set) {
            pq.add(num);
        }

        int a = pq.poll();
        int b = pq.poll();
        int c = pq.poll();

        return a * b * c;
    }
}
```

---

## 🟡 STEP 10: Ask Questions (VERY IMPORTANT)

👉 Why remove duplicates?
👉 Why Max Heap?
👉 What if less than 3 elements?

---

## 🚀 FINAL BOARD FLOW

1. Problem
2. Sorting approach
3. Need better solution
4. Priority Queue
5. Complete Binary Tree
6. Heap (Min/Max)
7. Heapify (Up/Down)
8. Comparator
9. Dry Run
10. Code

---

## 🎯 FINAL ONE-LINE SUMMARY

> Priority Queue uses heap → heapify maintains order → comparator decides priority
