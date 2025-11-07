package DynamicProgramming.LCS;
// revisions = 1
public class SequencePatternMatching {
    // recursive solution
    public static boolean isSubsequence(String s1, String s2, int n, int m) {
        // base condition
        if (n == 0) {
            return true;
        }

        if (m == 0) {
            return false;
        }

        // if both character's got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return isSubsequence(s1, s2, n - 1, m - 1);
        }

        // decrease the string s2 in length to check other characters
        return isSubsequence(s1, s2, n, m - 1);

    }

    // memoization
    public static boolean isSubsequence2(String s1, String s2, int n, int m, Boolean[][] dp) {
        // base condition
        if (n == 0) {
            return true;
        }

        if (m == 0) {
            return false;
        }

        // if the result is already present
        if (dp[n][m] != null) {
            return dp[n][m];
        }

        // if both character's got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = isSubsequence(s1, s2, n - 1, m - 1);
        }

        return dp[n][m] = isSubsequence(s1, s2, n, m - 1);
    }

    // tabulation
    public static boolean isSubsequence3(String s1, String s2, int n, int m) {
        // creating a dp array to store the strings
        Boolean[][] dp = new Boolean[n + 1][m + 1];

        // initializing base values
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // if both character's got matched
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[n][m];
    }
}
