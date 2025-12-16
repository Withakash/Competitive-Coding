
public class Main {

static class Queue {

    private int front, rear;
    private int capacity;
    private int[] queue;

    Queue(int c) {
        capacity = c;
        front = 0;
        rear = -1;
        queue = new int[capacity];
    }

    // Enqueue operation
    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queue[rear] = item;
        System.out.println(item + " inserted");
    }

    // Dequeue operation
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front++;
        return item;
    }

    // Peek operation
    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    boolean isEmpty() {
        return front > rear;
    }

    // Display Queue
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

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
