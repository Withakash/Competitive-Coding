class Main {

    public static class LinkedList {

        class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        Node head;

        // ================= BASIC =================

        boolean isEmpty() {
            return head == null;
        }

        void print() {
            if (head == null) {
                System.out.println("List Empty");
                return;
            }

            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data);
                if (temp.next != null)
                    System.out.print(" -> ");
                temp = temp.next;
            }
            System.out.println();
        }

        int countNodes() {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        // ================= INSERT =================

        void insertAtFirst(int val) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            System.out.println(val + " : First pr Insert Ho gya");
        }

        void insertAtLast(int val) {
            Node newNode = new Node(val);

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = newNode;
            }
            System.out.println(val + " : Last pr Insert Ho gya");
        }

        void insertAtPosition(int val, int pos) {
            if (pos == 1) {
                insertAtFirst(val);
                return;
            }

            Node temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null) {
                System.out.println("Invalid Position");
                return;
            }

            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println(val + " : Position " + pos + " pr Insert Ho gya");
        }

        // ================= DELETE =================

        int deleteAtFirst() {
            if (head == null) {
                System.out.println("List Empty");
                return -1;
            }

            int val = head.data;
            head = head.next;
            System.out.println(val + " : First se Delete Ho gya");
            return val;
        }

        int deleteAtLast() {
            if (head == null) {
                System.out.println("List Empty");
                return -1;
            }

            if (head.next == null) {
                int val = head.data;
                head = null;
                System.out.println(val + " : Last se Delete Ho gya");
                return val;
            }

            Node temp = head;
            while (temp.next.next != null)
                temp = temp.next;

            int val = temp.next.data;
            temp.next = null;
            System.out.println(val + " : Last se Delete Ho gya");
            return val;
        }

        int deleteAtPosition(int pos) {
            if (pos == 1)
                return deleteAtFirst();

            Node temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null || temp.next == null) {
                System.out.println("Invalid Position");
                return -1;
            }

            int val = temp.next.data;
            temp.next = temp.next.next;
            System.out.println(val + " : Position " + pos + " se Delete Ho gya");
            return val;
        }

        int deleteByValue(int key) {
            if (head == null)
                return -1;

            if (head.data == key)
                return deleteAtFirst();

            Node temp = head;
            while (temp.next != null && temp.next.data != key)
                temp = temp.next;

            if (temp.next == null) {
                System.out.println("Element Not Found");
                return -1;
            }

            int val = temp.next.data;
            temp.next = temp.next.next;
            System.out.println(val + " : Delete Ho gya");
            return val;
        }

        void deleteAfterValue(int key) {
            Node temp = head;
            while (temp != null && temp.data != key)
                temp = temp.next;

            if (temp == null || temp.next == null) {
                System.out.println("Delete Not Possible");
                return;
            }

            System.out.println(temp.next.data + " : Delete After " + key);
            temp.next = temp.next.next;
        }

        void deleteBeforeValue(int key) {
            if (head == null || head.data == key)
                return;

            if (head.next.data == key) {
                deleteAtFirst();
                return;
            }

            Node prev = null;
            Node curr = head;

            while (curr.next != null && curr.next.data != key) {
                prev = curr;
                curr = curr.next;
            }

            if (curr.next == null)
                return;

            prev.next = curr.next;
            System.out.println(curr.data + " : Delete Before " + key);
        }

        void deleteEntireList() {
            head = null;
            System.out.println("Entire List Delete Ho gyi");
        }

        // ================= SEARCH =================

        void search(int key) {
            Node temp = head;
            int pos = 1;

            while (temp != null) {
                if (temp.data == key) {
                    System.out.println(key + " : Found at position " + pos);
                    return;
                }
                temp = temp.next;
                pos++;
            }
            System.out.println(key + " : Not Found");
        }

        // ================= UPDATE =================

        void updateByValue(int oldVal, int newVal) {
            Node temp = head;
            while (temp != null) {
                if (temp.data == oldVal) {
                    temp.data = newVal;
                    System.out.println(oldVal + " Updated to " + newVal);
                    return;
                }
                temp = temp.next;
            }
        }

        void updateAtPosition(int pos, int newVal) {
            Node temp = head;
            for (int i = 1; i < pos && temp != null; i++)
                temp = temp.next;

            if (temp == null)
                return;

            temp.data = newVal;
            System.out.println("Position " + pos + " Updated");
        }

        // ================= ADVANCED =================

        void reverse() {
            Node prev = null, curr = head, next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
            System.out.println("List Reverse Ho gyi");
        }

        void findMiddle() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println("Middle Element : " + slow.data);
        }

        int nthFromEnd(int n) {
            Node fast = head, slow = head;
            for (int i = 0; i < n; i++)
                fast = fast.next;

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }

        // ================= LOOP =================

        boolean detectLoop() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)
                    return true;
            }
            return false;
        }

        // ================= SORT =================

        void sort() {
            for (Node i = head; i != null; i = i.next) {
                for (Node j = i.next; j != null; j = j.next) {
                    if (i.data > j.data) {
                        int t = i.data;
                        i.data = j.data;
                        j.data = t;
                    }
                }
            }
            System.out.println("List Sort Ho gyi");
        }

        // ================= DUPLICATE =================

        void removeDuplicates() {
            Node curr = head;
            while (curr != null && curr.next != null) {
                if (curr.data == curr.next.data)
                    curr.next = curr.next.next;
                else
                    curr = curr.next;
            }
        }
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.insertAtLast(10);
        ll.insertAtLast(20);
        ll.insertAtLast(30);
        ll.insertAtLast(40);

        ll.print();
        ll.reverse();
        ll.print();
        ll.findMiddle();
        ll.search(20);
    }
}
