package Stackque;

import java.util.*;

public class NearSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        // size of given list
        int n = A.size();

        // resultant arrayList
        ArrayList<Integer> G = new ArrayList<>(Collections.nCopies(n, -1));

        // base condition
        if (n == 0) {
            return G;
        }

        // stack to maintain the previous elements
        Stack<Integer> stack = new Stack<>();

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
