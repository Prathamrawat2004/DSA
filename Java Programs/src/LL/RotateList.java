package LL;
// revisions = 1
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

    // brute force approach
    public ListNode rotateRight1(ListNode A, int B) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // storing the elements inside an arraylist
        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = A;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // rotating the list by B times
        Collections.rotate(list, B); 

        // creating a new linked list
        ListNode newHead = new ListNode(list.get(0));
        ListNode current = newHead;
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }

        return newHead;
    }

    // optimized approach
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
