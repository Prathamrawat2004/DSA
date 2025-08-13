package LL;

import java.util.*;
// revisions = 1
public class RemoveDuplicates2 {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // brute force approach
    public ListNode removeDuplicates1(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // creating a hashset to store the values only once
        HashSet<Integer> uniqueSet = new HashSet<>();

        // arraylist to store unique values
        ArrayList<Integer> uniqueList = new ArrayList<>();

        // pointer to traverse the linkedlist
        ListNode current = A;

        while (current != null) {
            if (!uniqueSet.contains(current.val)) {
                uniqueList.add(current.val);
            }
            uniqueSet.add(current.val);
            current = current.next;
        }

        // creating a new list
        ListNode newHead = new ListNode(uniqueList.get(0));
        ListNode newTemp = newHead;
        for (int i = 1; i < uniqueList.size(); i++) {
            newTemp.next = new ListNode(uniqueList.get(i));
            newTemp = newTemp.next;
        }

        return newHead;
    }

    // optimized approach
    public ListNode removeDuplicates(ListNode A) {

        // base condition
        if (A == null && A.next == null) {
            return A;
        }

        ListNode current = A;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // this is included in else because there might be a case where the same node
                // occurs
                // more than twice. So, we again need to check from current node and then move
                // current pointer to next node
                current = current.next;
            }
        }

        return A;
    }
}
