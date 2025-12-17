public class Main {
    static class CircularQueue{
       int front, rear, size;
       int capacity;
       int[] queue;

       CircularQueue(int c)
       {
        capacity = c;
        front = 0;
        rear = -1;
        size = 0;
        queue = new int[capacity];
       }
       
       void enqueue(int item)
       {
           if(isFull())
           {
               System.out.println("Queue is Full");
               return;
           }
           rear =  (rear + 1) % capacity;
           queue[rear] = item;
           size++;
           System.out.println(item +": Inserted");
       }
       
       int dequeue()
       {
           if(isEmpty())
           {
               System.out.println("Queue is Empty");
               return -1;
           }
           
           int item = queue[front];
           front = (front+1) % capacity;
           size--;
           System.out.println(item + ": is Deleted from Queue");
           return queue[front];
       }
       
       int Front()
       {
           if(isEmpty())
           {
               System.out.println("Queue Empty No Front Value");
               return -1;
           }
           return queue[front];
       }
       
       int Rear()
       {
           if(isEmpty())
           {
               System.out.println("Queue Empty No Front Value");
               return -1;
           }
           return queue[rear];
       }
       
       boolean isFull()
       {
           return size == capacity;
       }
       
       boolean isEmpty()
       {
           return size == 0;
       }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.dequeue();
        System.out.println("Front item: " + cq.Front());
        cq.enqueue(40);
        System.out.println("Rear item: " + cq.Rear());
        cq.enqueue(50);
        cq.enqueue(60);
        cq.enqueue(70);
    }
}
