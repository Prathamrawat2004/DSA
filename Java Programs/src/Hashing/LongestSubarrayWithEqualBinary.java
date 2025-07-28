package Hashing;

import java.util.HashMap;

// https://www.geeksforgeeks.org/dsa/largest-subarray-with-equal-number-of-0s-and-1s/
public class LongestSubarrayWithEqualBinary {
    // brute force solution
    public int maxLen(int[] arr) {
        int n = arr.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int zeroCount = 0;
            int oneCount = 0;

            for (int j = i; j < n; j++) {
                if (arr[j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }

                if (zeroCount == oneCount) {
                    // updating the length
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;

    }

    // optimized solution
    public int maxLen2(int[] arr) {
        int maxLength = 0;

        // hashmap to store prefix sums
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        // converting the zeros to -1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // ending of array
            if (sum == 0) {
                maxLength = i + 1;
            }

            // if at two indices i & j the value is same
            // it means between them the sum = 0
            if (sumMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumMap.get(sum));
            } else {
                sumMap.put(sum, i);
            }

        }

        return maxLength;
    }
}
