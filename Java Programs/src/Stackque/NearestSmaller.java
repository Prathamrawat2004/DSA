package Stackque;

import java.util.*;

public class NearestSmaller {
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
