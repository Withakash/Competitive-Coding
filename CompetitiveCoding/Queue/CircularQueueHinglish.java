
class Main {
    static class Queue{
        int front,rear,capacity,size;
        int[] arr;
        
        Queue(int k){
            front = 0;
            rear = -1;
            size = 0;
            capacity = k;
            arr = new int[capacity];
            System.out.println("Values are initialized");
        }
        
        void enque(int val)
        {
            if(isFull()) 
            {
                System.out.println("Queue full hain !!");
                return ;
            }
            
           rear = (rear + 1) % capacity;
           
           arr[rear] = val;
           size++;
           System.out.println(val + " : insert hua "+ rear + " par");
        }
        
        int deque()
        {
            if(isEmpty())
            {
                System.out.println("Queue Empty hain !!");
                return -1;
            }
            
            int item = arr[front];
            front = (front + 1) % capacity;
            System.out.println(item + " : delete hua ");
            size--;
            return item;
        }
        
        int Front()
        {
           if(isEmpty())
            {
                System.out.println("Queue Empty hain !!");
                return -1;
            }
            System.out.println(arr[front] + " : Front hai Hamara ");
            return arr[front];
        }
        
        int Rear()
        {
           if(isEmpty())
            {
                System.out.println("Queue Empty hain !!");
                return -1;
            }
            System.out.println(arr[rear] + " : Rear hai Hamara ");
            return arr[rear];
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
        Queue q = new Queue(5);
        q.enque(10);
        q.enque(20);
        q.deque();
        q.Front();
        q.Rear();
        q.enque(30);
        q.enque(40);
        q.enque(50);
        q.enque(60);
        q.enque(70);
        q.deque();
        q.deque();
        q.deque();
        q.deque();
        q.deque();
        q.deque();
    }
}







