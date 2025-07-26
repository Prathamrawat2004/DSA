package LL;

import java.util.*;
// revisions = 1
public class EvenReverse {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // brute force solution
    public ListNode solve1(ListNode A) {
        // base condition
        if (A == null || A.next == null) {
            return A;
        }

        int count = 1; // for odd and even positions
        ListNode temp = A;

        // creating a dummy even
        ListNode dummyEven = new ListNode(0);
        ListNode dummyOdd = new ListNode(0);

        // seperating the odd & even nodes
        ListNode currentOdd = dummyOdd;
        ListNode currentEven = dummyEven;
        while (temp != null) {
            if (count % 2 == 0) {
                // even node
                currentEven.next = temp;
                currentEven = currentEven.next;
            } else {
                // odd node
                currentOdd.next = temp;
                currentOdd = currentOdd.next;

            }

            temp = temp.next;
            count++;

        }

        // Terminate the two lists
        currentOdd.next = null;
        currentEven.next = null;

        // reversing the even list
        ListNode prev = null;
        ListNode curr = dummyEven.next;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        ListNode reversedEven = prev;

        // merging the nodes
        ListNode tempOdd = dummyOdd.next;
        ListNode tempEven = reversedEven;
        ListNode finalList = new ListNode(0);
        ListNode finalTemp = finalList;
        while (tempOdd != null || tempEven != null) {
            // adding the odd node first
            if (tempOdd != null) {
                finalTemp.next = tempOdd;
                finalTemp = finalTemp.next;
                tempOdd = tempOdd.next;
            }

            // adding the even node
            if (tempEven != null) {
                finalTemp.next = tempEven;
                finalTemp = finalTemp.next;
                tempEven = tempEven.next;
            }

        }

        return finalList.next;

    }

    // optimized solution
    public ListNode solve(ListNode A) {
        // base condition
        if (A == null || A.next == null || A.next.next == null) {
            return A;
        }

        // Step 1: Separate odd and even nodes
        ListNode odd = A;
        ListNode even = A.next;
        ListNode evenHead = even; // we'll reverse this later

        // seperates nodes into even and odd lists automatically as we progress
        // optimization step = inplace
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        // Step 2: Reverse the even-positioned list
        ListNode prev = null;
        ListNode curr = evenHead;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        ListNode reversedEven = prev;

        // Step 3: Merge odd list and reversed even list
        // optimization step = inplace
        odd = A;
        ListNode evenCurr = reversedEven;
        while (evenCurr != null) {
            ListNode tempOddNext = odd.next;
            ListNode tempEvenNext = evenCurr.next;

            odd.next = evenCurr;
            evenCurr.next = tempOddNext;

            odd = tempOddNext;
            evenCurr = tempEvenNext;
        }

        return A;
    }

}
