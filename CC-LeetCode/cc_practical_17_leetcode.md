# HashMap Practice – LeetCode Problems (Java)

---

## 1. Design HashMap — LeetCode #706

🔗 [https://leetcode.com/problems/design-hashmap/](https://leetcode.com/problems/design-hashmap/)

### Concept

Build a custom HashMap using **separate chaining (LinkedList)**.

### Why Practice

* Understand internal working of HashMap
* Important for interviews

### Java Solution

```java
class MyHashMap {
    class Node {
        int key, value;
        Node next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Node[] buckets;
    private int size = 1000;

    public MyHashMap() {
        buckets = new Node[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        if (head == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = head;
        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index], prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null)
                    buckets[index] = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
```

---

## 2. Valid Anagram — LeetCode #242

🔗 [https://leetcode.com/problems/valid-anagram/](https://leetcode.com/problems/valid-anagram/)

### Concept

Use frequency array / hashmap to compare characters.

### Java Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (char c : t.toCharArray()) freq[c - 'a']--;

        for (int f : freq)
            if (f != 0) return false;

        return true;
    }
}
```

---

## 3. Two Sum — LeetCode #1

🔗 [https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)

### Concept

Use HashMap to store value → index.

### Java Solution

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
```

---

## 4. First Unique Character in a String — LeetCode #387

🔗 [https://leetcode.com/problems/first-unique-character-in-a-string/](https://leetcode.com/problems/first-unique-character-in-a-string/)

### Concept

Count frequency using hashmap / array.

### Java Solution

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) freq[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
```

---

## 5. Top K Frequent Elements — LeetCode #347

🔗 [https://leetcode.com/problems/top-k-frequent-elements/](https://leetcode.com/problems/top-k-frequent-elements/)

### Concept

Combine HashMap + Heap.

### Java Solution

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll();

        return res;
    }
}
```

---

## Summary

* Design HashMap → Internal working
* Anagram → Frequency counting
* Two Sum → Lookup optimization
* Unique Character → Counting
* Top K → HashMap + Heap

---

🔥 These cover almost all important **HashMap patterns for interviews**.
