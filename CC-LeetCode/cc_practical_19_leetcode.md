# 🔹 Two Sum + Queue using Stacks (Java Solutions)

---

## 📌 Problem 1: Two Sum — LeetCode #1

🔗 [https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)

### Concept

Find two numbers in an array such that they add up to a target.
Use **HashMap (value → index)** for O(n) solution.

### Why Practice

* Most frequently asked interview question
* Introduces hashing for optimization

### Java Solution

```java
import java.util.*;

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

### Complexity

* Time: O(n)
* Space: O(n)

---

## 📌 Problem 2: Implement Queue using Stacks — LeetCode #232

🔗 [https://leetcode.com/problems/implement-queue-using-stacks/](https://leetcode.com/problems/implement-queue-using-stacks/)

### Concept

Use **two stacks** to simulate queue (FIFO behavior).

### Why Practice

* Strengthens stack understanding
* Classic data structure transformation problem

---

## 🧠 Approach 1: Two Stack Method (Optimal)

* stack1 → for push
* stack2 → for pop/peek

### Java Solution

```java
import java.util.*;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        peek();
        return s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
```

### Complexity

* Amortized O(1) for all operations

---

## 🧠 Approach 2: Single Stack (Costly Push)

### Java Solution

```java
import java.util.*;

class MyQueue {
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        stack.push(x);

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
```

### Complexity

* Push: O(n)
* Pop: O(1)

---



# 🔹 Two Sum Pattern – Complete Guide (Java)

---

## 📌 1. Two Sum — LeetCode #1

🔗 [https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)

### Concept

Use HashMap (value → index)

### Java Code

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

## 📌 2. Two Sum II (Sorted Array) — LeetCode #167

🔗 [https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

### Concept

Two pointers

### Java Code

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target)
                return new int[]{left + 1, right + 1};
            else if (sum < target)
                left++;
            else
                right--;
        }
        return new int[]{};
    }
}
```

---

## 📌 3. 3Sum — LeetCode #15

🔗 [https://leetcode.com/problems/3sum/](https://leetcode.com/problems/3sum/)

### Concept

Sort + Two pointers

### Java Code

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++; right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
```

---

## 📌 4. 4Sum — LeetCode #18

🔗 [https://leetcode.com/problems/4sum/](https://leetcode.com/problems/4sum/)

### Concept

Extend 3Sum

### Java Code

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
```

---

## 📌 5. Subarray Sum Equals K — LeetCode #560

🔗 [https://leetcode.com/problems/subarray-sum-equals-k/](https://leetcode.com/problems/subarray-sum-equals-k/)

### Concept

Prefix Sum + HashMap

### Java Code

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
```

---

## 📌 6. Key Pair — GFG

🔗 [https://www.geeksforgeeks.org/problems/key-pair5616/1](https://www.geeksforgeeks.org/problems/key-pair5616/1)

### Concept

Check if pair exists

### Java Code

```java
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int x) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(x - num)) return true;
            set.add(num);
        }
        return false;
    }
}
```

---

## 📌 7. Count Pairs with Given Sum — GFG

🔗 [https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1](https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1)

### Concept

Frequency map

### Java Code

```java
class Solution {
    int getPairsCount(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            count += map.getOrDefault(k - num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
```

---

## 📌 8. Two Number Sum — AlgoExpert

🔗 [https://www.algoexpert.io/questions/two-number-sum](https://www.algoexpert.io/questions/two-number-sum)

### Concept

Return numbers instead of indices

### Java Code

```java
class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    HashSet<Integer> set = new HashSet<>();

    for (int num : array) {
      int diff = targetSum - num;
      if (set.contains(diff)) {
        return new int[]{diff, num};
      }
      set.add(num);
    }
    return new int[]{};
  }
}
```

---

## 🔥 Final Takeaways

* HashMap → Unsorted array problems
* Two pointers → Sorted arrays
* Prefix sum → Subarray problems
* Extend → 3Sum, 4Sum

---

## 🚀 Interview Tip

If you master this pattern, you can solve **20+ problems easily**.
