package Hashing;

import java.util.HashSet;

public class DistinctSubstrings {
    // brute-force solution
    public int distinctSubstring(String str) {
        // removing the leading and trailing spaces
        str = str.trim();

        // creating a hashset to store unique strings
        HashSet<String> uniqueSubstrings = new HashSet<>();

        // O(n^3)
        // as substring creates a new string in memory each time taking O(n)
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                uniqueSubstrings.add(str.substring(i, j));
            }
        }

        return uniqueSubstrings.size();

    }

    // optimized approach
    // O(n^2)
    public int distinctSubstring2(String str) {
        // removing the leading and trailing spaces
        str = str.trim();

        // creating a hashset to store unique strings
        HashSet<String> uniqueSubstrings = new HashSet<>();

        // using stringbuilder for contant time operations
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.setLength(0); // clearing the stringbuilder everytime

            for (int j = i; j < str.length(); j++) {
                sb.append(str.charAt(j));
                uniqueSubstrings.add(sb.toString());
            }

        }

        return uniqueSubstrings.size();

    }
}
