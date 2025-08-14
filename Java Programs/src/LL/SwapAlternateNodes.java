package LL;
// revisions = 1
public class SwapAlternateNodes {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode A) {
        // base condition
        if (A.next == null) {
            return A; // only one node
        }
        // declaring pointers
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy, curr = A;

        while (curr != null && curr.next != null) {
            ListNode first = curr;
            ListNode second = curr.next;

            // swapping the nodes
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // moving the pointers
            prev = first;
            curr = first.next;
        }

        return dummy.next;
    }
}
