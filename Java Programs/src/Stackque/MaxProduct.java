package Stackque;
// revisions = 1
import java.util.*;

public class MaxProduct {
    // brute force approach
    public int maxSpecialProduct1(ArrayList<Integer> A) {
        // getting the size of array
        int n = A.size();

        long mod = 10000007;

        // base condition
        if (n < 3) {
            return 0;
        }

        // creating left & right special arrays
        ArrayList<Integer> leftSpecial = new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> rightSpecial = new ArrayList<>(Collections.nCopies(n, 0));

        long maxProduct = 0;

        // storing left special values
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(j) > A.get(i)) {
                    leftSpecial.set(i, A.get(j));
                    break;
                }
            }

        }

        // storing right special values
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.get(j) > A.get(i)) {
                    rightSpecial.set(i, A.get(j));
                    break;
                }
            }

        }

        // finding the max product
        for (int k = 1; k < n - 1; k++) {
            long result = (long) (leftSpecial.get(k) * rightSpecial.get(k));
            maxProduct = Math.max(maxProduct, result);
        }

        return (int) (maxProduct % mod);

    }

    // optimized approach
    public int maxSpecialProduct(ArrayList<Integer> A) {
        int n = A.size();
        long mod = 1000000007;

        // base condition
        if (n < 3) {
            return 0; // min length should be 3
        }

        ArrayList<Integer> leftSpecial = new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> rightSpecial = new ArrayList<>(Collections.nCopies(n, 0));

        Stack<Integer> stack = new Stack<>();

        // finding the left special values
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                leftSpecial.set(i, stack.peek());
            }

            stack.push(i);
        }

        // clearing the stack for right special
        stack.clear();

        // finding the right special values
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                leftSpecial.set(i, stack.peek());
            }

            stack.push(i);
        }

        // finding the maxproduct
        long maxproduct = 0;
        for (int i = 0; i < n; i++) {
            long product = (long) leftSpecial.get(i) * rightSpecial.get(i);
            maxproduct = Math.max(maxproduct, product);
        }

        return (int) (maxproduct % mod);

    }
}
