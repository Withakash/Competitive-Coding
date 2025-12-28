
class Main {
public static class LinkedList {

    public class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    Node insertAtLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println(val + " : Last pr Insert Ho gya");
        return head;
    }
    
    void insertAtFirst(int val)
    {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
        }
        else {
            Node temp = head;
            newNode.next = temp;
            head = newNode;
        }
        System.out.println(val + " : First pr Insert Ho gya ");
    }
    
    int deleteAtFirst()
    {
        if(head == null)
        {
            System.out.println("No elements to delete");
            return -1;
        }
        Node temp = head;
        head =  head.next;
        System.out.println(temp.data + " : First se delete Ho gya hai ");
        return temp.data;
    }
    
    int deleteAtLast()
    {
        Node temp = head;
        if(head == null)
        {
            System.out.println("No elements to delete");
            return -1;
        }      
        
       if (head.next == null) {
          head = null;
          System.out.println(temp.data + " : Last se delete Ho gya hai ");
          return temp.data;
       }
        
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        System.out.println(val + " : Last se delete Ho gya hai ");
        return val;
        
    }
    
    void reverse(){
        if(head == null || head.next == null)
        {
            System.out.println("Already Reversed bcs 1 or 0 Element is there ");
        }
        else{
            Node prev = null , curr = head , next;
            
            while(curr != null)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
            System.out.println("Reverse done");
        }
        
    }
    

    void print()
    {
        Node temp = head;
        while(temp != null)
        {
          System.out.print(" " + temp.data);
                      if (temp.next != null) {
                System.out.print(" -> ");
            }
          temp = temp.next;
        }
        System.out.println();
    }
}

    public static LinkedList merge(LinkedList list1,LinkedList list2)
    {
        LinkedList.Node l1 = list1.head;
        LinkedList.Node l2 = list2.head;
        if(l1 == null) return list2;
        if(l2 == null) return list1;
        
        LinkedList res = new LinkedList();
        
        while(l2 != null && l1 != null)
        {
            if(l2.data >= l1.data) {
              res.insertAtLast(l1.data);
              l1 = l1.next;
            }
            else {
              res.insertAtLast(l2.data);
              l2 = l2.next;
            } 
        }
        while(l2 != null) {
            res.insertAtLast(l2.data);
            l2 = l2.next;
        }
        while(l1 != null) {
            res.insertAtLast(l1.data);
            l1 = l1.next;
        }
        
        return res;
    }

    public static void main(String[] args) {
        
        LinkedList l1 = new LinkedList();
        l1.insertAtLast(10);
        l1.insertAtLast(20);
        l1.insertAtLast(30);
        l1.insertAtLast(40);
        l1.insertAtLast(50);
        l1.print();
        System.out.println();
        
        LinkedList l2 = new LinkedList();
        l2.insertAtLast(100);
        l2.insertAtLast(200);
        l2.insertAtLast(300);
        l2.insertAtLast(400);
        l2.insertAtLast(500);
        l2.print();
        
        LinkedList res = merge(l1,l2);
        res.print();

    }
}
