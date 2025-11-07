package DynamicProgramming.LCS;
// revisions = 1

// LPS is inversely proportional to min number of deletions

public class MinDelToPalindrome {
    public int minDeletions(String A){
        // reverse the given string
        StringBuilder rev = new StringBuilder();
        for (int i = A.length() - 1; i >= 0; i--) {
            rev.append(A.charAt(i));
        }

        // find LPS using LCS
        int lps = helperRecursive1(A, rev.toString(), A.length(), rev.length());

        // min deletions = length - lps
        return A.length() - lps;
    }

    // helper function for LCS
    public static int helperRecursive1(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + helperRecursive1(s1, s2, n - 1, m - 1);
        }

        return Math.max(helperRecursive1(s1, s2, n - 1, m), helperRecursive1(s1, s2, n, m - 1));
    }
}
