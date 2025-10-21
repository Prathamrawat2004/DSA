package DynamicProgramming.UnboundedKnapsack;

// minimum number of coins required to form the given sum
public class CoinChange2 {
    // recursive solution
    public int minCoins(int[] coins, int sum, int n) {
        // base condition
        if (sum == 0)
            return 0; // sum = 0 requires 0 coins
        if (n == 0)
            return Integer.MAX_VALUE - 1; // safe for +1

        // the current coin's value > sum
        if (coins[n - 1] > sum) {
            return minCoins(coins, sum, n - 1); // skip it
        }

        // two choices
        int include = 1 + minCoins(coins, sum - coins[n - 1], n); // unbounded

        int exclude = minCoins(coins, sum, n - 1); // skip coin

        return Math.min(include, exclude);
    }

    // memoization
    public int minCoins2(int[] coins, int sum, int n, int[][] dp) {
        // base condition
        if (sum == 0)
            return 0;
        if (n == 0)
            return Integer.MAX_VALUE - 1; // safe for +1

        if (dp[n][sum] != -1)
            return dp[n][sum];

        // the current coin's value > sum
        if (coins[n - 1] > sum) {
            dp[n][sum] = minCoins2(coins, sum, n - 1, dp);
        } else {
            int include = 1 + minCoins2(coins, sum - coins[n - 1], n, dp);
            int exclude = minCoins2(coins, sum, n - 1, dp);
            dp[n][sum] = Math.min(include, exclude);
        }

        return dp[n][sum];
    }

    // tabulation
    public int minCoins3(int[] coins, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];

        // initialize
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0; // 0 coins for sum 0
        for (int j = 1; j <= sum; j++)
            dp[0][j] = Integer.MAX_VALUE - 1; // safe for +1

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; // skip coin
                } else {
                    int include = 1 + dp[i][j - coins[i - 1]]; // safe now
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.min(include, exclude);
                }
            }
        }

        return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
    }

}
