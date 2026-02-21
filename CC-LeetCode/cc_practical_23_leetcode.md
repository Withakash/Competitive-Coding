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

---

# 🔹 Sliding Window & Trie Based String Problems

---

## 📌 4. Longest Substring Without Repeating Characters — LeetCode #3

🔗 [https://leetcode.com/problems/longest-substring-without-repeating-characters/](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

### Concept

Sliding Window + HashSet / HashMap

### Why Practice

* Core sliding window problem
* Frequently asked in interviews

### Java Solution

```java
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```

### Complexity

* Time: O(n)
* Space: O(n)

---

## 📌 5. Number of Distinct Substrings — LeetCode #1698

🔗 [https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/](https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/)

### Concept

Trie / Suffix-based approach

### Why Practice

* Advanced string problem
* Builds strong Trie understanding

### Java Solution (Trie Based)

```java
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

    public int countDistinct(String s) {
        TrieNode root = new TrieNode();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            TrieNode node = root;

            for (int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                    count++;
                }

                node = node.children[idx];
            }
        }

        return count;
    }
}
```

### Complexity

* Time: O(n^2)
* Space: O(n^2)

---

## 🔥 Final Combined Takeaways

* Heap → Top K problems
* Sliding Window → Substring problems
* Trie → Prefix & substring problems

---

## 🚀 Interview Insight

If you see:

* "Unique substring" → Sliding Window / Set
* "All substrings" → Trie / Suffix
* "Top K" → Heap

Mastering these 3 patterns = **huge interview advantage 🚀**

---

# 🔹 Advanced Trie Problems

---

## 📌 6. Implement Trie (Prefix Tree) — LeetCode #208

🔗 [https://leetcode.com/problems/implement-trie-prefix-tree/](https://leetcode.com/problems/implement-trie-prefix-tree/)

### Concept

Basic Trie with insert, search, startsWith

### Java Solution

```java
class Trie {
    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String str) {
        Node curr = root;
        for (char c : str.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return null;
            curr = curr.children[idx];
        }
        return curr;
    }
}
```

---

## 📌 7. Implement Trie II (Prefix Tree) — LeetCode #1804

🔗 [https://leetcode.com/problems/implement-trie-ii-prefix-tree/](https://leetcode.com/problems/implement-trie-ii-prefix-tree/)

### Concept

Trie with count tracking:

* wordCount → exact word
* prefixCount → prefix occurrences

### Java Solution

```java
class Trie {
    class Node {
        Node[] children = new Node[26];
        int wordCount = 0;
        int prefixCount = 0;
    }

    private Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.prefixCount++;
        }
        curr.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        Node node = find(word);
        return node == null ? 0 : node.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        Node node = find(prefix);
        return node == null ? 0 : node.prefixCount;
    }

    public void erase(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            Node next = curr.children[idx];
            next.prefixCount--;
            curr = next;
        }
        curr.wordCount--;
    }

    private Node find(String str) {
        Node curr = root;
        for (char c : str.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return null;
            curr = curr.children[idx];
        }
        return curr;
    }
}
```

---

## 🔥 Key Takeaways (Trie Advanced)

* Basic Trie → search & prefix
* Trie II → counting + deletion
* Used in autocomplete, dictionary, search engines

---

## 🚀 Interview Insight

If you see:

* "prefix" → Trie
* "count words" → Trie with counters
* "dictionary" → Trie

Mastering Trie = strong edge in string problems 🚀
