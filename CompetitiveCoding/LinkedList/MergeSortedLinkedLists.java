// MergeSortedLinkedLists
// Merge Two Sorted Linked Lists
//
// Starter Java template. Implement methods as required by the practical.
//
// Compile:
//   javac MergeSortedLinkedLists.java
// Run:
//   java MergeSortedLinkedLists
//
// Author: Akash Yadav

public class MergeSortedLinkedLists {

class Main {

    // ================= NODE CLASS =================
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ================= MERGE FUNCTION =================
    static ListNode merge(ListNode list1, ListNode list2) {

        // Dummy node (temporary head)
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return merged list head
        return dummy.next;
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        // First Sorted Linked List
        ListNode a = new ListNode(1);
        a.next = new ListNode(3);
        a.next.next = new ListNode(5);

        // Second Sorted Linked List
        ListNode b = new ListNode(2);
        b.next = new ListNode(4);
        b.next.next = new ListNode(6);

        // Merge both lists
        ListNode merged = merge(a, b);

        // Print merged list
        System.out.print("Merged Sorted List: ");
        while (merged != null) {
            System.out.print(merged.data + " ");
            merged = merged.next;
        }
    }
}

}
