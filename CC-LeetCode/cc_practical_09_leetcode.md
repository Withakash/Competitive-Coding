# Linked List Pairwise Swap & Advanced Operations — LeetCode Practical 09

This practical focuses on **pairwise node swapping** and other important **linked list problems** frequently asked in interviews and exams.

---

## 🔵 1️⃣ Swap Nodes Pairwise in a Linked List

### Problem Statement
Write a program to **swap nodes of a singly linked list pairwise**.

- Given a linked list:  
  `1 → 2 → 3 → 4`
- Output after pairwise swap:  
  `2 → 1 → 4 → 3`

⚠️ **Note:**  
Only **nodes should be swapped**, not the data values.

---

### 🔍 Brief Explanation (Logic)
- Use a **dummy node** before the head to handle edge cases
- Traverse the list **two nodes at a time**
- Swap links between the first and second node
- Move the pointer forward by two nodes after each swap

---

### ✅ Java Solution

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
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## 🔵 2️⃣ LeetCode — Next Greater Node in Linked List

🔗 https://leetcode.com/problems/next-greater-node-in-linked-list/

### Brief Explanation
Use array conversion and a **monotonic stack** to track the next greater element efficiently.

---

## 🔵 3️⃣ LeetCode — Swapping Nodes in a Linked List

🔗 https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

### Brief Explanation
Locate the kth node from start and end, then swap their values.

---

## 🔵 4️⃣ LeetCode — Remove Zero Sum Consecutive Nodes from Linked List

🔗 https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

### Brief Explanation
Use prefix sum with HashMap to detect and remove zero-sum sublists.

---

## ✅ Practical Learning Outcomes

- Pairwise node swapping  
- Dummy node technique  
- Stack and HashMap usage  
- Interview-focused linked list patterns  

---

**Practical No.:** 09  
**Subject:** Data Structures  
**Topic:** Linked List  
