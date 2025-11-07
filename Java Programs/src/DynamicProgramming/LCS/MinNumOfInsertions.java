package DynamicProgramming.LCS;
// revisions = 1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// minimum number of insertions to convert from string A to string B
public class MinNumOfInsertions {
    // recursive solution
    public static List<Integer> minInsertions(String A, String B){
        int lcsLenth = helperRecursive(A, B, A.length(), B.length());
        int deletions = A.length() - lcsLenth;
        int insertions = B.length() - lcsLenth;

        // list to store insetions and deletions
        List<Integer> resultant = Arrays.asList(insertions, deletions);
        return resultant;
    }
    // definition of helper function
    public static int helperRecursive(String s1, String s2, int n, int m){
        // base condition
        if (n == 0 || m == 0) {
            return 0;
        }

        // if character's got matched
        if (s1.charAt(n - 1) == s2.charAt(n - 1)) {
            return 1 + helperRecursive(s1, s2, n - 1, m - 1);
        }

        return Math.max(helperRecursive(s1, s2, n - 1, m), helperRecursive(s1, s2, n, m - 1));
    }

    // similarly write for memoization and tabulation for LCS 
    // else the above part is same for all
}
