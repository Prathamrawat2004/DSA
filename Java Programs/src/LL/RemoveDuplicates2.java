package LL;

import java.util.*;

public class RemoveDuplicates2 {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeDuplicates(ListNode A) {

        // base condition
        if (A == null && A.next == null) {
            return A;
        }

        ListNode current = A;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // this is included in else because there might be a case where the same node
                // occurs
                // more than twice. So, we again need to check from current node and then move
                // current pointer to next node
                current = current.next;
            }
        }

        return A;
    }
}
