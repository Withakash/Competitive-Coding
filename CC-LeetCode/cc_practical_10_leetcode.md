# Binary Search Tree (BST) — LeetCode Problems

This document covers **Binary Search Tree (BST)** construction and operations based on important **LeetCode problems**.

Each section includes:

* Problem description
* Concept
* Why to practice
* Java solution
* Official LeetCode link

---

# 🟢 **1. Insert into a Binary Search Tree — LeetCode #701**

🔗 [https://leetcode.com/problems/insert-into-a-binary-search-tree/](https://leetcode.com/problems/insert-into-a-binary-search-tree/)

### **Problem Statement**

You are given the root of a Binary Search Tree and a value to insert.
Insert the value into the BST and return the root.

### **Concept**

* Compare value with current node
* Insert into left subtree if smaller
* Insert into right subtree if greater

### **Why Practice?**

Strengthens understanding of **BST insertion logic**.

### **Java Solution**

```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);

        return root;
    }
}
```

---

# 🟢 **2. Search in a Binary Search Tree — LeetCode #700**

🔗 [https://leetcode.com/problems/search-in-a-binary-search-tree/](https://leetcode.com/problems/search-in-a-binary-search-tree/)

### **Problem Statement**

Given the root of a BST and a value, return the subtree rooted with that value.
If the value does not exist, return `null`.

### **Concept**

* If target < node → go left
* If target > node → go right
* If equal → return node

### **Why Practice?**

Reinforces **BST traversal and search** logic.

### **Java Solution**

```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}
```

---

# 🟢 **3. Construct Binary Search Tree from Preorder Traversal — LeetCode #1008**

🔗 [https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)

### **Problem Statement**

Given a preorder traversal of a BST, construct and return the BST.

### **Concept**

* First element is root
* Values smaller than root go to left subtree
* Values greater than root go to right subtree

### **Why Practice?**

Improves understanding of **BST structure and recursion**.

### **Java Solution**

```java
class Solution {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound)
            return null;

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);
        return root;
    }
}
```

---

# ✔️ Summary

This file helps you understand how to:

* Build a BST by inserting nodes
* Search values in BST
* Construct BST from preorder traversal

Perfect for **DSA practicals, viva, and LeetCode practice**.

---
