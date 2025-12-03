package LL;
// revisions = 2
public class RemoveNthNodeFromEnd {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // optimized approach
    public ListNode RemoveNthNode(ListNode A, int B) {
        // base condition
        if (A == null || B == 0) {
            return A;
        }

        // length of given list
        int length = getLength(A);

        // if B is greater than length
        if (B >= length) {
            return A.next; // first node
        }

        // distance from front
        int target = length - B;

        // traversing just before the target node
        ListNode temp = A;
        for (int i = 1; i < target; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return A;
    }

    // helper function to get length
    public int getLength(ListNode A) {
        ListNode temp = A;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
