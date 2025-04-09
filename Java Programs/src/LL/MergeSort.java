package LL;

import java.util.*;

public class MergeSort {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeSort(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // finding the middle of the linked list
        ListNode fast = A, slow = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextOfMiddle = slow.next;
        slow.next = null; // ending the first list

        // recursively sorting the above two lists
        ListNode left = mergeSort(A);
        ListNode right = mergeSort(nextOfMiddle);

        // merge the two lists
        return merge(left, right);
    }

    // helper function to merge the left and right lists
    public ListNode merge(ListNode left, ListNode right) {
        // base condition
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // resultant list
        ListNode result;

        if (left.val <= right.val) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }
}
