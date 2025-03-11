package Backtrack;

public class ReverseLinkedList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
   

    public ListNode reverseList(ListNode A){
        // base condition
        if(A == null || A.next == null){
            return A;
        }

        // getting new head by recursion
        ListNode newHead = reverseList(A.next);

        // reversing the list after getting the newhead
        A.next.next = A;
        A.next = null;

        // returning the new head to previous calls and reversing further
        return newHead;
    }
}
