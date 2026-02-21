# 🔹 Symmetric Tree — LeetCode #101

🔗 [https://leetcode.com/problems/symmetric-tree/](https://leetcode.com/problems/symmetric-tree/)

---

## 📌 Concept

Check whether a binary tree is symmetric (mirror of itself).

A tree is symmetric if:

* Left subtree is a mirror of the right subtree
* Values match and structure is identical in mirror form

---

## 🚀 Why Practice

* Strengthens recursive tree comparison
* Helps in understanding mirror structures
* Useful for balanced tree and structural validation problems

---

## 🌳 Approach 1: Recursive Solution

### 💡 Idea

Compare two nodes:

* Values must be equal
* Left of first == Right of second
* Right of first == Left of second

### ✅ Code (Java)

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
}
```

### ⏱ Complexity

* Time: O(n)
* Space: O(h) (recursion stack)

---

## 🌳 Approach 2: Iterative Solution (Using Queue)

### 💡 Idea

Use a queue to compare nodes level by level in mirror order.

### ✅ Code (Java)

```java
import java.util.*;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;
    }
}
```

### ⏱ Complexity

* Time: O(n)
* Space: O(n)

---

## 🧠 Key Takeaways

* Symmetry = Mirror comparison
* Recursive = elegant and intuitive
* Iterative = good for BFS-based thinking
* Common interview question on tree structure

---

## 🔥 Related Problems

* Same Tree — LeetCode #100
* Invert Binary Tree — LeetCode #226
* Balanced Binary Tree — LeetCode #110

---

## ✍️ Summary

Understanding symmetry helps you master tree comparison problems and builds a strong foundation for advanced tree and graph algorithms.
