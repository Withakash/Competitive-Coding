# Java Learning Roadmap -- Part 1

## Core Java Fundamentals (Easy & Beginner-Friendly)

This **README.md** covers **Part 1** of the complete Java learning
series.\
It is written in **simple, beginner-friendly language** and is perfect
for GitHub documentation.

------------------------------------------------------------------------

# 🚀 Part 1: Java Fundamentals

## 📌 1. What is a Class?

A **class** is a blueprint or template used to create objects.\
It contains: - Variables (data) - Methods (behavior)

Example:

``` java
class Car {
    int speed;
    void drive() { }
}
```

------------------------------------------------------------------------

## 📌 2. What is an Object?

An **object** is an instance of a class.\
It represents real-world entities.

Example:

``` java
Car c = new Car();
```

------------------------------------------------------------------------

## 📌 3. Instance Variables

Variables that **belong to each object**.

Example:

``` java
class Student {
    int age;   // instance variable
}
```

Each object gets its **own copy**.

------------------------------------------------------------------------

## 📌 4. Instance Methods

Methods that can only be accessed using an object.

Example:

``` java
Student s = new Student();
s.study();
```

------------------------------------------------------------------------

## 📌 5. What is static?

`static` means the member belongs **to the class**, not to any object.

Static characteristics: - Loaded once in memory - Shared by all
objects - Can be accessed without creating an object

------------------------------------------------------------------------

## 📌 6. Static Variables

Shared between all objects.

``` java
static int count = 0;
```

Only **one copy** exists.

------------------------------------------------------------------------

## 📌 7. Static Methods

Methods that can run without an object.

``` java
static void add() { }
```

------------------------------------------------------------------------

## 📌 8. Why main() is static?

Because Java must run `main()` **before any object is created**.

------------------------------------------------------------------------

## 📌 9. Java Memory Model

Java uses three major memory areas:

  Memory Area   Stores
  ------------- ---------------------------------------------------
  Heap          Objects, instance variables
  Stack         Method calls, local variables
  Method Area   static variables, static methods, class structure

------------------------------------------------------------------------

## 📌 10. Constructors

Special methods used to initialize objects.

``` java
Student() {
    System.out.println("Created");
}
```

Runs automatically when an object is created.

------------------------------------------------------------------------

## 📌 11. this Keyword

Used to refer to the current object.

``` java
this.age = age;
```

------------------------------------------------------------------------

## 📌 12. Access Modifiers

Control visibility of class members.

  Modifier    Meaning
  ----------- ---------------------------
  public      Accessible everywhere
  private     Only inside the class
  protected   Same package + subclasses
  default     Same package

------------------------------------------------------------------------

