package TwoPointer;

import java.util.*;

public class Array3Pointers {
    public int minMax(final ArrayList<Integer> A, final ArrayList<Integer> B, final ArrayList<Integer> C) {
        // base condition
        if (A.isEmpty() || B.isEmpty() || C.isEmpty()) {
            // if either of i, j or k is not applicable
            return 0;
        }

        // initializing pointers
        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE; // for managing the min value at every iteration

        // traverse till either of i, j or k gets exhausted
        while (i < A.size() && j < B.size() && k < C.size()) {
            // getting the values of each pointer
            int a = A.get(i), b = B.get(j), c = C.get(k);

            // finding the expression value
            int currentMax = Math.max(Math.abs(a - b), Math.max(Math.abs(b - c), Math.abs(c - a)));

            // updating the minimum value
            minDiff = Math.min(minDiff, currentMax);

            // incrementing pointer with smallest element for optimum number of iterations
            if (a == Math.min(a, Math.min(b, c))) {
                i++;
            } else if (b == Math.min(b, Math.min(c, a))) {
                j++;
            } else {
                k++;
            }
        }

        return minDiff;

    }
}
