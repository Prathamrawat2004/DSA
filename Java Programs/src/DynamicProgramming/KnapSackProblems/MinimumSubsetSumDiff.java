package DynamicProgramming.KnapSackProblems;

public class MinimumSubsetSumDiff {
    // recursive solution
    static int minDiff(int[] arr, int n, int sum1, int sum2) {
        if (n == 0) {
            return Math.abs(sum1 - sum2);
        }

        // Include current element in first subset
        int include = minDiff(arr, n - 1, sum1 + arr[n - 1], sum2);

        // Include in second subset
        int exclude = minDiff(arr, n - 1, sum1, sum2 + arr[n - 1]);

        return Math.min(include, exclude);
    }

    // memoization
    static int[][] dp;

    static int helper(int[] arr, int n, int sum1, int totalSum) {
        if (n == 0)
            return Math.abs((totalSum - sum1) - sum1);

        if (dp[n][sum1] != -1) {
            return dp[n][sum1];
        }

        // Include current element in subset1
        int include = helper(arr, n - 1, sum1 + arr[n - 1], totalSum);
        // Exclude current element
        int exclude = helper(arr, n - 1, sum1, totalSum);

        return dp[n][sum1] = Math.min(include, exclude);
    }

    // tabulation
    public static int minDifference(int[] arr, int n) {
        int sum = 0;
        for (int num : arr)
            sum += num;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Fill the subset-sum table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        // Find the minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[n][s1]) {
                int diff = sum - 2 * s1;
                minDiff = Math.min(minDiff, diff);
            }
        }

        return minDiff;
    }
}
