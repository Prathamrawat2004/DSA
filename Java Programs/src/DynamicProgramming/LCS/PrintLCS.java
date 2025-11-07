package DynamicProgramming.LCS;
// revisions = 1

public class PrintLCS {
    // recursive solution
    public String PrintSubsequence(String s1, String s2, int n, int m) {
        // base condition
        if (n == 0 || m == 0) {
            // empty string
            return "";
        }

        // if characters got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return s1.charAt(n - 1) + PrintSubsequence(s1, s2, n - 1, m - 1);
        }

        // we have two choices
        String left = PrintSubsequence(s1, s2, n - 1, m);
        String right = PrintSubsequence(s1, s2, n, m - 1);

        return (left.length() > right.length() ? left : right);
    }

    // memoization
    public String PrintSequence2(String s1, String s2, int n, int m, String[][] dp) {
        // base condition
        if (n == 0 || m == 0) {
            return "";
        }

        // if the value is already present
        if (dp[n][m] != null) {
            return dp[n][m];
        }

        // if the characters got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = s1.charAt(n - 1) + PrintSequence2(s1, s2, n - 1, m - 1, dp);
        }

        // we have two choices
        String left = PrintSequence2(s1, s2, n - 1, m, dp);
        String right = PrintSequence2(s1, s2, n, m - 1, dp);

        return dp[n][m] = (left.length() > right.length() ? left : right);

    }

    // tabulation
    public String PrintSubsequence3(String s1, String s2, int n, int m) {
        // creating a string dp to store the values from start
        String[][] dp = new String[n + 1][m + 1];

        // store base values in the matrice
        for (int i = 0; i <= n; i++) {
            dp[i][0] = "";
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = "";
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = s1.charAt(i - 1) + dp[i - 1][j - 1];
                } else {
                    if (dp[i - 1][j].length() > dp[i][j - 1].length()) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        return dp[n][m];
    }
}
