package DynamicProgramming.LCS;
// revisions = 1
// Concept: LPS(A) = LCS(A, reverse(A))
// where, 'A' is a String
public class LongestPalindromicSubsequence {
    public static int longestPalindrome(String A) {
        // reversing the given string
        StringBuilder rev = new StringBuilder();

        for (int i = A.length() - 1; i >= 0; i--) {
            rev.append(A.charAt(i));
        }

        // considering this reversed string as String B
        // now implement LCS
        return helperRecursive1(A, rev.toString(), A.length(), rev.toString().length());
    }

    // definition of helper function
    public static int helperRecursive1(String s1, String s2, int n, int m) {
        // base condition
        if (n == 0 || m == 0) {
            return 0;
        }

        // if character's got matched
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + helperRecursive1(s1, s2, n - 1, m - 1);
        }

        return Math.max(helperRecursive1(s1, s2, n - 1, m), helperRecursive1(s1, s2, n, m - 1));
    }
}
