
class Main {
    static class Queue{
        int front,rear,capacity;
        int[] arr;
        
        Queue(int k){
            front = 0;
            rear = -1;
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
            
           rear = rear + 1;
           arr[rear] = val;
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
            front = front + 1;
            System.out.println(item + " : delete hua ");
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
          return rear + 1 == capacity;
        }
        
        boolean isEmpty()
        {
            return front > rear;
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
        
    }
}







