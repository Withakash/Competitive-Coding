# Java Collections Framework -- Complete Guide with Simple Code Examples

This file contains clear explanations and **easy Java code** for every
major part of the Collections Framework. No fluff --- only what you
actually need for interviews and real development.

------------------------------------------------------------------------

# 📌 1. Collection Interface (Root of Collections)

### ✔ What it is

Parent interface for all collections like List, Set, Queue.

### ✔ Key Methods

`add()`, `remove()`, `size()`, `clear()`, `iterator()`

### ✔ Example

``` java
import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);

        System.out.println(nums);
    }
}
```

------------------------------------------------------------------------

# 📌 2. List Interface (Ordered + Allows Duplicates)

## 2.1 ArrayList

-   Dynamic array\
-   Fast access\
-   Slow insert/delete in middle

### Example

``` java
import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.add(1, "X");
        list.remove("B");

        System.out.println(list);
    }
}
```

------------------------------------------------------------------------

## 2.2 LinkedList

-   Doubly linked list\
-   Fast insert/delete\
-   Slower access

### Example

``` java
import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.addFirst(1);
        list.addLast(20);

        list.removeFirst();
        list.removeLast();

        System.out.println(list);
    }
}
```

------------------------------------------------------------------------

## 2.3 Vector

-   Synchronized (slow)\
-   Rarely used today

### Example

``` java
import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(3);

        System.out.println(v);
    }
}
```

------------------------------------------------------------------------

## 2.4 Stack (Legacy)

### Example

``` java
import java.util.*;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);

        st.pop();

        System.out.println(st.peek());
    }
}
```

------------------------------------------------------------------------

# 📌 3. Set Interface (No Duplicates)

## 3.1 HashSet

-   Fastest\
-   No order maintained

### Example

``` java
import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // duplicate ignored

        System.out.println(set);
    }
}
```

------------------------------------------------------------------------

## 3.2 LinkedHashSet

-   Maintains insertion order

### Example

``` java
import java.util.*;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(10);
        lhs.add(20);
        lhs.add(30);

        System.out.println(lhs);
    }
}
```

------------------------------------------------------------------------

## 3.3 TreeSet

-   Sorted set (Ascending order)

### Example

``` java
import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(50);
        ts.add(10);
        ts.add(30);

        System.out.println(ts);
    }
}
```

------------------------------------------------------------------------

# 📌 4. Queue Interface

## 4.1 PriorityQueue

-   Min-heap by default

### Example

``` java
import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println(pq.poll()); // smallest element
    }
}
```

------------------------------------------------------------------------

## 4.2 ArrayDeque (Recommended for Stack/Queue)

### Queue Example

``` java
import java.util.*;

public class ArrayDequeQueueDemo {
    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.println(q.poll());
    }
}
```

### Stack Example

``` java
import java.util.*;

public class ArrayDequeStackDemo {
    public static void main(String[] args) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(10);
        st.push(20);

        System.out.println(st.pop());
    }
}
```

------------------------------------------------------------------------

# 📌 5. Map Interface (Key--Value Data Structure)

## 5.1 HashMap

-   Fastest\
-   No order

### Example

``` java
import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        map.remove(2);

        System.out.println(map);
    }
}
```

------------------------------------------------------------------------

## 5.2 LinkedHashMap

-   Maintains insertion order

### Example

``` java
import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(10, "X");
        map.put(20, "Y");
        map.put(30, "Z");

        System.out.println(map);
    }
}
```

------------------------------------------------------------------------

## 5.3 TreeMap

-   Sorted keys

### Example

``` java
import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(3, "C");
        tm.put(1, "A");
        tm.put(2, "B");

        System.out.println(tm);
    }
}
```

------------------------------------------------------------------------

# 📌 6. Iterator & ListIterator

### Iterator Example

``` java
import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); list.add(20); list.add(30);

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
```

### ListIterator Example

``` java
import java.util.*;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("A"); names.add("B"); names.add("C");

        ListIterator<String> it = names.listIterator();

        while(it.hasNext()) System.out.println(it.next());
        while(it.hasPrevious()) System.out.println(it.previous());
    }
}
```

------------------------------------------------------------------------

# ✔ Final Summary

  Category   Implementations
  ---------- --------------------------------------
  List       ArrayList, LinkedList, Vector, Stack
  Set        HashSet, LinkedHashSet, TreeSet
  Queue      PriorityQueue, ArrayDeque
  Map        HashMap, LinkedHashMap, TreeMap

This file contains everything needed for interviews, exams, and
real-world Java work.
