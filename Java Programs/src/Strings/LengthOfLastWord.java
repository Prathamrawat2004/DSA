package Strings;
// revisions = 1
public class LengthOfLastWord {
    public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        int length = 0;
        int current = 0;
        int i = 0;

        while (true) {
            try {
                char c = A.charAt(i);

                if (c == ' ') {
                    // word ended → reset current length
                    current = 0;
                } else {
                    // building a word
                    current++;
                    length = current; // store latest word length
                }

                i++;
            } catch (StringIndexOutOfBoundsException e) {
                // end reached
                break;
            }
        }

        return length;
    }
}

}
