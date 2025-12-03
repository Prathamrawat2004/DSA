package TwoPointer;

import java.util.*;

public class MaxSubarraySumOfKSize {
    public static int maxSumSubarraySizeK(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = 0;

        // add first 'k' elements
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // slide the window
        for (int j = k; j < nums.length; j++) {
            windowSum += nums[j] - nums[j - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
