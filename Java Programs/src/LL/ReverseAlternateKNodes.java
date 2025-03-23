package LL;

public class ReverseAlternateKNodes {
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
        if (A == null || A.next == null || B <= 1) {
            return A;
        }

        // intitializing pointers
        ListNode dummy = new ListNode(0);
        ListNode curr = A, prev = dummy;
        int count = 0; // to count B nodes

        while (curr != null) {
            ListNode prevTail = prev;
            ListNode tail = curr;

            // reversing B nodes
            while (curr != null && count < B) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // connecting reversed nodes
            prevTail.next = prev;
            tail.next = curr;

            // moving prev node to tail
            prev = tail;

            // skipping B nodes
            count = 0;
            while (curr != null && count < B) {
                prev = curr;
                curr = curr.next;
                count++;
            }

        }

        // returning head of reversed list
        return dummy.next;
    }
}
