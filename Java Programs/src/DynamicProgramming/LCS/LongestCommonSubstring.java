package DynamicProgramming.LCS;
// revisions = 1

public class LongestCommonSubstring {
    // recursive solution
    // time-complexity - O(3^(m + n))
    // space-complexity - O(m + n)
    public int longestSubstring(String s1, String s2, int n, int m, int count) {
        // base condition
        if (n == 0 || m == 0) {
            return count;
        }

        // if both character's got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            count = longestSubstring(s1, s2, n - 1, m - 1, count + 1);
        }

        // check other possibilities
        int count1 = longestSubstring(s1, s2, n - 1, m, 0);
        int count2 = longestSubstring(s1, s2, n, m - 1, 0);

        return Math.max(count, (Math.max(count1, count2)));

    }

    // memoization
    // time-complexity - O(m * n)
    // space-complexity - O(m * n)
    public int longestSubstring2(String s1, String s2, int n, int m, int[][] dp) {
        // base condition
        if (n == 0 || m == 0) {
            return 0;
        }

        // if already present
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        int res = 0;

        // if both character's got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            res = 1 + longestSubstring2(s1, s2, n - 1, m - 1, dp);
        }

        // check other possibilities
        int count1 = longestSubstring2(s1, s2, n - 1, m, dp);
        int count2 = longestSubstring2(s1, s2, n, m - 1, dp);

        return dp[n][m] = Math.max(res, Math.max(count1, count2));
    }

    // tabulation
    // time-complexity - O(m * n)
    // space-complexity - O(m * n)
    public int longestSubstring3(String s1, String s2, int n, int m) {
        // creating a dp array for storing the values at desired indices
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // track the maximum length which can be stored anywhere
                    // not specifically at dp[n][m]
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0; // whenever consecutiveness breaks
                }
            }
        }

        return maxLen;
    }
}
