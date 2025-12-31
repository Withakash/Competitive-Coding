# Linked List Intersection & Operations — LeetCode Practical 08

This practical focuses on **important linked list operations** including merge point detection, reversal, cycle detection, and node removal.

---


## 🔴 HackerRank Problem Statement (Exact)

**Problem:** Find Merge Point of Two Linked Lists\
**Link:**
https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

Given pointers to the head nodes of two linked lists that merge together
at some point, find the node where the two lists merge. The merge point
is where both lists point to the same node, i.e. they reference the same
memory location.

It is guaranteed that the two head nodes will be different, and neither
will be NULL. If the lists share a common node, return that node's
**value**.

**Note:** After the merge point, both lists will share the same node
pointers.

### Example

    [List #1] a -> b -> c
                        \
                         x -> y -> z -> NULL
                        /
    [List #2] p -> q

### Function Description

Complete the `findMergeNode` function.

**Parameters:**

-   `SinglyLinkedListNode head1` --- head of first list\
-   `SinglyLinkedListNode head2` --- head of second list

**Returns:**

-   `int` --- value of the merge node

------------------------------------------------------------------------

## 📘 Practical Objective

Understand how to detect the **merge point of two singly linked lists**
by comparing node references (memory locations), not values.

------------------------------------------------------------------------

## ✅ Approach 1: Two Pointer Switching Technique (Optimal)

### Logic

-   Use two pointers `p1` and `p2`
-   Traverse both lists
-   When a pointer reaches the end, redirect it to the other list's head
-   Eventually, both pointers meet at the merge point

### Time & Space Complexity

-   **Time:** O(n + m)
-   **Space:** O(1)

------------------------------------------------------------------------

## 🧠 Java Code (HackerRank Compatible)

``` java
static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode p1 = head1;
    SinglyLinkedListNode p2 = head2;

    while (p1 != p2) {
        p1 = (p1 == null) ? head2 : p1.next;
        p2 = (p2 == null) ? head1 : p2.next;
    }
    return p1.data; // merge point value
}
```

------------------------------------------------------------------------

## 🧪 Example Walkthrough

### Input

    List1: 1 → 2 → 3 → 4
    List2: 9 → 3 → 4

### Output

    3

------------------------------------------------------------------------

---


## 🔵 2️2 LeetCode — Reverse Linked List  #206

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

## 🔵 3. LeetCode — Linked List Cycle #141

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

## 🔵 4 LeetCode — Remove Linked List Elements #203

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
