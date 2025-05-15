package Strings;

import java.util.ArrayList;

public class ValidIP {
    public ArrayList<String> validIP(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // resultant list
        ArrayList<String> result = new ArrayList<>();

        // base condition
        if (A.length() < 4 || A.length() > 12) {
            return result;
        }

        // recursive function
        backTrack(A, 0, "", result, 0);

        return result;
    }

    // helper function definition
    public void backTrack(String s, int index, String current, ArrayList<String> result, int count) {
        // base condition
        if (count == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1)); // ignoring the last dot
            return;
        }

        if (count >= 4 || index >= s.length()) {
            return;
        }

        // trying lengths 1, 2 and 3
        for (int i = 1; i <= 3; i++) {
            if (index + i >= s.length())
                break; // ignore index out of bounds

            String part = s.substring(index, index + i);
            int num = Integer.parseInt(part);

            if (num > 255 || (part.length() > 1 && part.charAt(0) == '0')) {
                continue; // skip
            }

            // recursively add the part
            backTrack(s, index + i, current + part + '.', result, count);

        }
    }
}
