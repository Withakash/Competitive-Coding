# Level Order Traversal of a Binary Tree (BFS)

This document explains **Level Order Traversal** of a Binary Tree, where nodes are visited **level by level**, from **top to bottom** and **left to right** at each level.

Level Order Traversal is based on **Breadth-First Search (BFS)** and is a fundamental concept in trees and graphs.

---

## 🌳 What is Level Order Traversal?

* Visit root node first
* Then visit all nodes at level 1 (children of root)
* Then visit all nodes at level 2, and so on

Traversal Order:

```
Level 0 → Root
Level 1 → Left Child, Right Child
Level 2 → Children of Level 1 (left to right)
```

---

# 🟢 **Binary Tree Level Order Traversal — LeetCode #102**

🔗 [https://leetcode.com/problems/binary-tree-level-order-traversal/](https://leetcode.com/problems/binary-tree-level-order-traversal/)

### **Problem Statement**

Given the root of a binary tree, return the **level order traversal** of its nodes' values.
Each level should be returned as a separate list.

---

### **Concept**

* Use a **Queue** data structure
* Process nodes **level by level**
* For each level, record the number of nodes and process them

---

### **Why Practice?**

* Builds strong understanding of **queue-based traversal**
* Helps master **Breadth-First Search (BFS)**
* Used in many advanced tree and graph problems

---

## ✅ Java Solution (Using Queue – BFS)

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** O(n)

  * Each node is visited once
* **Space Complexity:** O(n)

  * Queue can store up to one full level of nodes

---

# ✔️ Summary

This problem helps you:

* Understand **level-by-level traversal**
* Apply **BFS using a queue**
* Strengthen tree traversal fundamentals

Essential for **DSA practicals, viva exams, and interview preparation**.

---

