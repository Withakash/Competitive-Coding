# 🔹 Trie (Prefix Tree) – LeetCode Practice (Java)

---

## 📌 1. Implement Trie (Prefix Tree) — LeetCode #208

🔗 [https://leetcode.com/problems/implement-trie-prefix-tree/](https://leetcode.com/problems/implement-trie-prefix-tree/)

### Concept

Build a Trie supporting:

* insert()
* search()
* startsWith()

### Why Practice

* Core Trie structure
* Foundation for all string-based DS problems

### Java Solution

```java
class Trie {
    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

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

## 📌 2. Add and Search Word — LeetCode #211

🔗 [https://leetcode.com/problems/add-and-search-word-data-structure-design/](https://leetcode.com/problems/add-and-search-word-data-structure-design/)

### Concept

Trie + Recursion
Supports wildcard '.'

### Why Practice

* Advanced Trie traversal
* Backtracking concept

### Java Solution

```java
class WordDictionary {
    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private Node root = new Node();

    public void addWord(String word) {
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
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, Node node) {
        if (i == word.length()) return node.isEnd;

        char c = word.charAt(i);

        if (c == '.') {
            for (Node child : node.children) {
                if (child != null && dfs(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = c - 'a';
            if (node.children[idx] == null) return false;
            return dfs(word, i + 1, node.children[idx]);
        }
    }
}
```

---

## 📌 3. Replace Words — LeetCode #648

🔗 [https://leetcode.com/problems/replace-words/](https://leetcode.com/problems/replace-words/)

### Concept

Use Trie to find shortest root word

### Why Practice

* Real-world Trie application
* Dictionary-based replacement

### Java Solution

```java
class Solution {
    class Node {
        Node[] children = new Node[26];
        String word = null;
    }

    private Node root = new Node();

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary) {
            insert(word);
        }

        StringBuilder result = new StringBuilder();
        for (String w : sentence.split(" ")) {
            if (result.length() > 0) result.append(" ");
            result.append(findRoot(w));
        }

        return result.toString();
    }

    private void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.word = word;
    }

    private String findRoot(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) break;
            curr = curr.children[idx];
            if (curr.word != null) return curr.word;
        }
        return word;
    }
}
```

---

## 🔥 Key Takeaways

* Trie is used for prefix-based problems
* Supports fast insert/search → O(L)
* Wildcard search uses recursion
* Useful in autocomplete, dictionary, search engines

---

## 🚀 Interview Tip

If you see:

* Prefix / dictionary → Trie
* Wildcard search → Trie + DFS
* Word replacement → Trie application
