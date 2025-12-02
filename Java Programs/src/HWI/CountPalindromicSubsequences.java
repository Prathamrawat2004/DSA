package HWI;

import java.util.*;

public class CountPalindromicSubsequences {
    // recursive solution
    public static int countPS(String s, int i, int j) {
        // removing the leading & trailing spaces
        s = s.trim();

        // base case
        if (i > j) {
            return 0;
        }

        // only one character
        // single character is a palindromic subsequence
        if (i == j) {
            return 1;
        }

        // both characters got matched
        // found one palindromic subsequence
        if (s.charAt(i) == s.charAt(j)) {
            return 1 + countPS(s, i + 1, j) + countPS(s, i, j - 1);
        }

        // removing the reduntant character
        return countPS(s, i + 1, j) + countPS(s, i, j - 1) - countPS(s, i + 1, j - 1);
    }

    // memoization
    public static int countPSMemo(String s, int i, int j, int[][] dp) {
        // removing the leading & trailing spaces
        s = s.trim();

        // base case
        if (i > j) {
            return 0;
        }

        // only one character
        // single character is a palindromic subsequence
        if (i == j) {
            return 1;
        }

        // answer already present
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // both characters got matched
        // found one palindromic subsequence
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 1 + countPS(s, i + 1, j) + countPS(s, i, j - 1);
        }

        // removing the redundant character
        return dp[i][j] = countPS(s, i + 1, j) + countPS(s, i, j - 1) - countPS(s, i + 1, j - 1);
    }

    // tabulation
    public static int countPSTabu(String s) {
        // We use dp[n+1][m+1] in problems where indices represent lengths, not actual
        // string indices.
        // this problem is index-based
        int n = s.length();

        int[][] dp = new int[n][n];

        // setting up base values (length = 1 strings)
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // for length = 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }

            }
        }

        return dp[0][n - 1];

    }
}
