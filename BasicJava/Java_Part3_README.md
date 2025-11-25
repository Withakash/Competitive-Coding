# Java Learning Roadmap -- Part 3

## Advanced Java Concepts -- Practical, Simple & Beginner-Friendly

This **README.md** contains **Part 3** of the Java Learning Series**.\
It focuses on the most important **Advanced Java concepts\*\* you must
master before learning Collections & DSA.

Easy to understand ✔\
Beginner‑friendly ✔\
Perfect for GitHub notes ✔

------------------------------------------------------------------------

# 🚀 Part 3: Advanced Java Topics

This part covers:

1.  Strings\
2.  Wrapper Classes\
3.  Exception Handling\
4.  File Handling\
5.  Packages\
6.  Java Collections Introduction\
7.  Generics

Let's begin.

------------------------------------------------------------------------

# 📌 1. Strings in Java

Java Strings are **immutable**, meaning once created, they **cannot be
changed**.

### ✔ Creating Strings

``` java
String s1 = "Hello";         // String literal
String s2 = new String("Hi"); // Using new keyword
```

### ✔ Useful String Methods

``` java
s.length()
s.charAt(0)
s.substring(2)
s.toUpperCase()
s.toLowerCase()
s.contains("Java")
s.equals("Text")
s.compareTo("ABC")
s.trim()
```

### ✔ StringBuilder & StringBuffer

Used when you need **mutable** (changeable) strings.

``` java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
```

-   `StringBuilder` → Fast, not thread-safe\
-   `StringBuffer` → Slow, thread-safe

------------------------------------------------------------------------

# 📌 2. Wrapper Classes

Java primitives → Wrapped into objects using wrapper classes.

  Primitive   Wrapper
  ----------- -----------
  int         Integer
  float       Float
  double      Double
  char        Character
  boolean     Boolean

### ✔ Autoboxing (primitive → object)

``` java
int x = 5;
Integer y = x;   // autoboxing
```

### ✔ Unboxing (object → primitive)

``` java
Integer z = 10;
int k = z;       // unboxing
```

Wrapper classes are used in: - Collections (ArrayList, HashMap) -
Generics - Serialization

------------------------------------------------------------------------

# 📌 3. Exception Handling

Java uses exceptions to handle runtime errors **without stopping the
program**.

### ✔ Types of Exceptions

-   **Checked Exceptions** (must handle)\
-   **Unchecked Exceptions** (runtime errors)

### ✔ try--catch Example

``` java
try {
    int a = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

------------------------------------------------------------------------

### ✔ finally Block

Runs **always**, even if exception occurs.

``` java
finally {
    System.out.println("Always executed");
}
```

------------------------------------------------------------------------

### ✔ throw & throws

``` java
void check(int age) throws Exception {
    if(age < 18) {
        throw new Exception("Not allowed");
    }
}
```

------------------------------------------------------------------------

# 📌 4. File Handling in Java

Use `File`, `FileWriter`, and `Scanner`.

### ✔ Writing to a file

``` java
FileWriter fw = new FileWriter("data.txt");
fw.write("Hello Java");
fw.close();
```

### ✔ Reading from a file

``` java
File file = new File("data.txt");
Scanner sc = new Scanner(file);

while(sc.hasNextLine()) {
    System.out.println(sc.nextLine());
}
sc.close();
```

------------------------------------------------------------------------

# 📌 5. Packages

Packages help organize classes into groups.

### ✔ Creating a package

``` java
package mypackage;
```

### ✔ Importing a package

``` java
import java.util.Scanner;
```

### ✔ Types of packages

-   Built‑in packages (`java.util`, `java.io`)
-   User‑defined packages

------------------------------------------------------------------------

# 📌 6. Java Collections Framework (Intro)

Collections Framework contains prebuilt data structures.

### ✔ Most important collections:

  Type    Interface   Implementation
  ------- ----------- -----------------------
  List    List        ArrayList, LinkedList
  Set     Set         HashSet, TreeSet
  Queue   Queue       PriorityQueue
  Map     Map         HashMap, TreeMap

------------------------------------------------------------------------

## ✔ ArrayList Example

``` java
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.get(0);
```

------------------------------------------------------------------------

## ✔ HashMap Example

``` java
HashMap<String, Integer> map = new HashMap<>();
map.put("Akash", 90);
map.put("John", 80);
```

------------------------------------------------------------------------

# 📌 7. Generics

Generics allow type‑safety in collections.

### ✔ Generic class example

``` java
class Box<T> {
    T value;
    Box(T value) { this.value = value; }
}
```

Usage:

``` java
Box<Integer> b = new Box<>(10);
```

------------------------------------------------------------------------

# 🎯 Part 3 Completed!

You have learned: - Strings & StringBuilder\
- Wrapper Classes\
- Exception Handling\
- File Handling\
- Packages\
- Introduction to Collections\
- Generics

You are now ready for:

👉 **Part 4: Data Structures in Java (with custom implementations)**\
- Stack\
- Queue\
- Linked List\
- Trees\
- Graphs\
- Recursion\
- Time Complexity

------------------------------------------------------------------------

Made with ❤️ for your GitHub Java Learning Series.
