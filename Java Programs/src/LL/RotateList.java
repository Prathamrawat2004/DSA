package LL;

import java.util.*;

public class RotateList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode A, int B) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // calculating the length of LL
        int length = getLength(A);

        // effective rotations
        B = B % length;
        if (B == 0) {
            return A;
        }

        // making list circular
        ListNode temp = A;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = A;

        int stepsToNewHead = (length - B);
        ListNode newTail = A;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // break the cycle
        newTail.next = null;

        return newHead;
    }

    // helper function to get length
    public int getLength(ListNode A) {
        int length = 0;
        ListNode temp = A;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

}
