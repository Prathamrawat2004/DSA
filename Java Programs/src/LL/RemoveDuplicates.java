package LL;

import java.util.ArrayList;
// revisions = 1
public class RemoveDuplicates {
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
    public ListNode remove1(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // creating an arraylist to store the elements of linked list
        ArrayList<Integer> uniqueList = new ArrayList<>();

        // pointer to track the linked list
        ListNode temp = A;
        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {

                int dupVal = temp.val;
                while (temp != null && temp.val == dupVal) {
                    temp = temp.next; // skip all nodes with dupVal
                }

            } else {
                uniqueList.add(temp.val);
                temp = temp.next;
            }

        }

        // if all the nodes have duplicate values
        if (uniqueList.isEmpty())
            return null;

        // creating a new list
        ListNode newHead = new ListNode(uniqueList.get(0));
        ListNode current = newHead;
        for (int i = 1; i < uniqueList.size(); i++) {
            current.next = new ListNode(uniqueList.get(i));
            current = current.next;
        }

        return newHead;
    }

    // optimized approach
    public ListNode remove(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // declaring pointers
        ListNode dummy = new ListNode(0);
        ListNode temp = A; // pointer for given list
        ListNode NewTemp = dummy; // pointer for new list

        while (temp != null) {
            // skipping the duplicates
            boolean isDuplicate = false;
            while (temp.next != null && temp.val == temp.next.val) {
                isDuplicate = true;
                temp = temp.next;
            }

            // at this point you will be at the last node of duplicate or
            // the node might not be having any duplicates
            if (!isDuplicate) {
                NewTemp.next = temp;
                NewTemp = NewTemp.next;
            }

            // moving to new node
            temp = temp.next;

        }

        // last node pointing to null
        NewTemp.next = null;

        return dummy.next;
    }
}
