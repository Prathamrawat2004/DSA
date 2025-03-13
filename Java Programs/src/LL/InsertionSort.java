package LL;

public class InsertionSort {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortedInsert(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        // creating a sorted linkedList
        ListNode sorted = null;
        ListNode curr = A;

        // traversing in unsorted list(given input list)
        while (curr != null) {
            ListNode nextNode = curr.next; // storing next node
            sorted = insertionSort(sorted, curr);
            curr = nextNode;
        }

        // head of sorted list
        return sorted;

    }

    public ListNode insertionSort(ListNode sorted, ListNode newNode) {
        // starting from beginning
        if (sorted == null || sorted.val > newNode.val) {
            // checking head
            newNode.next = sorted;
            sorted = newNode;

        } else {
            // if any other val greater than head
            ListNode current = sorted;

            while (current.next != null && current.next.val < newNode.val) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;

        }

        return sorted; // head of sorted list
    }
}
