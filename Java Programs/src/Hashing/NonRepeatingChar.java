package Hashing;

import java.util.HashMap;

public class NonRepeatingChar {
    public char nonRepeating(String s) {
        // brute-force solution

        // removing the leading and trailing spaces
        s = s.trim();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }

            // if the count is 1
            if (count == 1) {
                return s.charAt(i);
            }
        }

        return '$';

    }

    // optimized solution
    public static char nonRepeating2(String s) {
        // removing the leading and trailing spaces
        s = s.trim();

        HashMap<Character, Integer> map = new HashMap<>();

        // creating a hashmap to store the frequencies of each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // finding which character has value as 1
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return '$';
    }
}
