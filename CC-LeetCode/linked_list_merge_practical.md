# Linked List Merging Problems — LeetCode & GeeksforGeeks

This practical focuses on **merging sorted linked lists**, a very important pattern in Data Structures.

---

## 🔵 LeetCode #21 — Merge Two Sorted Lists

### Problem Statement

Write a program to **merge two sorted linked lists** into one sorted linked list.

The merged list should maintain sorted order and efficiently traverse both lists.

---

### Algorithm / Logic

1. Create two sorted linked lists  
2. Initialize pointers for both lists  
3. Compare current nodes of both lists  
4. Attach the smaller node to the merged list  
5. Move the pointer forward  
6. Repeat until one list ends  
7. Attach remaining nodes  

---

### Java Implementation

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }
}
```

---

### Time & Space Complexity

* **Time:** O(n + m)  
* **Space:** O(1)  

---

## 🔵 Related LeetCode Problems

### 1️⃣ LeetCode #23 — Merge k Sorted Lists

**Why Related?**

* Extension of merging two lists  
* Uses divide & conquer or heap  

🔗 https://leetcode.com/problems/merge-k-sorted-lists/

---

### 2️⃣ LeetCode #148 — Sort List

**Why Related?**

* Uses merge sort on linked lists  
* Core idea: splitting & merging  

🔗 https://leetcode.com/problems/sort-list/

---

## 🟢 Related GeeksforGeeks Problems

### 1️⃣ Merge Two Sorted Linked Lists

🔗 https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/

---

### 2️⃣ Merge K Sorted Linked Lists

🔗 https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/

---

### 3️⃣ Sort a Linked List

🔗 https://www.geeksforgeeks.org/sort-a-linked-list/

---

## ✅ Key Learning Outcomes

* Two-pointer technique  
* Efficient traversal of linked lists  
* Foundation for advanced linked list problems  
