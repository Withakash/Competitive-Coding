# Binary Search Tree (BST) Validation — LeetCode Problems

This document focuses on **checking and correcting BST validity** and understanding how **valid BSTs are constructed**.

It aligns directly with your **Practical — Valid Binary Search Tree**.

Each problem includes:

* Problem statement
* Concept
* Why to practice
* Java solution
* Official LeetCode link

---

# 🟢 **1. Validate Binary Search Tree — LeetCode #98**

🔗 [https://leetcode.com/problems/validate-binary-search-tree/](https://leetcode.com/problems/validate-binary-search-tree/)

### **Problem Statement**

Given the root of a binary tree, determine whether it is a **valid Binary Search Tree (BST)**.

A valid BST must satisfy:

1. Left subtree values < root value
2. Right subtree values > root value
3. Both subtrees must also be BSTs

### **Concept**

Use **recursive range checking** to ensure every node lies within a valid `(min, max)` range.

### **Why Practice?**

* Exact match with your **BST validation practical**
* Reinforces recursion, boundary conditions, and tree traversal

### **Java Solution (Range Method)**

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }
}
```


### **Java Solution (Inorder Mathod)**

```java
class Solution {

    private Integer prev = null;

    public boolean isValidBST(TreeNode root) {

        // Base case: empty tree is a valid BST
        if (root == null)
            return true;

        // Check left subtree
        if (!isValidBST(root.left))
            return false;

        // Inorder condition: current value must be greater than previous
        if (prev != null && root.val <= prev)
            return false;

        // Update previous value
        prev = root.val;

        // Check right subtree
        return isValidBST(root.right);
    }
}

```

---

# 🟢 **2. Recover Binary Search Tree — LeetCode #99**

🔗 [https://leetcode.com/problems/recover-binary-search-tree/](https://leetcode.com/problems/recover-binary-search-tree/)

### **Problem Statement**

Two nodes of a BST are swapped by mistake. Recover the tree **without changing its structure**.

### **Concept**

* Inorder traversal of BST should be **sorted**
* Detect two misplaced nodes during traversal
* Swap their values to restore BST

### **Why Practice?**

* Builds on **BST validation logic**
* Strengthens understanding of inorder traversal and BST properties

### **Java Solution**

```java
class Solution {
    TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;

        inorder(root.right);
    }
}
```

---

# 🟢 **3. Convert Sorted Array to Binary Search Tree — LeetCode #108**

🔗 [https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)

### **Problem Statement**

Given a sorted array, convert it into a **height-balanced BST**.

### **Concept**

* Middle element becomes root
* Left half → left subtree
* Right half → right subtree

### **Why Practice?**

* Helps understand how **valid BSTs are constructed**
* Complements BST validation by learning correct structure

### **Java Solution**

```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
```

---

# ✔️ Summary

This file covers:

* How to **validate a BST**
* How to **fix an invalid BST**
* How to **construct a valid BST**

Ideal for **DSA practicals, viva exams, and interview prep**.

---

