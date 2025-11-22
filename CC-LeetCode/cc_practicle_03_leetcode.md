# CC_Practicle_03_Leetcode.md

## Practical 3 — LeetCode Problems (Next Greater Element Variants)

This file contains the required **Next Greater Element (NGE) problems** from Practical 3 along with:
- Problem statements
- Concepts
- Input/output examples
- Clean Java solutions

---

# **1. Next Greater Element II — LeetCode #503**

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

# **2. Next Greater Element III — LeetCode #556**

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

        // step 1: find first decreasing digit
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return -1;

        // step 2: find next greater digit
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        // swap
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // step 3: reverse the suffix
        reverse(arr, i + 1, arr.length - 1);

        long val = Long.parseLong(new String(arr));
        return (val > Integer.MAX_VALUE) ? -1 : (int) val;
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++; r--;
        }
    }
}
```

