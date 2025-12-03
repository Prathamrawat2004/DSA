package LL;
// revisions = 2
public class Reverse {
    // definition of singly LL
    public static class ListNode {
        public int val;
        public ListNode next;

        // constructor
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // function to reverse a LL
    public ListNode reverseList(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // declaring the pointers
        ListNode prev = null;
        ListNode curr = A;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // prev would be pointing to new head
        return prev;
    }

    // function to print the list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val + "->");
            head = head.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // creating a reverse class object
        Reverse obj = new Reverse();

        // creating a LL
        ListNode A = new ListNode(1);
        ListNode temp = A;
        for (int i = 2; i < 6; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        System.out.println("Original LinkedList");
        obj.printList(A);

        System.out.println("Reversed LinkedList");
        ListNode reverseHead = obj.reverseList(A);

        obj.printList(reverseHead);

    }
}
