package LL;

public class ReorderList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reorderList(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // finding the midpoint of the list
        ListNode fast = A, slow = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // getting secondhalf reversed
        ListNode reversed = ReverseList(slow.next);
        slow.next = null;

        // merging the list
        ListNode firstHalf = A;
        ListNode secondHalf = reversed;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }

        return A;

    }

    // function to reverse a list
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
