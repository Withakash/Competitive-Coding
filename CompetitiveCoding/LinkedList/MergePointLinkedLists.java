// MergePointLinkedLists
// Find Merge Point of Two Linked Lists
//
// Starter Java template. Implement methods as required by the practical.
//
// Compile:
//   javac MergePointLinkedLists.java
// Run:
//   java MergePointLinkedLists
//
// Author: Akash Yadav

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
  
    static Node intersectPoint(Node head1, Node head2) {

        // iterate over second list and for each node
        // Search it in first list
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {

                // if both Nodes are same
                if (temp == head2)
                    return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }

        // intersection is not present between the lists
        return null;
    }

    public static void main(String[] args) {

        // creation of first list: 10 -> 15 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        // creation of second list: 3 -> 6 -> 9 -> 15 -> 30
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        // 15 is the intersection point
        head2.next.next.next = head1.next;

        Node intersectionPoint = intersectPoint(head1, head2);

        if (intersectionPoint == null)
            System.out.println("-1");
        else
            System.out.println(intersectionPoint.data);
    }
}
