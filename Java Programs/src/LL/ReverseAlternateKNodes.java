package LL;
// revisions = 1
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ReverseAlternateKNodes {
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
        if (A == null || A.next == null || B == 1) {
            return A;
        }

        // creating an arraylist to store the linkedlist
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = A;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // reversing the alternate values of list
        for (int i = 0; i < list.size(); i += 2 * B) {

            // as the 'i' can go beyond the size of list
            int endIndex = Math.min(i + B, list.size());

            // reversing the sublist
            // the 'sublist' & 'reverse' all happens inplace
            Collections.reverse(list.subList(i, endIndex));
        }

        // creating a new linkedlist from the modified list
        ListNode newHead = new ListNode(list.get(0));
        ListNode current = newHead;
        for (int j = 1; j < list.size(); j++) {
            current.next = new ListNode(list.get(j));
            current = current.next;
        }

        return newHead;

    }

    // optimized approach
    public ListNode solve(ListNode A, int B) {
        // base condition
        if (A == null || A.next == null || B <= 1) {
            return A;
        }

        // intitializing pointers
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode curr = A, prev = dummy;
        int count = 0; // to count B nodes

        while (curr != null) {
            ListNode prevTail = prev;
            ListNode tail = curr;

            // reversing B nodes
            while (curr != null && count < B) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // connecting reversed nodes
            prevTail.next = prev;
            tail.next = curr;

            // moving prev node to tail
            prev = tail;

            // skipping B nodes
            count = 0;
            while (curr != null && count < B) {
                prev = curr;
                curr = curr.next;
                count++;
            }

        }

        // returning head of reversed list
        return dummy.next;
    }
}
