# Find Merge Point of Two Linked Lists --- HackerRank Practical 07

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

## 📌 Key Teaching Points

-   Merge point means **same node reference**, not same value
-   No extra memory needed
-   Very common **interview question**
-   Asked in **HackerRank, LeetCode, Infosys, TCS, Amazon**

------------------------------------------------------------------------

## ✅ Summary

-   Efficient, clean, and optimal solution
-   Perfect for **DSA practical exams** and **interview prep**

------------------------------------------------------------------------

✍️ Prepared by: Akash Yadav
