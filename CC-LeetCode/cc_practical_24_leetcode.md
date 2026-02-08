# Left View of a Binary Tree

The **Left View of a Binary Tree** consists of the nodes that are visible when the tree is viewed from the **left side**.

At each level of the tree, **only the first node** encountered (from left to right) is part of the left view.

---

## 🌳 Left View Concept

* Traverse the tree **level by level**
* For each level, print the **first node**
* Can be implemented using:

  * **BFS (Level Order Traversal)**
  * **DFS (Preorder with level tracking)**

---

# 🟢 **Right View of Binary Tree — Based on LeetCode #199**

🔗 [https://leetcode.com/problems/binary-tree-right-side-view/](https://leetcode.com/problems/binary-tree-right-side-view/)

> ⚠️ Note: LeetCode #199 is **Right Side View**.
> The **Left View** uses the **same logic**, but prioritizes the **left child** instead of the right child.

---

## 📘 Problem Statement

Given the root of a binary tree, print the nodes visible from the **left side** of the tree.

---

## 💡 Concept

### BFS Approach

* Perform **level order traversal** using a queue
* At each level, the **first node processed** is part of the left view

### DFS Approach

* Use preorder traversal (Root → Left → Right)
* Track the maximum level visited
* First node at each level is added to the result

---

## 🎯 Why Practice?

* Strengthens understanding of **tree traversal**
* Improves knowledge of **level-wise processing**
* Frequently asked in **DSA practicals and interviews**

---

## ✅ Java Solution (BFS – Level Order)

```java
class Solution {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();


                  //(if (i == 0) result.add(node.val); // first node of level) for left side view this logic

                // ⭐ last node of this level
                if (i == size - 1)
                    result.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }
}
```

---

## ✅ Java Solution (DFS – Recursive)

```java
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> leftSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (level == result.size()) {
            result.add(node.val);
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
```

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(n)

  * Queue or recursion stack

---

# ✔️ Summary

This problem helps you:

* Understand **left-side visibility** in trees
* Apply **BFS and DFS** effectively
* Master level-wise traversal logic

Very important for **DSA practicals, viva exams, and interviews**.

---

If you want next:

* Right View vs Left View comparison
* Top View & Bottom View
* All views of binary tree in one file
* Convert to **PDF for submission**

Just tell me 🙂
