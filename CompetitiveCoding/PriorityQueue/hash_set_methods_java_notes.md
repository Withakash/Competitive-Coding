# HashSet Methods in Java — Complete Notes with Code

---

## 1️⃣ What is HashSet?

`HashSet` is a part of Java Collection Framework that stores **unique elements** and does **not maintain insertion order**.

- Implements `Set` interface
- Uses **hashing** internally
- Allows **only one null value**

---

## 2️⃣ HashSet Class Hierarchy

```
Object
 └── AbstractCollection
     └── AbstractSet
         └── HashSet
```

---

## 3️⃣ Creating a HashSet

```java
HashSet<Integer> set = new HashSet<>();
```

---

## 4️⃣ HashSet Methods (With Code & Explanation)

### 🔹 add()
Adds an element to the set.

```java
set.add(10);
set.add(20);
```

---

### 🔹 remove()
Removes a specific element.

```java
set.remove(10);
```

---

### 🔹 contains()
Checks whether an element exists.

```java
set.contains(20); // true
```

---

### 🔹 size()
Returns number of elements.

```java
int n = set.size();
```

---

### 🔹 isEmpty()
Checks whether set is empty.

```java
set.isEmpty();
```

---

### 🔹 addAll()
Adds all elements of another collection (Union).

```java
set.addAll(otherSet);
```

---

### 🔹 removeAll()
Removes common elements (Difference).

```java
set.removeAll(otherSet);
```

---

### 🔹 retainAll()
Keeps only common elements (Intersection).

```java
set.retainAll(otherSet);
```

---

### 🔹 clear()
Removes all elements.

```java
set.clear();
```

---

### 🔹 toArray()
Converts set to array.

```java
Object[] arr = set.toArray();
```

---

## 5️⃣ Traversing a HashSet

```java
for (int x : set) {
    System.out.println(x);
}
```

---

## 6️⃣ Important Points (Viva)

- HashSet does NOT maintain order
- Duplicate elements are ignored
- Uses `hashCode()` and `equals()`
- Allows only one null

---

## 🔗 Reference
https://www.geeksforgeeks.org/java/hashset-in-java/
