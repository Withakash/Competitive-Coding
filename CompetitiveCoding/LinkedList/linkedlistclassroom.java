// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class LinkedList {
       Node head;
       static class Node{
           int data;
           Node next;
           
           Node(int val) {
               data = val;
               next = null;
               System.out.println(data+ " : C Created");
           }
       }
       
       
       void print(){
           Node curr = head;
           while(curr!=null) {
           System.out.print(curr.data+ " -> ");
           curr = curr.next;
           }
       }
       
       Node insertAtFirst(int val) {
           Node new_node = new Node(val);
           
           if(head == null) {
               head = new_node;
           }
           else
           {
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

    public static void main(String[] args) {
        
        LinkedList Vb = new LinkedList();
        
        Vb.head = new Node(10);
        Vb.head.next = new Node(20);
        Vb.head.next.next = new Node(30);
        Vb.head.next.next.next = new Node(40);
        Vb.insertAtFirst(5);
        Vb.insertAtFirst(2);
        Vb.insertAtLast(55);
        
        Vb.print();
        System.out.println();
        
        LinkedList dubai = new LinkedList();
        dubai.insertAtLast(111);
        dubai.print();
        
        
    }
}
