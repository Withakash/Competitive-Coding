# Boundary Traversal of a Binary Tree (Anticlockwise)

This document explains how to **print the boundary traversal of a Binary Tree / BST** in **anticlockwise order**, starting from the root node.

Boundary traversal is an important composite traversal that combines **left boundary, leaves, and right boundary**.

---

## 🌳 Boundary Traversal Definition

Boundary traversal (anticlockwise) consists of:

1. **Root node**
2. **Left boundary** (excluding leaf nodes)
3. **All leaf nodes** (left to right)
4. **Right boundary** (excluding leaf nodes, printed bottom-up)

---

# 🟢 **Boundary of Binary Tree — LeetCode #545**

🔗 [https://leetcode.com/problems/boundary-of-binary-tree/](https://leetcode.com/problems/boundary-of-binary-tree/)

### **Problem Statement**

Given the root of a binary tree, return the **boundary traversal** of the tree in **anticlockwise order**, starting from the root.

### **Concept**

To solve this problem, divide the traversal into three parts:

* Traverse the **left boundary** (top-down, excluding leaves)
* Traverse all **leaf nodes** (using DFS)
* Traverse the **right boundary** (bottom-up, excluding leaves)

### **Why Practice?**

* Strengthens understanding of **multiple traversal combinations**
* Helps break down complex traversal logic into manageable steps
* Frequently asked in interviews and practical exams

---

## 🔍 Algorithm Steps

1. Add the root node (if not a leaf)
2. Traverse left boundary
3. Traverse all leaf nodes
4. Traverse right boundary in reverse order

---

## ✅ Java Solution

```java


import java.util.*;

class Solution {

    List<Integer> res = new ArrayList<>();   // 🌍 GLOBAL RESULT LIST

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return res;

        // Add root (only once)
        res.add(root.val);

        // Left Boundary (excluding leaves)
        addLeftBoundary(root.left);

        // Leaf Nodes
        addLeaves(root.left);
        addLeaves(root.right);

        // Right Boundary (excluding leaves, bottom-up)
        addRightBoundary(root.right);

        return res;
    }

    // ---------------- Helper Methods ----------------

    void addLeftBoundary(TreeNode node) {
        while (node != null) {
            if (!isLeaf(node))
                res.add(node.val);

            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    void addLeaves(TreeNode node) {
        if (node == null) return;

        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }

        addLeaves(node.left);
        addLeaves(node.right);
    }

    void addRightBoundary(TreeNode node) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            if (!isLeaf(node))
                stack.push(node.val);

            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        // Add in reverse order
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}


```

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(h)

  * h = height of the tree (stack + recursion)

---

# ✔️ Summary

This problem helps you:

* Understand **boundary traversal logic** clearly
* Combine multiple traversal techniques
* Improve problem decomposition skills

Perfect for **DSA practicals, viva exams, and interviews**.

---

