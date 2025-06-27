package Strings;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        // base condition
        if (A == null || A.size() == 0) {
            return "";
        }

        // size of arraylist
        int n = A.size();

        // assigning the first string as prefix
        String preFix = A.get(0);

        // comparing the current prefix with other strings
        for (int i = 1; i < n; i++) {
            preFix = CommonPrefix(preFix, A.get(i));

            // if the prefix becomes empty
            if (preFix.isEmpty()) {
                return "";
            }

        }

        return preFix;
    }

    // helper function to compare the current prefix
    public String CommonPrefix(String s1, String s2) {
        // getting the minimum length
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;

        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }

        return s1.substring(0, i);
    }
}
