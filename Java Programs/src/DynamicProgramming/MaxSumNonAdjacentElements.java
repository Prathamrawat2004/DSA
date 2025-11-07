package DynamicProgramming;

// revisions = 1
public class MaxSumNonAdjacentElements {
    // also known as HOUSE ROBBER problem

    // recursive solution
    public int maxSum(int[] arr, int idx) {
        // Base cases
        if (idx == 0)
            return arr[0]; // only one element
        if (idx < 0)
            return 0; // out of bounds

        // Choice: pick current element or skip it
        int pick = arr[idx] + maxSum(arr, idx - 2); // pick this, skip previous
        int notPick = maxSum(arr, idx - 1); // skip this one

        return Math.max(pick, notPick);
    }

    // memoization
    public static int maxSumMemo(int[] arr, int idx, int[] dp) {
        if (idx == 0)
            return arr[0];
        if (idx < 0)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int pick = arr[idx] + maxSumMemo(arr, idx - 2, dp);
        int notPick = maxSumMemo(arr, idx - 1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    // tabulation
    public static int maxSumTab(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1) pick += dp[i - 2];
            int notPick = dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }
}
