package LL;

public class RemoveDuplicates {
    public static class ListNode {
        public int val;
        public ListNode next;

        // constructor
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode remove(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // declaring pointers
        ListNode dummy = new ListNode(0);
        ListNode temp = A; // pointer for given list
        ListNode NewTemp = dummy; // pointer for new list

        while (temp != null) {
            // skipping the duplicates
            boolean isDuplicate = false;
            while (temp.next != null && temp.val == temp.next.val) {
                isDuplicate = true;
                temp = temp.next;
            }

            // at this point you will be at the last node of duplicate or
            // the node might not be having any duplicates
            if (!isDuplicate) {
                NewTemp.next = temp;
                NewTemp = NewTemp.next;
            }

            // moving to new node
            temp = temp.next;

        }

        // last node pointing to null
        NewTemp.next = null;

        return dummy.next;
    }
}
