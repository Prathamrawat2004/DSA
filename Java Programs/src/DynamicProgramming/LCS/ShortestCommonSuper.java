package DynamicProgramming.LCS;

// revisions = 1
public class ShortestCommonSuper {
    // recursive solution
    public static int scs(String X, String Y, int n, int m) {
        // base conditions
        if (n == 0)
            return m; // empty string is a subsequence of every string
        if (m == 0)
            return n; // empty string is a subsequence of every string

        // if character's got matched
        if (X.charAt(n - 1) == Y.charAt(m - 1)) {
            return 1 + scs(X, Y, n - 1, m - 1); // only adding common characters once
        }

        // else include either the last character of X or Y
        return 1 + Math.min(scs(X, Y, n - 1, m), scs(X, Y, n, m - 1));
    }

    // memoization
    public static int scs2(String X, String Y, int n, int m, int[][] dp) {
        // base condition
        if (n == 0)
            return m;
        if (m == 0)
            return n;

        // if the value is already present
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // if character's got matched
        if (X.charAt(n - 1) == Y.charAt(m - 1)) {
            dp[n][m] = 1 + scs(X, Y, n - 1, m - 1);
        }

        return dp[n][m] = 1 + Math.min(scs(X, Y, n - 1, m), scs(X, Y, n, m - 1));
    }

    // tabulation
    public static int scs3(String X, String Y, int n, int m) {
        // dp array to store the values at every index
        int[][] dp = new int[n + 1][m + 1];

        // base values
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // filling the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
