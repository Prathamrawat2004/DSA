package Hashing;
// revision = 1

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    // brute force solution
    public int longestSubarray(int[] arr, int k) {
        int length = 0;

        for (int i = 0; i < arr.length; i++) {

            int currentSum = 0;

            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum == k) {
                    length = Math.max(length, j - i + 1);
                }

                // as future elements could be negative as well
                // which might reduce sum, hence increasing the length

            }
        }

        return length;
    }

    // optimized approach
    public int longestSubarray2(int[] arr, int k) {
        int maxLength = 0;
        int Sum = 0;

        // creating a hashmap
        HashMap<Integer, Integer> longSum = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Sum += arr[i];

            // Sum becomes equal to k
            if (Sum == k) {
                maxLength = i + 1;
            }

            // if complement found
            if (longSum.containsKey(Sum - k)) {
                maxLength = Math.max(maxLength, i - longSum.get(Sum - k));
            }

            // adding the sum if not before
            if (!longSum.containsKey(Sum)) {
                longSum.put(Sum, i);
            }
        }

        return maxLength;
    }
}
