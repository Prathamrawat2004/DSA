package Stackque;

import java.util.*;
// revisions = 1
public class NearestSmaller {
    // brute force approach
    public ArrayList<Integer> prevSmaller1(ArrayList<Integer> A) {
        // resultant arraylist
        ArrayList<Integer> resultant = new ArrayList<>(Collections.nCopies(A.size(), -1));

        for (int i = 1; i < A.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(j) < A.get(i)) {
                    resultant.set(i, A.get(j));
                    break; // as we got the rightmost one
                }
            }
        }

        return resultant;

    }

    // optimized approach
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        // getting the size of the array
        int n = A.size();

        // resultant arraylist
        ArrayList<Integer> G = new ArrayList<>(Collections.nCopies(n, -1));

        Stack<Integer> stack = new Stack<>();

        // traversing the arraylist
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                G.set(i, A.get(stack.peek()));
            }

            stack.push(i);
        }

        return G;
    }
}
