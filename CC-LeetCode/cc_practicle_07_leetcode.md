# Linked List Advanced Merging & Sorting — LeetCode Practical 07

This practical covers **three important linked list problems** based on merging and sorting techniques.

---

## 🔵 1️⃣ LeetCode #21 — Merge Two Sorted Lists

### Problem Statement
Merge two sorted linked lists into one sorted linked list and return the head of the merged list.

---

### Brief Explanation
- Use **two pointers**, one for each list
- Compare nodes and attach the smaller one
- Continue until one list ends
- Attach remaining nodes

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
```

**Time Complexity:** O(n + m)  
**Space Complexity:** O(1)

---

## 🔵 2️⃣ LeetCode #23 — Merge k Sorted Lists

### Problem Statement
Merge **k sorted linked lists** into one sorted linked list.

---

### Brief Explanation
- Use **Min Heap (PriorityQueue)**
- Always pick the smallest node among k lists
- Insert next node of extracted list into heap

---

### Java Solution (Min Heap)

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for (ListNode node : lists)
            if (node != null) pq.offer(node);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null)
                pq.offer(node.next);
        }

        return dummy.next;
    }
}
```

**Time Complexity:** O(N log k)  
**Space Complexity:** O(k)

---

## 🔵 3️⃣ LeetCode #148 — Sort List

### Problem Statement
Sort a linked list in **O(n log n)** time and constant space complexity.

---

### Brief Explanation
- Use **Merge Sort**
- Split list into halves using slow & fast pointers
- Recursively sort both halves
- Merge sorted halves

---

### Java Solution (Merge Sort)

```java
class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        return merge(leftSorted, rightSorted);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
```

**Time Complexity:** O(n log n)  
**Space Complexity:** O(log n)

---

## 🟢 Related GeeksforGeeks Problems

- Merge Two Sorted Linked Lists  
  https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/

- Merge K Sorted Linked Lists  
  https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/

- Sort a Linked List  
  https://www.geeksforgeeks.org/sort-a-linked-list/

---

## ✅ Practical Learning Outcomes
- Two-pointer technique  
- Heap-based merging  
- Merge Sort on linked lists  
- Interview & competitive coding readiness  

---
