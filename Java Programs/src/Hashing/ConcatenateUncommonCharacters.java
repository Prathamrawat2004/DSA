package Hashing;

import java.util.HashSet;
import java.util.*;

public class ConcatenateUncommonCharacters {
    // brute force approach
    public String concatenatedString(String s1, String s2) {
        // removing the leading and trailing spaces
        s1 = s1.trim();
        s2 = s2.trim();

        // getting the lengths of both the strings
        int l1 = s1.length();
        int l2 = s2.length();

        // resultant string
        StringBuilder sb = new StringBuilder();

        // comparing and appending uncommon characters
        for (int i = 0; i < l1; i++) {

            boolean common = false; // flag to check if the character is common(or not)

            for (int j = 0; j < l2; j++) {
                if (s1.charAt(i) == (s2.charAt(j))) {
                    common = true;
                    break;
                }
            }

            if (!common) {
                sb.append(s1.charAt(i));
            }

        }

        return sb.toString();
    }

    // optimized approach 1
    public String concatenatedString2(String s1, String s2) {
        // removing the leading and trailing spaces
        s1 = s1.trim();
        s2 = s2.trim();

        // creating a hashset to store any one string
        HashSet<Character> set = new HashSet<>();

        // resultant string
        StringBuilder sb = new StringBuilder();

        for (char c : s1.toCharArray()) {
            set.add(c);
        }

        // adding the characters to resultant string which are not common
        for (char c : s2.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
            } else {
                set.remove(c);
            }
        }

        // adding the remaining elements from set
        for (char c : set) {
            sb.append(c);
        }

        return sb.toString();

    }

    // optimized approach 2
    public String concatenatedString3(String s1, String s2) {
        // removing the leading and trailing spaces
        s1 = s1.trim();
        s2 = s2.trim();

        // creating a hashmap to store frequencies
        HashMap<Character, Integer> map = new HashMap<>();

        // resultant string
        StringBuilder sb = new StringBuilder();

        // storing the first string characters along with their frequencies
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // comparing the characters of another string
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                sb.append(c);
            } else {
                map.remove(c);
            }
        }

        // adding the remaining characters from the map
        // traversing the whole map
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            // taking the character
            char c = entry.getKey();

            // taking the frequency
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
