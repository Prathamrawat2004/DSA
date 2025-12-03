package LL;
// revisions = 2
import java.util.*;

public class Reverse2 {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        // base condition
        if (A == null || A.next == null || B == C) {
            return A;
        }

        // creating a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = A;

        // starting from dummy node
        ListNode temp = dummy;

        // setting the starting parts
        // moving till (B - 1)th node
        for (int i = 1; i < B; i++) {
            temp = temp.next;
        }

        ListNode low = temp;
        ListNode start = low.next;

        // setting the ending parts
        // moving till Cth node
        temp = start;
        for (int j = B; j < C; j++) {
            temp = temp.next;
        }

        ListNode high = temp.next;

        // reversing the nodes
        ListNode prev = null;
        ListNode curr = start;
        while (curr != high) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // attaching with original lists
        low.next = prev;
        start.next = high;

        return dummy.next;

    }
}
