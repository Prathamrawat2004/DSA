package LL;

public class SortBinary {
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

    public ListNode sortBinary(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // pointers to count the number of 0's & 1's
        int count0 = 0, count1 = 0;
        ListNode curr = A;

        while (curr != null) {
            if (curr.val == 0) {
                count0++;
            } else {
                count1++;
            }
        }

        curr = A; // resetting the current node to head

        // adding 0's
        while(count0 > 0){
            curr.val = 0;
            curr = curr.next;
            count0--;
        }

        // adding 1's
        while(count1 > 0){
            curr.val = 0;
            curr = curr.next;
            count1--;
        }


        return A;
    }
}
