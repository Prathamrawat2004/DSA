package LL;
// revisions = 1
import java.util.ArrayList;

public class NodeFromMiddle {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // brute force approach
    public int solve1(ListNode A, int B) {
        // base condition
        if (A == null || A.next == null) {
            return -1;
        }

        // creating an arraylist to store the node's values
        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = A;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // B greater than middle
        int middlePos = (list.size() / 2) + 1;
        if (B >= middlePos) {
            return -1;
        }

        return list.get((middlePos - B - 1));
    }

    public int solve(ListNode A, int B) {
        // base condition
        if (A == null || A.next == null) {
            return -1;
        }

        // getting the length of given list
        int n = getLength(A);

        // middle node index
        int mid = (n / 2) + 1;

        // resultant index to find
        int resultIndex = mid - B;

        // edge case
        if (resultIndex < 0) {
            return -1;
        }

        ListNode current = A;
        for (int i = 1; i < resultIndex; i++) {
            current = current.next;
        }

        return current.val;

    }

    // function to find length of the list
    public int getLength(ListNode A) {
        ListNode temp = A;
        int count = 0;

        while (temp != null) {
            count += 1;
            temp = temp.next;
        }

        return count;
    }
}
