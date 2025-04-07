package LL;

import java.util.*;

public class KReverseLinkedList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode A, int B) {
        // base condition
        if (A == null || A.next == null || B == 0) {
            return A;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode prevGroupEnd = dummy;

        while (prevGroupEnd.next != null) {
            ListNode start = prevGroupEnd.next;
            ListNode end = prevGroupEnd;

            // setting the end
            for (int i = 0; i < B; i++) {
                end = end.next;
                if (end == null){
                    return dummy.next; // not enough nodes
                }
            }

            // storing next element
            ListNode nextGreaterNode = end.next;

            // reversing the sublist
            ListNode prev = null, curr = start;
            while (curr != nextGreaterNode) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            // attaching the reversed lists
            prevGroupEnd.next = end;
            start.next = nextGreaterNode;

            prevGroupEnd = start;
        }

        return dummy.next;
    }
}
