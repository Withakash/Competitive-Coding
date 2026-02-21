# 🔹 Lowest Common Ancestor of a Binary Tree — LeetCode #236

🔗 [https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

---

## 📌 Concept

Use recursion (or parent tracking) to find the deepest common parent node between two given nodes in a binary tree.

---

## 🎯 Why Practice

* Reinforces recursive tree traversal logic
* Builds foundation for graph ancestry and path problems

---

## 🧠 Approach 1: Recursive

### Idea:

* If root is null → return null
* If root equals p or q → return root
* Search in left and right subtree
* If both sides return non-null → root is LCA

### ✅ Java Code:

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }
}
```

### ⏱ Complexity:

* Time: O(N)
* Space: O(H) (recursion stack)

---

## 🧠 Approach 2: Iterative (Using Parent Map)

### Idea:

* Store parent of each node using DFS
* Trace path from node p to root
* Then move from q upward until common node found

### ✅ Java Code:

```java
import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        parent.put(root, null);
        stack.push(root);

        // Build parent map
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Store ancestors of p
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // Find first common ancestor for q
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}
```

### ⏱ Complexity:

* Time: O(N)
* Space: O(N)

---

## 🧩 Key Insight

* Recursive solution is cleaner and commonly asked in interviews
* Iterative solution helps understand tree-to-graph conversion

---

## 📚 Related Problems

* Binary Tree Right Side View (LeetCode #199)
* Binary Tree Paths
* Lowest Common Ancestor of BST (LeetCode #235)

---

