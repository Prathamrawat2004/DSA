package HWI;

import java.util.*;

public class PalindromePartitioning {
    // helper function to check palindrome
    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true; // string is a palindrome
    }

    // recursive solution
    public static int solve(String s, int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (isPalindrome(s, start, end)) {
            return 0; // no cuts required
        }

        int minCuts = Integer.MAX_VALUE;

        for (int k = start; k < end; k++) {
            if (isPalindrome(s, start, k)) {
                int right = solve(s, start + 1, end);
                minCuts = Math.min(minCuts, 1 + right);
            }
        }

        return minCuts;

    }

    // memoization
    public static int solveMemo(String s, int start, int end, int[][] dp) {
        if (start >= end) {
            return 0;
        }

        if (isPalindrome(s, start, end)) {
            return 0; // no cuts required
        }

        // answer already present
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int minCuts = Integer.MAX_VALUE;

        for (int k = start; k < end; k++) {
            if (isPalindrome(s, start, k)) {
                int right = solve(s, start + 1, end);
                minCuts = Math.min(minCuts, 1 + right);
            }
        }

        return dp[start][end] = minCuts;
    }

    // tabulation
    public static int solveTabu(String s, int start, int end) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // solving subproblems
        for (int i = 0; i < n; i++) {
            if (isPalindrome(s, start, i)) {
                dp[i] = 0; // no cuts as already a palindrome
            } else {
                for (int j = 0; j < i; j++) {
                    if (isPalindrome(s, j + 1, i)) {
                        // minimum cuts till j & +1 for this palindrome 
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];

    }

}
