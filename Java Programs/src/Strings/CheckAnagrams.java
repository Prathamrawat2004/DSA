package Strings;
// revisions = 1
import java.util.Arrays;

public class CheckAnagrams {
    // brute force approach
    public boolean anagramStrings(String s, String t) {
        // removing the leading and trailing spaces
        s = s.trim();
        t = t.trim();

        // base condition
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            boolean found = false;

            for (int j = 0; j < t.length(); j++) {
                if (t.charAt(j) == s.charAt(i)) {
                    found = true;
                }
            }

            // if not found
            if (!found) {
                return false;
            }
        }

        return true;

    }

    // optimized approach
    public boolean anagramStrings2(String s, String t) {
        // removing the leading and trailing spaces
        s = s.trim();
        t = t.trim();

        // base condition
        if (s.length() != t.length()) {
            return false;
        }

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1, t1); // compares both object arrays & primitive arrays
    }
}
