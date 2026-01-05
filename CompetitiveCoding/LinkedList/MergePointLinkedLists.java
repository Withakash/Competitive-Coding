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

static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

    SinglyLinkedListNode a = head1;
    SinglyLinkedListNode b = head2;

    // keep moving until both pointers meet
    while (a != b) {

        if (a == null)
            a = head2;
        else
            a = a.next;

        if (b == null)
            b = head1;
        else
            b = b.next;
    }

    // a (or b) is the merge point
    return a.data;
}
