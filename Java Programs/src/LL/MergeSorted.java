package LL;

public class MergeSorted {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        // base condition
        if ((A == null || B == null) || (A == null) && (B == null)) {
            return A;
        }

        // creating an updated list
        ListNode dummy = new ListNode(0);

        // pointing to first list
        ListNode temp1 = A;

        // pointing to second list
        ListNode temp2 = B;

        ListNode current = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                current.next = temp1;
                temp1 = temp1.next;
            } else {
                current.next = temp2;
                temp2 = temp2.next;
            }
            current = current.next;
        }

        // if list A remains
        if (temp1 != null) {
            current.next = temp1;
        }

        // if list B remains
        if (temp2 != null) {
            current.next = temp2;
        }

        return dummy.next;

    }
}
