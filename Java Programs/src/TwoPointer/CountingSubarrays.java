package TwoPointer;

import java.util.*;

public class CountingSubarrays {
    public int solve(ArrayList<Integer> A, int B) {
        // base condition
        if (A == null || A.size() == 0 || B == 0) {
            return 0; // non-negative integer
        }

        // counting the number of subarrays
        int count = 0;

        // for counting the current sum
        int currentSum = 0;

        // sliding window approach
        int left = 0;
        for (int right = 0; right < A.size(); right++) {
            currentSum += A.get(right);

            while (currentSum >= B && left <= right) {
                currentSum -= A.get(left);
                left++;
            }

            count += (right - left) + 1;
        }

        return count;
    }
}
