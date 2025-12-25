# CC Practical 6 — Priority Queue, Heap & HashSet (Java)

---

## 1️⃣ Priority Queue in Java

A **Priority Queue** is a special type of queue where **each element has a priority**, and elements are processed based on priority rather than insertion order.

In Java, `PriorityQueue` is implemented using a **Heap** data structure.

### Types of Heaps

#### 🔹 Min Heap (Default in Java)
- Smallest element is always at the top
- Default behavior of `PriorityQueue`

Example:
```
Elements: 5, 2, 8, 1
Top Element: 1
```

#### 🔹 Max Heap
- Largest element is always at the top
- Achieved using a **Comparator**

Example:
```
Elements: 5, 2, 8, 1
Top Element: 8
```

---

## 2️⃣ Comparator in Priority Queue

A **Comparator** defines custom ordering for elements.

### Default (Min Heap)
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

### Max Heap using Comparator
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```

### Custom Comparator Example
```java
PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
```

---

## 3️⃣ Why Use Priority Queue Here?

To find the **3 largest distinct elements**:

| Approach | Time Complexity |
|--------|----------------|
| Sorting | O(n log n) |
| Priority Queue (k = 3) | O(n log k) ≈ O(n) |

Hence, Priority Queue is more efficient.

---

## 4️⃣ HashSet in Java

A **HashSet** is a collection that:
- Stores **unique elements only**
- Does **not maintain insertion order**
- Allows **null (only one)**

### Why HashSet?

We must remove duplicates before finding the top 3 elements.

---

## 5️⃣ HashSet Class Hierarchy

```
Object
 └── AbstractCollection
     └── AbstractSet
         └── HashSet
```

### Interfaces Implemented
- Set
- Collection
- Iterable

---

## 6️⃣ How HashSet Works Internally

- Uses **Hashing technique**
- Elements stored in buckets using `hashCode()`
- Uses `equals()` to avoid duplicates

---

## 7️⃣ Common HashSet Methods

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(10);   // duplicate, ignored

set.contains(20); // true
set.remove(10);
set.size();
set.isEmpty();
set.clear();
```

---

## 8️⃣ Complete Java Code: Product of 3 Largest Distinct Elements

```java
import java.util.*;

public class Practical6_ProductThreeLargest {

    public static int product(int[] arr) {
        // Step 1: Remove duplicates using HashSet
        Set<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);

        // Step 2: Max Heap using PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(set);

        // Step 3: Check if at least 3 distinct elements exist
        if (pq.size() < 3) return -1;

        int a = pq.poll();
        int b = pq.poll();
        int c = pq.poll();

        return a * b * c;
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 20, 20};
        System.out.println("Product: " + product(arr));
    }
}
```

---

## 9️⃣ Output Example

Input:
```
10 3 5 6 20 20
```

Output:
```
Product: 6000
```

---

## 🔗 Reference
- HashSet in Java (GFG): https://www.geeksforgeeks.org/java/hashset-in-java/

---

## 🎯 Exam / Viva Key Points

- PriorityQueue uses Heap internally
- Java default PriorityQueue → Min Heap
- Max Heap → use Comparator
- HashSet removes duplicates
- HashSet does not maintain order
- Time Complexity → O(n log k)

