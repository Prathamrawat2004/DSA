package LL;

import java.util.*;
// revisions = 1
public class KReverseLinkedList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // brute force approach
    public ListNode solve1(ListNode A, int B) {
        // base condition
        if (A == null || A.next == null || B == 0 || B == 1) {
            return A;
        }

        // storing elements in an arraylist
        ArrayList<Integer> values = new ArrayList<>();
        ListNode temp = A;
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        // reversing values inside the list
        for (int i = 0; i < values.size(); i += B) {
            int left = i;
            int right = (i + B - 1);

            while (left < right) {
                // swapping the elements
                int temper = values.get(left);
                values.set(left, values.get(right));
                values.set(right, temper);

                left++;
                right--;
            }
        }

        // rebuilding the linked list
        ListNode newHead = new ListNode(values.get(0));
        ListNode curr = newHead;

        for (int i = 1; i < values.size(); i++) {
            curr.next = new ListNode(values.get(i));
            curr = curr.next;
        }

        return newHead;

    }

    // optimized approach
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
                if (end == null) {
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
