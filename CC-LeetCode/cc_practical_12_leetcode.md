# Binary Tree Depth & Height — LeetCode Problems

This document focuses on understanding **depth, height, and level concepts** in a Binary Tree and how they are applied in popular **LeetCode problems**.

You will learn:

* What maximum and minimum depth mean
* How height relates to tree levels
* How depth logic is reused to solve advanced problems like diameter
* Time and space complexity analysis

---

## 🌳 Concepts: Depth, Height & Levels

* **Depth of a node**: Number of nodes from root to that node
* **Height of a tree**: Maximum depth of any leaf node
* **Level**: Depth counted starting from 1 (root at level 1)

In most problems:

> **Height = Maximum Depth of the Binary Tree**

---

# 🟢 **1. Maximum Depth of Binary Tree — LeetCode #104**

🔗 [https://leetcode.com/problems/maximum-depth-of-binary-tree/](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

### **Problem Statement**

Given the root of a binary tree, return its **maximum depth**.

### **Concept**

* Use recursion
* Height = `1 + max(leftDepth, rightDepth)`

### **Why Practice?**

* Fundamental binary tree problem
* Base for almost all tree algorithms

### **Java Solution (Recursive)**

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
```


### **Java Solution (Iterative)**

```java
class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();  // number of nodes in current level
            depth++;              // completed one level

            while(size-- > 0) {
                TreeNode curr = q.poll();

                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return depth;
    }
}
```
### **Time & Space Complexity**

* **Time:** O(n)
* **Space:** O(h) → recursion stack (h = tree height)

---

# 🟢 **2. Minimum Depth of Binary Tree — LeetCode #111**

🔗 [https://leetcode.com/problems/minimum-depth-of-binary-tree/](https://leetcode.com/problems/minimum-depth-of-binary-tree/)

### **Problem Statement**

Return the **minimum depth** from root to the nearest leaf node.

### **Concept**

* A leaf node has no children
* Special handling when one child is null

### **Why Practice?**

* Complements maximum depth logic
* Tests careful recursion handling

### **Java Solution**

```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
```

### **Time & Space Complexity**

* **Time:** O(n)
* **Space:** O(h)

---

# 🟢 **3. Diameter of Binary Tree — LeetCode #543**

🔗 [https://leetcode.com/problems/diameter-of-binary-tree/](https://leetcode.com/problems/diameter-of-binary-tree/)

### **Problem Statement**

Return the **diameter** of a binary tree — the length of the longest path between any two nodes.

### **Concept**

* Diameter = leftHeight + rightHeight
* Use depth calculation during DFS

### **Why Practice?**

* Extends max depth logic
* Shows how height helps solve advanced tree problems

### **Java Solution**

```java
class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }
}
```

### **Time & Space Complexity**

* **Time:** O(n)
* **Space:** O(h)

---

# ✔️ Summary

This file helps you understand:

* Maximum and minimum depth of a binary tree
* Height and level relationship
* How depth logic is reused in diameter problems

Perfect for **DSA practicals, viva exams, and LeetCode preparation**.

---
