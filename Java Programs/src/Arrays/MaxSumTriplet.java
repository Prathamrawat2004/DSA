package Arrays;

import java.util.*;

public class MaxSumTriplet {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int maxSum = 0;

        for (int j = 1; j < n - 1; j++) {
            int maxLeft = 0;
            int maxRight = 0;

            // i < j && A.get(i) < A.get(j)
            for (int i = 0; i < j; i++) {
                if (A.get(i) < A.get(j)) {
                    maxLeft = Math.max(maxLeft, A.get(i));
                }
            }

            // k > j && A.get(k) > A.get(j)
            for (int k = j + 1; k > j; k++) {
                if (A.get(k) > A.get(j)) {
                    maxRight = Math.max(maxRight, A.get(k));
                }
            }

            if (maxLeft > 0 && maxRight > 0) {
                int currentSum = maxLeft + A.get(j) + maxRight;
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;

    }
}
