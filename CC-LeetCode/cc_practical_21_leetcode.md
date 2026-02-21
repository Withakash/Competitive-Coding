# 🔹 Heap / Priority Queue – Top K Problems (Java)

---

## 📌 1. Kth Largest Element in an Array — LeetCode

🔗 [https://leetcode.com/problems/kth-largest-element-in-an-array/](https://leetcode.com/problems/kth-largest-element-in-an-array/)

### Concept

Use **Min Heap of size k**

### Why Practice

* Classic Top-K pattern
* Important interview question

### Java Solution

```java
import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
```

### Complexity

* Time: O(n log k)
* Space: O(k)

---

## 📌 2. Top K Frequent Elements — LeetCode

🔗 [https://leetcode.com/problems/top-k-frequent-elements/](https://leetcode.com/problems/top-k-frequent-elements/)

### Concept

HashMap + Min Heap

### Why Practice

* Combines hashing + heap
* Very common interview pattern

### Java Solution

```java
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }

        return res;
    }
}
```

### Complexity

* Time: O(n log k)
* Space: O(n)

---

## 📌 3. Kth Smallest Element in a Sorted Matrix — LeetCode

🔗 [https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)

### Concept

Min Heap OR Binary Search

### Approach 1: Min Heap

```java
import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        int count = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[0];
            int row = curr[1];
            int col = curr[2];

            count++;
            if (count == k) return val;

            if (col + 1 < n) {
                pq.add(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return -1;
    }
}
```

### Approach 2: Binary Search (Optimized)

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countLessEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int row = n - 1, col = 0, count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}
```

### Complexity

* Heap: O(k log n)
* Binary Search: O(n log range)

---

## 🔥 Key Takeaways

* Min Heap → Kth largest/smallest
* HashMap + Heap → frequency problems
* Binary Search → optimized for sorted structures

---

## 🚀 Interview Tip

Whenever you see:

* "Kth largest/smallest" → Think Heap
* "Top K" → Heap + Hashing
* "Sorted matrix" → Heap OR Binary Search
