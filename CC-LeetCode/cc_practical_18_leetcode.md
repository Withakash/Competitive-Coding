# 🔹 Hash Table using Separate Chaining (Implementation + Practice)

---

## 📌 Problem Statement

Implement a hash table using **separate chaining** for collision handling.

Operations to perform:

1. Insertion
2. Deletion
3. Search

---

## 🧠 Concept

* Hash function maps key → index
* Each index stores a **linked list** (chain)
* Collision handled by inserting into same bucket list

---

## 🌳 Approach

* Use array of LinkedList
* Compute index using: `key % size`
* Traverse list for operations

---

## ✅ Java Implementation

```java
class HashNode {
    int key;
    int value;
    HashNode next;

    HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private int size = 10;
    private HashNode[] table;

    public MyHashMap() {
        table = new HashNode[size];
    }

    private int hash(int key) {
        return key % size;
    }

    // Insert
    public void put(int key, int value) {
        int index = hash(key);
        HashNode head = table[index];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode newNode = new HashNode(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    // Search
    public int get(int key) {
        int index = hash(key);
        HashNode head = table[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }

    // Delete
    public void remove(int key) {
        int index = hash(key);
        HashNode head = table[index];
        HashNode prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    table[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}
```

---

## ⏱ Complexity

* Average:

  * Insert: O(1)
  * Search: O(1)
  * Delete: O(1)
* Worst case: O(n) (all elements in one bucket)

---

## 🔗 Related Practice Problems

### 1. Design HashMap — LeetCode #706

[https://leetcode.com/problems/design-hashmap/](https://leetcode.com/problems/design-hashmap/)

### Concept

Build a custom HashMap using **separate chaining (LinkedList)**.

### Why Practice

* Understand internal working of HashMap
* Important for interviews

### Java Solution

```java
class MyHashMap {
    class Node {
        int key, value;
        Node next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Node[] buckets;
    private int size = 1000;

    public MyHashMap() {
        buckets = new Node[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        if (head == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = head;
        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index], prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null)
                    buckets[index] = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
```

---

### 2. Valid Anagram — LeetCode #242

[https://leetcode.com/problems/valid-anagram/](https://leetcode.com/problems/valid-anagram/)

Concept: Frequency counting using hashing

---

### 3. Two Sum — LeetCode #1

[https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)

Concept: Hash map lookup for complement

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
```

---

### 4. First Non-Repeating Character — GFG

[https://www.geeksforgeeks.org/first-non-repeating-character-in-a-stream/](https://www.geeksforgeeks.org/first-non-repeating-character-in-a-stream/)

Concept: Frequency map + traversal

---

### 5. Count Distinct Elements — GFG

[https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/](https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/)

Concept: Hashing + sliding window

---

## 🧠 Key Takeaways

* Separate chaining uses linked list to handle collisions
* Hashing provides average O(1) performance
* Widely used in real-world systems (caches, indexing)

---

## ✍️ Summary

This implementation helps you understand the internal working of hash maps and builds a strong foundation for solving hashing-based interview problems.
