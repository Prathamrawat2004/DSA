package LL;

import java.util.*;

public class EvenReverse {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // to store values at even positions
        ArrayList<Integer> evenValues = new ArrayList<>();
        int position = 1;
        ListNode curr = A;
        while (curr != null) {
            if (position % 2 == 0) {
                // even position
                evenValues.add(curr.val);
            }
            position++;
            curr = curr.next;
        }

        // size of arraylist
        int n = evenValues.size();

        // reversing the values inside the arraylist
        for (int i = 0; i < n / 2; i++) {
            int temp = evenValues.get(i);
            evenValues.set(i, evenValues.get(n - i - 1));
            evenValues.set(n - i - 1, temp);
        }

        ListNode curr2 = A;
        int position2 = 1;
        int evenIndex = 0;
        while (curr2 != null) {
            if (position2 % 2 == 0) {
                curr2.val = evenValues.get(evenIndex);
                evenIndex++;
            }
            curr2 = curr2.next;
            position2++;
        }

        return A;

    }
}
