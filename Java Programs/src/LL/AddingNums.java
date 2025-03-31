package LL;

import java.util.*;

public class AddingNums {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        // base condition
        if (A == null && B == null) {
            return 0; // nothing to sum up
        }

        // creating a resultant list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // initializing pointers for addition
        int carry = 0, sum = 0;

        // already reversed nodes, no need to reverse
        while (A != null || B != null) {
            // getting the values
            int x = (A != null) ? A.val : 0;
            int y = (B != null) ? B.val : 0;

            // adding them
            sum = x + y + carry;

            // modifying the result list
            current.next = new ListNode(sum % 10);
            current = current.next;

            // modifying carry bit
            carry = sum / 10;

            // updating the values of A and B
            if (A != null) {
                A = A.next;
            }
            if (B != null) {
                B = B.next;
            }
        }

        // if carry still has value
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;

    }
}
