# CC_Practicle_05_Leetcode.md

## Practical 5 — LeetCode Problems (Stack-Based Evaluation)

This file contains the required **five LeetCode stack‑based problems** from Practical 2, including:
- Problem statements
- Input/output examples
- Clean Java solutions

---

# **1. Evaluate Reverse Polish Notation — LeetCode #150**

### **Problem Statement**
Evaluate an expression in Reverse Polish Notation (postfix). Valid operators: `+`, `-`, `*`, `/`.

### **Example**
**Input:**
```
["2","1","+","3","*"]
```
**Output:**
```
9
```

### **Java Solution**
```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if ("+-*/".contains(s)) {
                int b = st.pop();
                int a = st.pop();
                switch (s) {
                    case "+": st.push(a + b); break;
                    case "-": st.push(a - b); break;
                    case "*": st.push(a * b); break;
                    case "/": st.push(a / b); break;
                }
            } else st.push(Integer.parseInt(s));
        }
        return st.pop();
    }
}
```

---

# **2. Basic Calculator — LeetCode #224**

### **Problem Statement**
Evaluate a simple expression containing `+`, `-`, `(`, `)`, and spaces.
Use stack to handle parentheses and maintain correct evaluation.

### **Example**
**Input:**
```
(1+(4+5+2)-3)+(6+8)
```
**Output:**
```
23
```

### **Java Solution**
```java
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0, sign = 1, res = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * num; num = 0; sign = 1;
            } else if (c == '-') {
                res += sign * num; num = 0; sign = -1;
            } else if (c == '(') {
                st.push(res); st.push(sign);
                res = 0; sign = 1;
            } else if (c == ')') {
                res += sign * num; num = 0;
                res *= st.pop();
                res += st.pop();
            }
        }
        return res + sign * num;
    }
}
```

---

# **3. Basic Calculator II — LeetCode #227**

### **Problem Statement**
Evaluate an expression containing non-negative integers and operators `+`, `-`, `*`, `/`.
No parentheses — but operator precedence must be respected.

### **Example**
**Input:**
```
3+2*2
```
**Output:**
```
7
```

### **Java Solution**
```java
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0; char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) num = num * 10 + (c - '0');

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (op == '+') st.push(num);
                else if (op == '-') st.push(-num);
                else if (op == '*') st.push(st.pop() * num);
                else if (op == '/') st.push(st.pop() / num);

                op = c; num = 0;
            }
        }

        int res = 0;
        while (!st.isEmpty()) res += st.pop();
        return res;
    }
}
```

---

# **4. Basic Calculator III — LeetCode #772 (Advanced)**

### **Problem Statement**
Same as Calculator II but supports parentheses.
Use stacks for both operands and operators.

### **Example**
**Input:**
```
2*(5+5*2)/3+(6/2+8)
```
**Output:**
```
21
```

### **Java Solution**
```java
class Solution {
    public int calculate(String s) {
        return helper(s.toCharArray(), new int[]{0});
    }

    private int helper(char[] arr, int[] idx) {
        Stack<Integer> st = new Stack<>();
        int num = 0; char op = '+';

        while (idx[0] < arr.length) {
            char c = arr[idx[0]];

            if (Character.isDigit(c)) num = num * 10 + (c - '0');

            if (c == '(') {
                idx[0]++;
                num = helper(arr, idx);
            }

            if (!Character.isDigit(c) && c != ' ' || idx[0] == arr.length - 1) {
                if (op == '+') st.push(num);
                else if (op == '-') st.push(-num);
                else if (op == '*') st.push(st.pop() * num);
                else if (op == '/') st.push(st.pop() / num);

                op = c; num = 0;
            }

            if (c == ')') break;
            idx[0]++;
        }

        int res = 0;
        for (int v : st) res += v;
        return res;
    }
}
```

---

# **5. Exclusive Time of Functions — LeetCode #636**

### **Problem Statement**
Given logs of function start/end times, compute each function’s **exclusive execution time** using a stack.

### **Java Solution**
```java
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                if (!st.isEmpty()) res[st.peek()] += time - prev;
                st.push(id);
                prev = time;
            } else {
                res[st.pop()] += time - prev + 1;
                prev = time + 1;
            }
        }
        return res;
    }
}
```
