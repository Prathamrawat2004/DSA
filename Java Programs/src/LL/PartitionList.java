package LL;

import java.util.ArrayList;
// revisions = 1
public class PartitionList {
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

    // brute force approach
    public ListNode partition1(ListNode A, int B) {
        // base condition
        if (A.next == null) {
            return A;
        }

        // creating lists to store elements greater & smaller than B
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        ListNode temp = A;
        while (temp != null) {
            if (temp.val < B) {
                smaller.add(temp.val);
            } else {
                greater.add(temp.val);
            }
            temp = temp.next;
        }

        // creating LinkedList
        ListNode newHead = new ListNode(smaller.get(0));
        ListNode current = newHead;

        // adding smaller list elements to the modified list first
        for (int i = 1; i < smaller.size(); i++) {
            current.next = new ListNode(smaller.get(i));
            current = current.next;
        }

        // adding elements of greater list
        for (int i = 0; i < greater.size(); i++) {
            current.next = new ListNode(greater.get(i));
            current = current.next;
        }

        return newHead;

    }

    // optimized approach
    public ListNode partition(ListNode A, int B) {
        // base condition
        if (A == null) {
            return A;
        }

        // creating dummy nodes
        ListNode lessHead = new ListNode(0);
        ListNode greatHead = new ListNode(0);
        ListNode curr = A; // pointing to current iteration

        // pointers to respective LL
        ListNode less = lessHead;
        ListNode great = greatHead;

        // traversing the given linked list
        while (curr != null) {
            if (curr.val < B) {
                less.next = curr;
                less = less.next;
            } else {
                great.next = curr;
                great = great.next;
            }
            curr = curr.next;
        }

        // ending the greater list
        great.next = null;

        // joining the two lists
        less.next = greatHead.next;

        return lessHead.next;
    }
}
