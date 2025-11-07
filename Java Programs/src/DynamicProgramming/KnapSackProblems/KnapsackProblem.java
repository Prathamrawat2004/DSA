package DynamicProgramming.KnapSackProblems;
// revisions = 1

// 2D dp hence used dp[n + 1]
// 0/1 knapsack problem
public class KnapsackProblem {
    // recursive solution (O(2^n))
    public int knapsack(int[] wt, int[] val, int W, int n) {
        // base condition
        if (n == 0 || W == 0) {
            return 0; // max profit = 0
        }

        // weight of current element is greater than the max weight of knapsack
        if (wt[n - 1] > W) {
            return knapsack(wt, val, W, n - 1);
        }

        // else we have two choices
        int include = val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1);
        int exclude = knapsack(wt, val, W, n - 1);

        return Math.max(include, exclude);

    }

    // memoization (O(n*W))
    // the dp array is of size dp[n + 1][W + 1] in order to store the base cases,
    // another row is considered
    public int knapsack2(int[] wt, int[] val, int W, int n, int[][] dp) {
        // base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        // if the value is already stored inside the dp array
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // weight of current element is greater than the max weight of knapsack
        if (wt[n - 1] > W) {
            return dp[n][W] = knapsack2(wt, val, W, n - 1, dp);
        }

        // we have two choices
        int include = val[n - 1] + knapsack2(wt, val, W - wt[n - 1], n - 1, dp);
        int exclude = knapsack2(wt, val, W, n - 1, dp);

        return dp[n][W] = Math.max(include, exclude);

    }

    // tabulation (O(n*W))
    public static int knapsack3(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // dp[i][j] → max value using first i items with capacity j
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // base values
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

}
