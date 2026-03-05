# Hash Table with Separate Chaining (Java)

---

# 1. Recall Previous Topic

Before starting this topic, ask students:

**Why did basic hashing fail?**

Expected Answer:

* Collision problem

Example:

```
15 % 10 = 5
25 % 10 = 5
```

Both keys map to the same index.

In basic hashing:

* Old value gets overwritten ❌

So we need a technique to handle collisions.

---

# 2. Collision Handling Technique

One of the most common solutions is:

**Separate Chaining**

Idea:

Instead of storing a single value at each index, we store a **list of values**.

---

# 3. Core Concept

Each index of the hash table contains a **LinkedList**.

Example structure:

```
Index : Values

0 : -
1 : -
2 : -
3 : 23 -> 33
4 : -
5 : 15 -> 25 -> 35
6 : -
7 : 7
```

All elements that hash to the same index are stored in the linked list.

---

# 4. Hash Function

The same hash function is used:

```
h(key) = key % size
```

Example:

```
15 % 10 = 5
25 % 10 = 5
35 % 10 = 5
```

All these values go to index 5.

---

# 5. Data Structure Used

We use:

* Array
* LinkedList

So the structure becomes:

```
Array of LinkedList
```

In Java:

```java
LinkedList<Integer>[] table;
```

---

# 6. Java Implementation

```java
import java.util.*;

class HashTableChaining {

    int size;
    LinkedList<Integer>[] table;

    // Constructor
    HashTableChaining(int size) {
        this.size = size;
        table = new LinkedList[size];

        // Initialize each bucket
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash Function
    int hash(int key) {
        return key % size;
    }

    // Insert Operation
    void insert(int key) {
        int index = hash(key);
        table[index].add(key);
        System.out.println("Inserted " + key + " at index " + index);
    }

    // Search Operation
    boolean search(int key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    // Delete Operation
    void delete(int key) {
        int index = hash(key);
        table[index].remove(Integer.valueOf(key));
    }

    // Display Table
    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + " -> ");
            for (int val : table[i]) {
                System.out.print(val + " -> ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        HashTableChaining ht = new HashTableChaining(10);

        ht.insert(15);
        ht.insert(25);
        ht.insert(35);
        ht.insert(23);
        ht.insert(33);

        ht.display();

        System.out.println("Search 25: " + ht.search(25));
        System.out.println("Search 100: " + ht.search(100));

        ht.delete(25);

        System.out.println("After deleting 25:");
        ht.display();
    }
}
```

---

# 7. Step-by-Step Explanation

## Constructor

Creates hash table and initializes each bucket.

```
table = new LinkedList[size]
```

Each index contains an empty LinkedList.

---

## Insert Operation

Steps:

1. Calculate hash index
2. Add element to linked list

```
table[index].add(key)
```

Collision handled automatically.

---

## Search Operation

Steps:

1. Find index
2. Search in linked list

```
table[index].contains(key)
```

---

## Delete Operation

Steps:

1. Find index
2. Remove element from linked list

```
table[index].remove(Integer.valueOf(key))
```

---

# 8. Dry Run Example

Insert values:

```
15
25
35
```

Hash results:

```
15 % 10 = 5
25 % 10 = 5
35 % 10 = 5
```

Hash table becomes:

```
5 -> 15 -> 25 -> 35
```

---

# 9. Time Complexity

| Operation | Average | Worst Case |
| --------- | ------- | ---------- |
| Insert    | O(1)    | O(n)       |
| Search    | O(1)    | O(n)       |
| Delete    | O(1)    | O(n)       |

Worst case happens when all elements go into the same bucket.

---

# 10. Advantages

* Handles collisions properly
* Simple to implement
* Efficient for moderate load factors

---

# 11. Disadvantages

* Extra memory used for LinkedLists
* Performance decreases if chains become long

---

# 12. Real-Life Analogy

Think of a classroom attendance system:

* Index → Roll number group
* Linked list → Students in that group

Multiple students can belong to the same group.

---

# 13. Key Takeaway

**Separate Chaining handles collisions by storing multiple elements at the same index using a linked list.**
