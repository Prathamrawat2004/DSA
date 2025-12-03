package LL;
// revision = 1
import java.util.*;

public class CycleDetection {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // brute force approach
    // as space complexity = O(n)
    public ListNode detectCycle1(ListNode head){
        // using hashset to store the listnodes
        HashSet<ListNode> uniqueNodes = new HashSet<>();
        ListNode current = head;

        while(current != null){
            // checking if already visited or not
            if(uniqueNodes.contains(current)){
                return current;
            }

            uniqueNodes.add(current);
            current = current.next;

        }

        return null; // no cycle found

    }

    // optimized approach
    // as space complexity = O(1)
    public ListNode detectCycle(ListNode head) {
        // base condition
        if (head == null || head.next == null) {
            return null; // no cycle if nodes <= 1
        }

        // inititializing pointers for detection
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // cycle detected

                // finding the start of cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // start of cycle
            }
        }

        // if no cycle found
        return null;
    }

}
