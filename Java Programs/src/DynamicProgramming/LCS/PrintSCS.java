package DynamicProgramming.LCS;

public class PrintSCS {
    // recursive solution
    public static String printSCS(String s1, String s2, int n, int m) {
        // base condition
        if (s1.length() == 0)
            return s2.substring(0, m);
        if (s2.length() == 0)
            return s1.substring(0, n);

        // if both character's got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return s1.charAt(n - 1) + printSCS(s1, s2, n - 1, m - 1);
        }

        // if not matched
        String option1 = s1.charAt(n - 1) + printSCS(s1, s2, n - 1, m);
        String option2 = s2.charAt(m - 1) + printSCS(s1, s2, n, m - 1);

        return (option1.length() < option2.length()) ? option1 : option2;
    }

    // memoization
    public static String printSCS2(String s1, String s2, int n, int m, String[][] dp) {
        // base condition
        if (s1.length() == 0) {
            return s2.substring(0, m);
        }
        if (s2.length() == 0) {
            return s1.substring(0, n);
        }

        // if the result is already present
        if (dp[n][m] != null) {
            return dp[n][m];
        }

        // if both character's got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = s1.charAt(n - 1) + printSCS2(s1, s2, n - 1, m - 1, dp);
        }

        // if not matched
        String option1 = s1.charAt(n - 1) + printSCS2(s1, s2, n - 1, m, dp);
        String option2 = s2.charAt(m - 1) + printSCS2(s1, s2, n, m - 1, dp);

        return dp[n][m] = (option1.length() < option2.length()) ? option1 : option2;
    }

    // tabulation
    public static String printSCS3(String s1, String s2, int n, int m) {
        // creating a dp array to store the strings
        String[][] dp = new String[n + 1][m + 1];

        // base cases
        for (int j = 0; j <= m; j++) {
            dp[0][j] = s2.substring(0, j);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = s1.substring(0, i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = s1.charAt(i - 1) + dp[i - 1][j - 1];
                } else {
                    // if not matched
                    String option1 = s1.charAt(i - 1) + dp[i - 1][j];
                    String option2 = s2.charAt(j - 1) + dp[i][j - 1];

                    dp[i][j] = (option1.length() < option2.length()) ? option1 : option2;
                }
            }
        }

        return dp[n][m];
    }
}
