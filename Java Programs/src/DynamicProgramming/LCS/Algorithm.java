package DynamicProgramming.LCS;

public class Algorithm {
    // recursive approach
    public static int lcs(String s1, String s2, int n, int m) {
        // base condition
        if (n == 0 || m == 0) {
            return 0;
        }

        // if character's got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcs(s1, s2, n - 1, m - 1);
        }

        return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }

    // memoization
    public static int lcs2(String s1, String s2, int n, int m, int[][] dp) {
        // base condition
        if (n == 0 || m == 0) {
            return 0;
        }

        // if already present
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // if character's got matched
        if (s1.charAt(n - 1) == s1.charAt(m - 1)) {
            return dp[n][m] = 1 + lcs2(s1, s2, n - 1, m - 1, dp);
        }

        return dp[n][m] = Math.max(lcs2(s1, s2, n - 1, m, dp), lcs2(s1, s2, n, m - 1, dp));
    }

    // tabulation
    public static int lcs3(String s1, String s2, int n, int m) {
        // dp array to store values
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // if character's got matched
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
