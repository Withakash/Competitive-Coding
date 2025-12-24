
class Main {
    
    static class MyQueue{
        
        int front,rear,capacity;
        int[] queue;
        
        public MyQueue(int k)
        {
            capacity = k;
            front = 0;
            rear = -1;
            queue = new int[capacity];
        }
        
        
        void enque(int val)
        {
            if(isFull()) 
            {
                System.out.println("Queue Bhara hua Hai");
                return;
            }
            rear = rear + 1;
            queue[rear] = val;
            
            System.out.println("Inserted : " + val);
        }
        
        int deque()
        {
          if(isEmpty()) 
            {
                System.out.println("Queue Khali Hai");
                return -1;
            }
            int item = queue[front];
            front = front + 1;
            System.out.println("Deleted : " + item);
            return item;
        }
        
        int Front()
        {
          if(isEmpty()) 
            {
                System.out.println("Queue Khali Hai");
                return -1;
            }
            return queue[front];
        }
        
        int Rear()
        {
          if(isEmpty()) 
            {
                System.out.println("Queue Khali Hai");
                return -1;
            }
            return queue[rear];
        }
        
        boolean isEmpty()
        {
           return front > rear; 
        }
        
        boolean isFull()
        {
           return rear + 1 == capacity;
        }
    
    }
    
    public static void main(String[] args) {
        
        MyQueue mq = new MyQueue(5);
        
        mq.enque(10);
        mq.enque(20);
        mq.deque();
        System.out.println("Front : " + mq.Front());
        mq.enque(30);
        mq.enque(40);
        System.out.println("Rear : " + mq.Rear());
        mq.enque(50);
        mq.enque(60);
        mq.deque();
        mq.deque();
        mq.deque();
        mq.deque();
        mq.deque();
        
    }
}






//Circular Queue




class Main {
    
    static class CQueue{
        
        int front,rear,capacity,size;
        int[] queue;
        
        public CQueue(int k)
        {
            capacity = k;
            front = 0;
            rear = -1;
            size = 0;
            queue = new int[capacity];
        }
        
        
        void enque(int val)
        {
            if(isFull()) 
            {
                System.out.println("Queue Bhara hua Hai");
                return;
            }
            rear = ( rear + 1 ) % capacity;
            queue[rear] = val;
            size ++;
            
            System.out.println("Inserted : " + val);
        }
        
        int deque()
        {
          if(isEmpty()) 
            {
                System.out.println("Queue Khali Hai");
                return -1;
            }
            int item = queue[front];
            front = (front + 1) % capacity;
            System.out.println("Deleted : " + item);
            size --;
            return item;
        }
        
        int Front()
        {
          if(isEmpty()) 
            {
                System.out.println("Queue Khali Hai");
                return -1;
            }
            return queue[front];
        }
        
        int Rear()
        {
          if(isEmpty()) 
            {
                System.out.println("Queue Khali Hai");
                return -1;
            }
            return queue[rear];
        }
        
        boolean isEmpty()
        {
           return size == 0; 
        }
        
        boolean isFull()
        {
           return size == capacity;
        }
    
    }
    
    public static void main(String[] args) {
        
        CQueue mq = new CQueue(5);
        
        mq.enque(10);
        mq.enque(20);
        mq.deque();
        System.out.println("Front : " + mq.Front());
        mq.enque(30);
        mq.enque(40);
        System.out.println("Rear : " + mq.Rear());
        mq.enque(50);
        mq.enque(60);
        System.out.println("Front : " + mq.Front());
        mq.deque();
        mq.deque();
        mq.deque();
        mq.deque();
        mq.deque();
        
    }
}
