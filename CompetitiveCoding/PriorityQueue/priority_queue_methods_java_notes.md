# PriorityQueue Methods in Java — Complete Notes with Code

---

## 1️⃣ What is PriorityQueue?

`PriorityQueue` is a queue where elements are processed based on **priority** rather than insertion order.

- Implemented using **Heap**
- Default: **Min Heap**

---

## 2️⃣ Min Heap vs Max Heap

### 🔹 Min Heap (Default)
Smallest element at the top.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

---

### 🔹 Max Heap (Using Comparator)
Largest element at the top.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```

---

## 3️⃣ PriorityQueue Methods (With Code & Explanation)

### 🔹 add()
Adds element, throws exception if fails.

```java
pq.add(10);
```

---

### 🔹 offer()
Adds element, returns false if fails.

```java
pq.offer(20);
```

---

### 🔹 remove()
Removes head, throws exception if empty.

```java
pq.remove();
```

---

### 🔹 poll()
Removes head, returns null if empty.

```java
pq.poll();
```

---

### 🔹 element()
Retrieves head, throws exception if empty.

```java
pq.element();
```

---

### 🔹 peek()
Retrieves head, returns null if empty.

```java
pq.peek();
```

---

### 🔹 size()
Returns number of elements.

```java
pq.size();
```

---

### 🔹 isEmpty()
Checks whether queue is empty.

```java
pq.isEmpty();
```

---

### 🔹 contains()
Checks if element exists.

```java
pq.contains(10);
```

---

### 🔹 clear()
Removes all elements.

```java
pq.clear();
```

---

## 4️⃣ Traversing PriorityQueue

```java
for (int x : pq) {
    System.out.println(x); // Order not guaranteed
}
```

---

## 5️⃣ Important Points (Viva)

- Default PriorityQueue → Min Heap
- Max Heap → Comparator required
- No index-based access
- Traversal order is NOT sorted

---

## 🎯 Time Complexity

- Insertion: O(log n)
- Removal: O(log n)
- Peek: O(1)

---

## 🔗 Reference
https://www.geeksforgeeks.org/priority-queue-class-in-java/
