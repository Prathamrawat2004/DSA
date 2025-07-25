package LL;

import java.util.*;
// revisions = 1
public class AddingNums {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // brute force approach
    public ListNode addTwoNumbers1(ListNode A, ListNode B) {
        // creating seperate arrays for both linked lists
        ArrayList<Integer> A1 = new ArrayList<>();
        ArrayList<Integer> B1 = new ArrayList<>();

        // storing the values of list A
        ListNode tempA = A;
        while (tempA != null) {
            A1.add(tempA.val);
            tempA = tempA.next;
        }

        // storing the values of list B
        ListNode tempB = B;
        while (tempB != null) {
            B1.add(tempB.val);
            tempB = tempB.next;
        }

        // adding two arrays
        int i = A1.size() - 1;
        int j = B1.size() - 1;
        int carry = 0;

        ArrayList<Integer> resultant = new ArrayList<>();

        while (i >= 0 || j >= 0 || carry > 0) {
            // starting with carry bit
            int sum = carry;

            // adding the element of A1
            if (i >= 0) {
                sum += A1.get(i);
                i--;
            }

            // adding the element of B1
            if (j >= 0) {
                sum += B1.get(j);
                j--;
            }

            // adding in the resultant array
            resultant.add(sum % 10);

            // updating the carry bit
            carry = sum / 10;

        }

        // creating a dummy node
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : resultant) {
            curr.next = new ListNode(resultant.get(val));
            curr = curr.next;
        }

        return dummy.next;

    }

    // optimized approach
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to build the result list
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }

}
