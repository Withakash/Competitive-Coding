# Binary Tree Traversals — Inorder, Preorder & Postorder

This document helps you **understand and implement Binary Tree Traversals**, which are fundamental operations in tree-based data structures.

You will learn:

* What tree traversals are
* Difference between Inorder, Preorder, and Postorder
* Recursive and iterative approaches
* How traversal is used in BSTs and other tree problems

---

## 🌳 Tree Traversal Overview

| Traversal Type | Order               |
| -------------- | ------------------- |
| **Inorder**    | Left → Root → Right |
| **Preorder**   | Root → Left → Right |
| **Postorder**  | Left → Right → Root |

---

# 🟢 **1. Binary Tree Inorder Traversal — LeetCode #94**

🔗 [https://leetcode.com/problems/binary-tree-inorder-traversal/](https://leetcode.com/problems/binary-tree-inorder-traversal/)

### **Problem Statement**

Given the root of a binary tree, return the **inorder traversal** of its nodes’ values.

### **Concept**

* Visit left subtree
* Visit root
* Visit right subtree

### **Why Practice?**

* Reinforces traversal order understanding
* Foundation for **BST problems** (inorder gives sorted order)
* Tests recursion and stack manipulation

### **Java Solution (Recursive)**

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
```

### **Java Solution (Iterative using Stack)**

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
```

---

# 🟢 **2. Binary Tree Preorder Traversal — LeetCode #144**

🔗 [https://leetcode.com/problems/binary-tree-preorder-traversal/](https://leetcode.com/problems/binary-tree-preorder-traversal/)

### **Problem Statement**

Return the **preorder traversal** of a binary tree.

### **Concept**

* Visit root
* Visit left subtree
* Visit right subtree

### **Why Practice?**

* Builds clear understanding of visiting order
* Useful for tree construction and serialization
* Improves recursive and stack-based thinking

### **Java Solution (Recursive)**

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
```

### **Java Solution (Iterative using Stack)**

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}
```

---

# 🟢 **3. Binary Tree Postorder Traversal (Concept Only)**

### **Traversal Order**

Left → Right → Root

### **Why Important?**

* Used in deleting trees
* Helpful in expression tree evaluation

### **Recursive Java Example**

```java
void postorder(TreeNode root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
}
```

---

# ⏱️ Time & Space Complexity (All Traversals)

* **Time Complexity:** O(n)
* **Space Complexity:** O(h)

  * h = height of tree (recursion stack or explicit stack)

---

# ✔️ Summary

This file helps you:

* Understand **Inorder, Preorder, and Postorder traversals**
* Implement both **recursive and iterative** solutions
* Build a strong foundation for **BSTs and advanced tree problems**

---
