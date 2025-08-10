package LL;
// revisions = 1
import java.util.ArrayList;
import java.util.Collections;

public class MergeSorted {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // brute force approach
    public ListNode mergeTwoLists1(ListNode A, ListNode B) {
        // base conditions
        if (A == null)
            return B;
        if (B == null)
            return A;

        // creating an arraylist
        ArrayList<Integer> sorted = new ArrayList<>();

        ListNode tempA = A;
        while (tempA != null) {
            sorted.add(tempA.val);
            tempA = tempA.next;
        }

        ListNode tempB = B;
        while (tempB != null) {
            sorted.add(tempB.val);
            tempB = tempB.next;
        }

        // sorting the arraylist
        Collections.sort(sorted);


        // rebuilding the linkedlist
        ListNode newHead = new ListNode(sorted.get(0));
        ListNode curr = newHead;
        for (int i = 1; i < sorted.size(); i++) {
            curr.next = new ListNode(sorted.get(i));
            curr = curr.next;
        }

        return newHead;
    }

    // optimized approach
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        // base condition
        if ((A == null || B == null) || (A == null) && (B == null)) {
            return A;
        }

        // creating an updated list
        ListNode dummy = new ListNode(0);

        // pointing to first list
        ListNode temp1 = A;

        // pointing to second list
        ListNode temp2 = B;

        ListNode current = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                current.next = temp1;
                temp1 = temp1.next;
            } else {
                current.next = temp2;
                temp2 = temp2.next;
            }
            current = current.next;
        }

        // if list A remains
        if (temp1 != null) {
            current.next = temp1;
        }

        // if list B remains
        if (temp2 != null) {
            current.next = temp2;
        }

        return dummy.next;

    }
}
