# Part 4 -- Advanced Data Structures in Java

## 1. Stack

### Overview

A stack follows **LIFO (Last In, First Out)**. Useful for recursion
handling, expression evaluation, and backtracking.

### Concepts

-   Push, pop, peek
-   Stack underflow & overflow
-   Array-based & LinkedList-based stacks

### Java Implementations

-   `ArrayDeque` (recommended)
-   `Stack` (legacy)

### Common Problems

-   Valid Parentheses\
-   Next Greater Element\
-   Min Stack\
-   Postfix/Prefix Evaluation

------------------------------------------------------------------------

## 2. Queue

### Overview

A queue follows **FIFO (First In, First Out)**. Used in BFS, scheduling,
and streaming.

### Concepts

-   Enqueue, dequeue
-   Circular queue
-   Priority Queues

### Java Implementations

-   `LinkedList`
-   `ArrayDeque`
-   `PriorityQueue`

### Common Problems

-   Implement Queue Using Stacks\
-   Rotten Oranges (BFS)\
-   First Non-Repeating Character

------------------------------------------------------------------------

## 3. Linked List

### Overview

A collection of nodes where each node references the next (or previous).

### Types

-   Singly Linked List\
-   Doubly Linked List\
-   Circular Linked List

### Key Operations

-   Insert, delete
-   Reverse
-   Detect loop (Floyd Cycle Method)

### Common Problems

-   Reverse Linked List\
-   Merge Two Sorted Lists\
-   Detect Cycle\
-   Intersection of Two Lists

------------------------------------------------------------------------

## 4. Trees

### Overview

Hierarchical structure used in indexing, searching, and file systems.

### Types

-   Binary Tree
-   Binary Search Tree (BST)
-   AVL Tree
-   Heap (covered separately)

### Core Concepts

-   Height, depth
-   Traversals: Inorder, Preorder, Postorder, Level-order
-   Tree balancing

### Common Problems

-   LCA (Lowest Common Ancestor)\
-   Diameter of Binary Tree\
-   Validate BST\
-   Serialize/Deserialize Binary Tree

------------------------------------------------------------------------

## 5. Graphs

### Overview

A graph is a set of nodes connected by edges. Perfect for modeling
networks.

### Representations

-   Adjacency List (preferred)
-   Adjacency Matrix

### Traversals

-   BFS
-   DFS

### Advanced Concepts

-   Topological sort
-   Cycle detection
-   Shortest paths (Dijkstra)
-   Union-Find

### Common Problems

-   Number of Islands\
-   Bipartite Checking\
-   Shortest Path Problems\
-   Cycle Detection

------------------------------------------------------------------------

## 6. Heap

### Overview

A complete binary tree satisfying heap property.

### Types

-   Min-heap
-   Max-heap

### Java Implementation

-   `PriorityQueue` (default = min-heap)

### Common Problems

-   Kth Largest/Smallest Element\
-   Merge K Sorted Lists\
-   Top-K Frequent Elements\
-   Median of Data Stream

------------------------------------------------------------------------

## 7. HashMap

### Overview

Key-value data structure using hashing.

### Concepts

-   Hashing & collisions
-   Chaining
-   Load factor & resizing

### Java Implementations

-   `HashMap`
-   `LinkedHashMap`
-   `TreeMap`

### Common Problems

-   Two Sum\
-   Subarray With Zero Sum\
-   Group Anagrams\
-   Longest Consecutive Sequence

------------------------------------------------------------------------

## 8. Recursion

### Concepts

-   Base case, recursive case
-   Tail recursion
-   Backtracking
-   Stack limitations

### Common Problems

-   Subsets / Permutations\
-   N-Queens\
-   Tower of Hanoi\
-   Rat in a Maze

------------------------------------------------------------------------

## 9. Time & Space Complexity

### Concepts

-   Big-O notation
-   Amortized analysis
-   Complexity of recursion
-   Space from call stack

------------------------------------------------------------------------

## Purpose

This file serves as: - A detailed reference for DSA in Java\
- An interview preparation guide\
- A structured learning map
