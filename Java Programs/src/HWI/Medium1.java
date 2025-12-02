package HWI;

import java.util.Arrays;

// expert number
public class Medium1 {
    // recursive solution
    public static int solve(int[] arr, int n) {
        // base condition
        if (n == 0) {
            return 0;
        }

        int maxVal = 0;
        for (int j = 0; j < n; j++) {
            int mex = findMEX(arr, j, n - 1);
            maxVal = Math.max(maxVal, solve(arr, j) + mex);
        }

        return maxVal;
    }

    // helper function to find MEX
    public static int findMEX(int[] arr, int start, int end) {
        // creating a boolean array to check which elements or skills are present
        boolean[] present = new boolean[end - start + 2]; // to be on safer side

        for (int i = start; i <= end; i++) {
            if (arr[i] < present.length) {
                present[arr[i]] = true;
            }
        }

        // checking the values which are absent
        for (int k = 0; k < present.length; k++) {
            if (!present[k]) {
                return k;
            }
        }

        // written just to complete the function as we've used +2 hence the function
        // will never reach here
        return present.length;
    }

    // memoization solution
    public static int solve(int[] arr, int n, int[] dp) {
        // base condition
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int maxVal = 0;
        for (int j = 0; j < n; j++) {
            int mex = findMEX(arr, j, n - 1);
            maxVal = Math.max(maxVal, solve(arr, j) + mex);
        }

        return dp[n] = maxVal;
    }

    // tabulation solution
    public static int maxExpertNumber(int[] A) {
        int n = A.length;

        // it's a length-based problem and not index-based like house robber, knapsack,
        // etc
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        // here, 'i' represents the number of people
        // if n = 4, it means what if we take 4 people
        // here, the value is not limited to indexing only
        for (int i = 1; i <= n; i++) {

            int[] freq = new int[n + 2];
            int mex = 0;

            // creating all subarrays ending at i - 1
            for (int j = i - 1; j >= 0; j--) {
                int val = A[j];

                if (val <= n + 1) {

                    freq[val]++;

                    while (freq[mex] > 0) {
                        mex++;
                    }
                }

                // here, the dp array consists of solution when 'i' number of people are taken

                dp[i] = Math.max(dp[i], dp[j] + mex);
            }
        }

        return dp[n];
    }
}
