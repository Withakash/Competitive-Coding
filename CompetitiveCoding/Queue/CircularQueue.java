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








public class Practical4_CircularQueue {

    static class CircularQueue {
        int[] queue;
        int front, rear, size, capacity;

        // Constructor
        CircularQueue(int k) {
            capacity = k;
            queue = new int[k];
            front = 0;
            rear = -1;
            size = 0;
        }

        // Enqueue operation
        boolean enqueue(int value) {
            if (isFull())
                return false;

            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        }

        // Dequeue operation
        boolean dequeue() {
            if (isEmpty())
                return false;

            front = (front + 1) % capacity;
            size--;
            return true;
        }

        // Get front element
        int Front() {
            if (isEmpty())
                return -1;
            return queue[front];
        }

        // Get rear element
        int Rear() {
            if (isEmpty())
                return -1;
            return queue[rear];
        }

        // Check empty
        boolean isEmpty() {
            return size == 0;
        }

        // Check full
        boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front Element: " + q.Front());

        q.dequeue();
        q.enqueue(40);

        System.out.println("Rear Element: " + q.Rear());
    }
}
