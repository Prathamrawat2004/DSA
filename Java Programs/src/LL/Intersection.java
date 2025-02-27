package LL;

public class Intersection {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        // if either of the list is null
        if (a == null || b == null) {
            return null;
        }

        // getting the lengths of the given lists
        int lenA = getLength(a);
        int lenB = getLength(b);

        // alligning the two lists to same starting point
        if (lenA > lenB) {
            a = moveForwardBy(a, lenA - lenB);
        } else {
            b = moveForwardBy(b, lenB - lenA);
        }

        // finding the intersection
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }

            a = a.next;
            b = b.next;
        }

        // if no intersection is found
        return null;
    }

    // helper function to get length
    public int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    // helper function to move the node to given steps
    public ListNode moveForwardBy(ListNode node, int steps) {
        while (steps > 0 && node != null) {
            node = node.next;
            steps--;
        }
        return node;
    }

}
