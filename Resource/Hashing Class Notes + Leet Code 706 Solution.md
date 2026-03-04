# 📘 Basic Hashing (Store & Retrieve) + LeetCode 706

---

# 🎯 1. Problem First (Hook Students)

## Problem:

Find if a number exists in the list

```
arr = [15, 23, 7, 10, 18]
Search: 10
```

## Student Answer:

* Linear Search → O(n)

## Problem:

* Slow for large data (10 lakh elements)

---

# 🎯 2. Direct Addressing

## Idea:

Use number as index

```
arr = [15, 23, 7]
```

Create array:

```
index: 0 1 2 3 ... 7 ... 15 ... 23
value: 0 0 0 0     1      1      1
```

## Advantage:

* Search in O(1)

## Problem:

```
arr = [1000000, 5, 9]
```

* Huge memory waste ❌

---

# 🎯 3. Hashing Concept

## Definition:

Hashing is a technique to map data to a fixed-size array using a hash function.

## Key Idea:

* Convert large number → small index

---

# 🎯 4. Hash Function

```
h(x) = x % size
```

Example:

```
23 % 10 = 3
```

---

# 🎯 5. Example (Store Values)

```
arr = [15, 23, 7, 10]
size = 10
```

```
h(15) = 5
h(23) = 3
h(7)  = 7
h(10) = 0
```

## Hash Table:

```
Index : Value
0     : 10
3     : 23
5     : 15
7     : 7
```

---

# 🎯 6. Operations

## Insert:

```
index = key % size
store at index
```

## Search:

```
index = key % size
check value
```

## Time Complexity:

* O(1) average

---

# ⚠️ 7. Collision Problem

```
15 % 10 = 5
25 % 10 = 5
```

## Collision:

Two keys map to same index

---

# 🎯 8. Collision Handling (Chaining)

## Idea:

Use Linked List at each index

```
index 5 → [15 → 25]
```

---

# 🎯 9. Java Implementation (Basic Hashing)

```java
class BasicHashing {
    int[] table;
    int size;

    BasicHashing(int size) {
        this.size = size;
        table = new int[size];
    }

    int hash(int key) {
        return key % size;
    }

    void insert(int key) {
        int index = hash(key);
        table[index] = key;
    }

    boolean search(int key) {
        int index = hash(key);
        return table[index] == key;
    }
}
```

---

# 🚀 10. LeetCode 706: Design HashMap

## Approach: Separate Chaining

* Use array of LinkedList
* Handle collisions properly

---

## ✅ Java Solution

```java
import java.util.*;

class MyHashMap {

    class Node {
        int key, value;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    int size = 1000;
    LinkedList<Node>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);

        for (Node node : buckets[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        buckets[index].add(new Node(key, value));
    }

    public int get(int key) {
        int index = hash(key);

        for (Node node : buckets[index]) {
            if (node.key == key) {
                return node.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);

        Iterator<Node> it = buckets[index].iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.key == key) {
                it.remove();
                return;
            }
        }
    }
}
```

---

# 🎯 11. Explanation

## Data Structure:

* Array of LinkedList

## Why?

* Handles collisions

## Operations:

### put():

* Find bucket
* Update if exists
* Else add new node

### get():

* Search in linked list

### remove():

* Remove node safely

---

# ⏱️ Complexity

| Operation | Time     |
| --------- | -------- |
| put       | O(1) avg |
| get       | O(1) avg |
| remove    | O(1) avg |

---

# 🎯 12. Teaching Flow Summary

1. Problem (slow search)
2. Direct Addressing
3. Problem in direct addressing
4. Hashing concept
5. Hash function
6. Example
7. Insert & Search
8. Collision
9. Collision handling
10. Code
11. LeetCode problem

---

# 🔥 Final Line to Say in Class

👉 "Hashing helps us achieve near constant time operations using smart indexing."
