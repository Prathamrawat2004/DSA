package Strings;

import java.util.HashSet;

public class SelfPermutation {
    public int selfPermuteStrings(String A, String B) {
        // removing the leading and trailing spaces
        A = A.trim();
        B = B.trim();

        // getting the length of each string
        int n = A.length();
        int m = B.length();

        // if the lengths are same, then only check otherwise not
        if (n == m) {
            // creating hashset
            HashSet<Character> set = new HashSet<>();

            // storing the characters of A in the set
            for (int i = 0; i < n; i++) {
                set.add(A.charAt(i));
            }

            // comparing from B
            for (int j = 0; j < m; j++) {
                if (!set.contains(B.charAt(j))) {
                    return 0; // no permutation as different element
                }
            }

            return 1;

        }

        // if lengths are not same
        return 0;
    }
}
