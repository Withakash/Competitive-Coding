# Priority Queue Related Problems — LeetCode & GeeksforGeeks

This file contains the **closest and exact matching problems** related to:

### ✅ *Product of Three Largest Distinct Elements using Priority Queue*

Each problem includes:

* Short explanation
* Why it is related
* Clean Java solution using **Priority Queue / Heap**

---

# 🔵 **1. LeetCode 628 — Maximum Product of Three Numbers**

### **Why Related?**

* Very similar logic: find **top 3 largest numbers**.
* Can be solved using **PriorityQueue** or sorting.
* Handles negative numbers influencing product.

### **Problem Summary**

Given an integer array `nums`, return the **maximum product of any three numbers**.

### **Java Solution (Using Priority Queue)**

```java
class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            maxHeap.offer(num);
            minHeap.offer(num);
        }

        // Get the three largest
        int a = maxHeap.poll();
        int b = maxHeap.poll();
        int c = maxHeap.poll();

        // Get the two smallest
        int x = minHeap.poll();
        int y = minHeap.poll();

        return Math.max(a * b * c, a * x * y);
    }
}
```

---

# 🔵 **2. LeetCode 215 — K-th Largest Element in an Array**

### **Why Related?**

* Helps understand how to maintain **top K elements** with PQ.
* Useful for finding **largest 3 distinct values**.

### **Problem Summary**

Find the **k-th largest** element in the array.

### **Java Solution (Min Heap)**

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}
```

---

# 🔵 **3. LeetCode 347 — Top K Frequent Elements**

### **Why Related?**

* Classic **priority queue** use case.
* Pattern similar to finding "top K" items.

### **Problem Summary**

Return the **k most frequent elements**.

### **Java Solution**

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (var entry : freq.entrySet())
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = maxHeap.poll()[0];
        return res;
    }
}
```

---

# 🟢 **4. GFG — Product of Three Largest Distinct Elements (Exact Match)**

### **Why Related?**

* This is the **exact problem** you asked for.
* Solvable using:

  * Max Heap
  * Sorting
  * Three-variable tracking

### **Java Solution (Using Priority Queue)**

```java
class Solution {
    public static long maxProduct(long[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (long x : arr) pq.add(x);

        long a = pq.poll();

        long b = Long.MIN_VALUE;
        while (!pq.isEmpty()) {
            long x = pq.poll();
            if (x != a) { b = x; break; }
        }

        long c = Long.MIN_VALUE;
        while (!pq.isEmpty()) {
            long x = pq.poll();
            if (x != a && x != b) { c = x; break; }
        }

        if (b == Long.MIN_VALUE || c == Long.MIN_VALUE) return -1; // not enough distinct elements

        return a * b * c;
    }
}
```

---

# 🟢 **5. GFG — K Largest Elements**

### **Why Related?**

* Uses max heap to extract **top K largest elements**.

### **Java Solution**

```java
class Solution {
    public int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr) maxHeap.add(x);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = maxHeap.poll();
        return res;
    }
}
```

---

# 🟢 **6. GFG — Find the Largest Three Distinct Elements**

### **Problem Summary**

Return the largest **three distinct** numbers in the array.

### **Java Solution (Using Priority Queue)**

```java
class Solution {
    public static ArrayList<Integer> largestThreeDistinct(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) pq.offer(x);

        ArrayList<Integer> res = new ArrayList<>();
        Integer prev = null;

        while (!pq.isEmpty() && res.size() < 3) {
            int x = pq.poll();
            if (prev == null || x != prev) {
                res.add(x);
                prev = x;
            }
        }

        return res;
    }
}
```

---

# 🔗 Problem Links

### **LeetCode Links**

* **LeetCode 628 — Maximum Product of Three Numbers**
  [https://leetcode.com/problems/maximum-product-of-three-numbers/](https://leetcode.com/problems/maximum-product-of-three-numbers/)
* **LeetCode 215 — K-th Largest Element in an Array**
  [https://leetcode.com/problems/kth-largest-element-in-an-array/](https://leetcode.com/problems/kth-largest-element-in-an-array/)
* **LeetCode 347 — Top K Frequent Elements**
  [https://leetcode.com/problems/top-k-frequent-elements/](https://leetcode.com/problems/top-k-frequent-elements/)

### **GeeksforGeeks Links**

* **GFG — Product of Three Largest Distinct Elements**
  [https://www.geeksforgeeks.org/product-3-largest-numbers-array/](https://www.geeksforgeeks.org/product-3-largest-numbers-array/)
* **GFG — K Largest Elements**
  [https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/](https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/)
* **GFG — Find the Largest Three Distinct Elements**
  [https://www.geeksforgeeks.org/find-the-largest-three-elements-in-an-array/](https://www.geeksforgeeks.org/find-the-largest-three-elements-in-an-array/)

---

