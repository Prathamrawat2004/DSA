package LL;

public class PalindromeCheck {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int isPalindrome(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return 1; // it's a palindrome
        }

        // finding the middle node
        ListNode fast = A, slow = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = Reverse(slow);

        // comparing the two halves
        ListNode firstHalf = A;
        ListNode secondHalf = reversed;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return 0;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;

        }

        return 1; // it's a palindrome

    }

    // helper function to reverse a linked list
    public ListNode Reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev; // pointing to the head of reversed node
    }

}
