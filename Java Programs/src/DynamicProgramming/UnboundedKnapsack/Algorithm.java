package DynamicProgramming.UnboundedKnapsack;

// if the current element is not taken -> the element is processed
// if the current element is taken -> the element is not processed
public class Algorithm {
    // recursive solution
    public int UnboundedKnapsack(int[] wt, int[] val, int W, int n) {
        // base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        // if current weight is more than allowed capacity, skip it
        if (wt[n - 1] > W) {
            return UnboundedKnapsack(wt, val, W, n - 1);
        }

        // we have two choices:
        // include -> since unbounded, we stay on the same item (n)
        // exclude -> move to previous item
        int include = val[n - 1] + UnboundedKnapsack(wt, val, W - wt[n - 1], n);
        int exclude = UnboundedKnapsack(wt, val, W, n - 1);

        return Math.max(include, exclude);
    }

    // memoization
    public int UnboundedKnapsack2(int[] wt, int[] val, int W, int n, int[][] dp) {
        // base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] > W) {
            return dp[n][W] = UnboundedKnapsack2(wt, val, W, n - 1, dp);
        }

        // include -> stay on same index since repetition allowed
        int include = val[n - 1] + UnboundedKnapsack2(wt, val, W - wt[n - 1], n, dp);
        int exclude = UnboundedKnapsack2(wt, val, W, n - 1, dp);

        return dp[n][W] = Math.max(include, exclude);
    }

    // tabulation
    public static int UnboundedKnapsack3(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // dp[i][j] → max value using first i items with capacity j
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // base values
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}
