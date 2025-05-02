package Strings;

import java.util.ArrayList;

public class Deserialize {
    public ArrayList<String> deserialize(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // resultant list to return
        ArrayList<String> result = new ArrayList<>();

        // base condition
        if (A.isEmpty()) {
            return result;
        }

        int i = 0;
        while (i < A.length()) {
            int delimitorIndex = A.indexOf('~', i);
            if (delimitorIndex == -1) {
                break; // no delimitors, string is over
            }

            String segment = A.substring(i, delimitorIndex);

            int lengthStartIndex = segment.length() - 1;
            while (lengthStartIndex >= 0 && Character.isDigit(segment.charAt(lengthStartIndex))) {
                lengthStartIndex--;
            }

            String originalString = segment.substring(0, lengthStartIndex + 1);

            // adding the current string to resultant list
            result.add(originalString);

            // moving i to next string search
            i = delimitorIndex + 1;
        }

        return result;
    }
}
