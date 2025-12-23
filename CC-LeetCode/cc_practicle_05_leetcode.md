## Practical 5 — Stack-Based Expression Problems (LeetCode + GFG)

This file contains **stack‑based expression evaluation and conversion problems**, including:

* Infix → Postfix conversion
* Postfix evaluation
* Expression calculators
* Function execution using stack

---

# **1. Infix to Postfix Conversion — GFG**

### **Problem Statement**

You are given a string `s` representing an **infix expression**. Convert this infix expression into a **postfix expression**.

**Infix:** operator between operands → `a + b`
**Postfix:** operator after operands → `a b +`

### **Operator Precedence**

* `^` : highest (right to left)
* `* /` : medium (left to right)
* `+ -` : lowest (left to right)

### **Example**

**Input:**

```
a*(b+c)/d
```

**Output:**

```
abc+*d/
```

### **Approach (Stack Based)**

1. If operand → add to result
2. If `(` → push to stack
3. If `)` → pop until `(`
4. If operator → pop higher/equal precedence operators
5. Pop remaining operators at end

### **Java Solution**

```java
class Solution {
    static int prec(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return -1;
    }

    public static String infixToPostfix(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) res.append(c);

            else if (c == '(') st.push(c);

            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    res.append(st.pop());
                st.pop();
            }
            else {
                while (!st.isEmpty() && prec(c) <= prec(st.peek())) {
                    if (c == '^' && st.peek() == '^') break;
                    res.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) res.append(st.pop());
        return res.toString();
    }
}
```

🔗 **Link:** [https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1](https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1)

---

# **2. Evaluate Reverse Polish Notation — LeetCode #150**

### **Problem Statement**

Evaluate an expression in Reverse Polish Notation (postfix). Valid operators: `+`, `-`, `*`, `/`.

### **Java Solution**

```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if ("+-*/".contains(s)) {
                int b = st.pop();
                int a = st.pop();
                if (s.equals("+")) st.push(a + b);
                else if (s.equals("-")) st.push(a - b);
                else if (s.equals("*")) st.push(a * b);
                else st.push(a / b);
            } else st.push(Integer.parseInt(s));
        }
        return st.pop();
    }
}
```
