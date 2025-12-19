
class Main {
    static class CircularQueue{
        private int capacity,front,rear,size;
        int[] queue;
        
        public CircularQueue(int k)
        {
            capacity = k;
            front = 0;
            rear = -1;
            size = 0;
            
            queue = new int[capacity];
        }
        
        void enqueue(int value)
        {
            if(isFull())  
            {
                System.out.println("Sorry, Queue is Full !!");
                return;
            }
            
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            System.out.println(value + ": Inserted");
        }
        
        int dequeue()
        {
            if(isEmpty())
            {
                System.out.println("Sorry, Queue is Empty");
                return -1;
            }
            
            int item = queue[front];
            
            front = (front + 1) % capacity;
            size--;
            System.out.println(item +" : Deleted");
            return item;
        }
        
        int Front()
        {
            if(isEmpty()) return -1;
            return queue[front];
        }
        
        int Rear()
        {
            if(isEmpty()) return -1;
            return queue[rear];
        }
        
        boolean isEmpty()
        {
            return size ==  0;
        }
        boolean isFull()
        {
            return size == capacity;
        }
        
    }
    
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);  // 10 : insterted
        cq.enqueue(20); // 20 : inserted
        cq.enqueue(30); // 30 : inserted
        cq.dequeue();   // 10 : Deleted
        System.out.println("Front item: " + cq.Front()); // 20
        cq.enqueue(40); // 40 : inserted
        System.out.println("Rear item: " + cq.Rear()); // 40
        cq.enqueue(50); // 50 : insterted
        cq.enqueue(60); // 60 : insterted 
        cq.enqueue(70); // Queue is full
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        
    }
}
