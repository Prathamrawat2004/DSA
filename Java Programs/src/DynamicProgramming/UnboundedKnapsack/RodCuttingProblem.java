package DynamicProgramming.UnboundedKnapsack;
// revisions = 1

public class RodCuttingProblem {
    // Recursive version
    public int rodCut(int[] length, int[] price, int N, int n) {
        if (n == 0 || N == 0)
            return 0;

        if (length[n - 1] > N)
            return rodCut(length, price, N, n - 1);

        // include (same n because it's unbounded)
        int include = price[n - 1] + rodCut(length, price, N - length[n - 1], n);
        int exclude = rodCut(length, price, N, n - 1);

        return Math.max(include, exclude);
    }

    // memoization
    public int rodCut2(int[] length, int[] price, int N, int n, int[][] dp) {
        if (n == 0 || N == 0)
            return 0;

        if (dp[n][N] != -1)
            return dp[n][N];

        if (length[n - 1] > N) {
            return dp[n][N] = rodCut2(length, price, N, n - 1, dp);
        }

        int include = price[n - 1] + rodCut2(length, price, N - length[n - 1], n, dp);
        int exclude = rodCut2(length, price, N, n - 1, dp);

        return dp[n][N] = Math.max(include, exclude);
    }

    // tabulation
    public static int rodCut3(int[] length, int[] price, int N, int n) {
        int[][] dp = new int[n + 1][N + 1];

        // dp[i][j] → max price using first i rod pieces to achieve length j
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            price[i - 1] + dp[i][j - length[i - 1]], // include (same i)
                            dp[i - 1][j] // exclude
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][N];
    }
}
