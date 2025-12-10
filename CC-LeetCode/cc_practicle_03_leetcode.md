## Practical 3 — LeetCode Problems (Next Greater Element Variants)

This file contains the required **Next Greater Element (NGE) problems** from Practical 3 along with:

* Problem statements
* Concepts
* Input/output examples
* Clean Java solutions

---


---

# **1. Next Greater Element I — LeetCode #496**

### **Problem Statement**

You are given two **distinct** arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`.

For each element in `nums1`, find the **next greater element** to its right in `nums2`.
If no greater element exists, return `-1` for that element.

### **Concept**

* Use a **monotonic decreasing stack** on `nums2`.
* Traverse `nums2` and store the next greater element for each value using a **HashMap**.
* Build the result for `nums1` using the map.

### **Example 1**

**Input:**

```
nums1 = [4,1,2]
nums2 = [1,3,4,2]
```

**Output:**

```
[-1, 3, -1]
```

### **Example 2**

**Input:**

```
nums1 = [2,4]
nums2 = [1,2,3,4]
```

**Output:**

```
[3, -1]
```

### **Java Solution**

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
```

---

# **2. Next Greater Element II — LeetCode #503**

### **Problem Statement**

Given a **circular array**, find the Next Greater Element (NGE) for every element.
If no greater element exists, return `-1` for that position.

### **Concept**

Same as standard NGE, but the array loops around once more. Use a stack and iterate **twice** over the array.

### **Example**

**Input:**

```
[1,2,1]
```

**Output:**

```
[2, -1, 2]
```

### **Java Solution**

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!st.isEmpty() && nums[st.peek()] < num) {
                res[st.pop()] = num;
            }
            if (i < n) st.push(i);
        }
        return res;
    }
}
```

---

# **3. Next Greater Element III — LeetCode #556**

### **Problem Statement**

Given an integer `n`, find the next greater number formed using **same digits**.
If no such number exists, return `-1`.
Must fit in 32-bit signed integer.

### **Concept**

Same logic as finding the **next permutation**:

1. Scan from right to find the first decreasing digit.
2. Swap with the next greater digit.
3. Reverse the remaining part.

### **Example**

**Input:**

```
12443322
```

**Output:**

```
13222344
```

### **Java Solution**

```java
class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = ("" + n).toCharArray();
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return -1;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i + 1, arr.length - 1);

        long val = Long.parseLong(new String(arr));
        return (val > Integer.MAX_VALUE) ? -1 : (int) val;
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
```

