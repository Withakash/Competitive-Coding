# Java Learning Roadmap -- Part 2

## Object-Oriented Programming (OOP) in Java -- Easy, Detailed & Beginner-Friendly

This **README.md** contains **Part 2** of the Java Learning Series.\
It covers all **OOP concepts** with simple explanations, examples,
diagrams, and use cases.

------------------------------------------------------------------------

# 🚀 Part 2: Object-Oriented Programming (OOP)

Object-Oriented Programming helps structure your code in a **clean**,
**modular**, and **reusable** way.

Java is **100% object-oriented** (except primitive types), so mastering
OOP is necessary.

------------------------------------------------------------------------

# 🎯 **OOP Has 4 Pillars**

1.  **Encapsulation**\
2.  **Inheritance**\
3.  **Polymorphism**\
4.  **Abstraction**

Let's learn each one.

------------------------------------------------------------------------

# 🧱 1. Encapsulation

Encapsulation = **Wrapping data + methods into one unit** (class).\
Also used to **protect data** using `private` variables.

### ✔ Why use it?

-   Security\
-   Data Hiding\
-   Controlled access\
-   Cleaner code

### ✔ Example:

``` java
class Student {
    private int age;         // private → cannot access directly

    public void setAge(int age) {
        this.age = age;      // setter method
    }

    public int getAge() {
        return this.age;     // getter method
    }
}
```

### 📝 Key Points:

-   Make variables **private**
-   Provide **public getters and setters**

------------------------------------------------------------------------

# 🧬 2. Inheritance

Inheritance = Creating a new class from an existing class.

Child class **inherits**: - variables - methods

### ✔ Example:

``` java
class Animal {
    void eat() { System.out.println("Eating..."); }
}

class Dog extends Animal {
    void bark() { System.out.println("Barking..."); }
}
```

Use:

``` java
Dog d = new Dog();
d.eat();   // inherited
d.bark();
```

### 📝 Key Points:

-   Keyword: `extends`
-   Avoid code duplication
-   Enables reusability

------------------------------------------------------------------------

# 🔁 3. Polymorphism

Polymorphism = **one thing, many forms**.

Two types: 1. **Compile-time Polymorphism (Method Overloading)** 2.
**Runtime Polymorphism (Method Overriding)**

------------------------------------------------------------------------

## ✔ 3.1 Method Overloading (Same name, different parameters)

``` java
class MathOp {
    int add(int a, int b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
}
```

------------------------------------------------------------------------

## ✔ 3.2 Method Overriding (Child class changes parent method behavior)

``` java
class Animal {
    void sound(){ System.out.println("Animal sound"); }
}

class Dog extends Animal {
    void sound(){ System.out.println("Bark"); }
}
```

------------------------------------------------------------------------

# 🧩 4. Abstraction

Abstraction = **Hiding internal details** and showing only essential
features.

Two ways to achieve it: - Abstract classes\
- Interfaces

------------------------------------------------------------------------

## ✔ 4.1 Abstract Class Example

``` java
abstract class Shape {
    abstract void draw();   // abstract method
}

class Circle extends Shape {
    void draw() { System.out.println("Drawing circle"); }
}
```

### 📝 Key Points:

-   Cannot create objects of abstract class
-   Must override abstract methods

------------------------------------------------------------------------

## ✔ 4.2 Interface Example

``` java
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() { System.out.println("Bark"); }
}
```

### 📝 Key Points:

-   100% abstraction
-   A class can implement multiple interfaces

------------------------------------------------------------------------

# 🔥 Class Diagram Example (Simple)

              Animal (Parent)
                 |
             extends
                 |
                Dog (Child)

------------------------------------------------------------------------

# 📦 BONUS SECTION

## ✔ Difference Between Abstract Class & Interface

  Feature                Abstract Class           Interface
  ---------------------- ------------------------ ------------------------------
  Methods                Both abstract + normal   Only abstract (until Java 8)
  Multiple Inheritance   Not allowed              Allowed
  Constructors           Allowed                  Not allowed
  Variables              Can be normal            Always final + static

------------------------------------------------------------------------

# 🧠 BONUS: super Keyword

Used to access **parent class**:

✔ super.variable\
✔ super.method()\
✔ super() constructor call

Example:

``` java
class A {
    int x = 10;
}

class B extends A {
    int x = 20;
    void show() {
        System.out.println(super.x); // 10
    }
}
```

------------------------------------------------------------------------

# 🧠 BONUS: final Keyword

  Usage            Meaning
  ---------------- ----------------------
  final variable   value cannot change
  final method     cannot be overridden
  final class      cannot be inherited

------------------------------------------------------------------------

# 🧩 BONUS: Constructors in Inheritance

Child constructor calls parent constructor first:

``` java
class A {
    A() { System.out.println("A"); }
}

class B extends A {
    B() { System.out.println("B"); }
}
```

Output:

    A
    B

------------------------------------------------------------------------

# 🎯 Part 2 Completed!

You now know: - Encapsulation\
- Inheritance\
- Polymorphism\
- Abstraction\
- Abstract classes\
- Interfaces\
- super & final\
- Constructors in inheritance

You are ready for **Part 3: Advanced Java**.

------------------------------------------------------------------------

# 📘 Coming Next

### **Part 3: Java Advanced Concepts**

-   Strings\
-   Wrapper Classes\
-   Exception Handling\
-   File Handling\
-   Packages\
-   Collections Framework\
-   Generics

------------------------------------------------------------------------

Made with ❤️ for your GitHub Java learning series.
