package LL;

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

    public ListNode partition(ListNode A, int B){
        // base condition
        if(A == null){
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
        while(curr != null){
            if(curr.val < B){
                less.next = curr;
                less = less.next;
            }else{
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
