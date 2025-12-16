// CircularQueue
// Circular Queue (k)
//
// Starter Java template. Implement methods as required by the practical.
//
// Compile:
//   javac CircularQueue.java
// Run:
//   java CircularQueue
//
// Author: Akash yadav

class Queue {
    private int front, rear, size;
    private int capacity;
    private int[] queue;

    Queue(int capacity) {
        this.capacity = capacity;
        front = 0;
        size = 0;
        rear = -1;
        queue = new int[capacity];
    }

    // Enqueue operation
    void enqueue(int item) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queue[rear] = item;
        size++;
        System.out.println(item + " inserted");
    }

    // Dequeue operation
    int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front++;
        size--;
        return item;
    }

    // Peek operation
    int peek() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // Display Queue
    void display() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Front: " + q.peek());

        q.display();
    }
}
