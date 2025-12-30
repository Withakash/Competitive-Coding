
class LinkedList {
    
    Node head  = null;
    
    static class Node{
        int data ;
        Node next;
        
        Node(int val)
        {
            data = val;
            next = null;
            System.out.println(data  + " : Constructor created");
        }
    }
    
    Node insertAtFirst(int val) {
        Node new_node = new Node(val);
        if(head == null) {
            head = new_node;
        }
        else {
            new_node.next = head;
            head = new_node;
        }
        return head;
    }
    
    Node insertAtLast(int val) {
        Node new_node = new Node(val);
        if(head == null) {
            head = new_node;
        }
        else {
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = new_node;
        }
        return head;
    }
    
    void print() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
      Node n1 = new Node(10);
      Node n2 = new Node(20);
      Node n3 = new Node(30);
      ll.head = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = new Node(40);
      ll.print();
      ll.insertAtFirst(5);
      ll.insertAtLast(77);
      ll.print();
      
      
    }
}
