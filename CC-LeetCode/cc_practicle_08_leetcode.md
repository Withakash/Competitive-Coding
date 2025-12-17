# Linked List Intersection & Operations — LeetCode Practical 08

This practical focuses on **important linked list operations** including merge point detection, reversal, cycle detection, and node removal.

---

## 🔵 1️⃣ Find Merge Point of Two Linked Lists

### Problem Statement
Write a program to find the **merge point (intersection node)** of two linked lists.  
The merge point is the node at which both linked lists join and share the same reference.

---

### Brief Explanation
- Use **two pointers**
- Traverse both lists
- When a pointer reaches the end, redirect it to the other list
- They will meet at the merge point

---

### Java Solution

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1;
    }
}
```

**Time Complexity:** O(n + m)  
**Space Complexity:** O(1)

---

## 🔵 2️⃣ LeetCode — Reverse Linked List

🔗 https://leetcode.com/problems/reverse-linked-list/

### Problem Statement
Reverse a singly linked list and return the reversed list.

---

### Brief Explanation
- Use **three pointers**: prev, curr, next
- Reverse links one by one

---

### Java Solution

```java
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## 🔵 3️⃣ LeetCode — Linked List Cycle

🔗 https://leetcode.com/problems/linked-list-cycle/

### Problem Statement
Determine if a linked list has a cycle.

---

### Brief Explanation
- Use **Floyd’s Cycle Detection Algorithm**
- Slow pointer moves one step
- Fast pointer moves two steps
- If they meet → cycle exists

---

### Java Solution

```java
class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## 🔵 4️⃣ LeetCode — Remove Linked List Elements

🔗 https://leetcode.com/problems/remove-linked-list-elements/

### Problem Statement
Remove all nodes of a linked list that have a specific value.

---

### Brief Explanation
- Use **dummy node** to handle head deletion
- Traverse list and skip matching nodes

---

### Java Solution

```java
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

---

## ✅ Practical Learning Outcomes

- Intersection of linked lists  
- Pointer manipulation  
- Cycle detection technique  
- Safe node deletion  
- Interview-ready linked list patterns  

---
