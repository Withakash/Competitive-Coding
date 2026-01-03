# Linked List Pairwise Swap & Advanced Operations --- LeetCode Practical 09

This practical focuses on **pairwise node swapping** and other important
**linked list problems** frequently asked in interviews and exams.

------------------------------------------------------------------------

## 🔵 1️⃣ Swap Nodes Pairwise in a Linked List

### Problem Statement

Write a program to **swap nodes of a singly linked list pairwise**.

-   Given a linked list:\
    `1 → 2 → 3 → 4`
-   Output after pairwise swap:\
    `2 → 1 → 4 → 3`

⚠️ **Note:**\
Only **nodes should be swapped**, not the data values.

------------------------------------------------------------------------

### 🔍 Brief Explanation (Logic)

-   Use a **dummy node** before the head to handle edge cases
-   Traverse the list **two nodes at a time**
-   Swap links between the first and second node
-   Move the pointer forward by two nodes after each swap

------------------------------------------------------------------------

### ✅ Java Solution

``` java
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

**Time Complexity:** O(n)\
**Space Complexity:** O(1)

------------------------------------------------------------------------

## 🔵 2️⃣ LeetCode --- Next Greater Node in Linked List

🔗 https://leetcode.com/problems/next-greater-node-in-linked-list/

### 🔍 Explanation

Convert linked list to array, then use a **monotonic stack** to find the
next greater element.

### ✅ Java Solution

``` java
class Solution {
    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode temp = head; temp != null; temp = temp.next)
            list.add(temp.val);

        int[] res = new int[list.size()];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            while (!st.isEmpty() && list.get(st.peek()) < list.get(i)) {
                res[st.pop()] = list.get(i);
            }
            st.push(i);
        }
        return res;
    }
}
```

------------------------------------------------------------------------

## 🔵 3️⃣ LeetCode --- Swapping Nodes in a Linked List

🔗 https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

### 🔍 Explanation

Find **kth node from start** and **kth node from end**, then swap their
values.

### ✅ Java Solution

``` java
class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head, second = head, temp = head;

        for (int i = 1; i < k; i++)
            first = first.next;

        temp = first;

        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        int t = first.val;
        first.val = second.val;
        second.val = t;

        return head;
    }
}
```

------------------------------------------------------------------------

## 🔵 4️⃣ LeetCode --- Remove Zero Sum Consecutive Nodes from Linked List

🔗
https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

### 🔍 Explanation

Use **prefix sum + HashMap** to remove nodes forming zero-sum sequences.

### ✅ Java Solution

``` java
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;

        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            sum += curr.val;
            map.put(sum, curr);
        }

        sum = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            sum += curr.val;
            curr.next = map.get(sum).next;
        }

        return dummy.next;
    }
}
```

------------------------------------------------------------------------

## ✅ Practical Learning Outcomes

-   Pairwise node swapping
-   Dummy node technique
-   Stack-based next greater element
-   Prefix sum with HashMap
-   Interview-focused linked list patterns

------------------------------------------------------------------------

**Practical No.:** 09\
**Subject:** Data Structures\
**Topic:** Linked List

------------------------------------------------------------------------

✍️ Prepared by: Akash Yadav
