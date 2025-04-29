package Strings;

public class LengthOfLastWord {
    public int lengthOfLastWord(final String A) {
        int length = 0;
        int i = 0;

        // calculating the length manually
        while (true) {
            try {

                // accessing the character at index i
                char ch = A.charAt(i);
                i++;

            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }

        // i contains the actual length of string
        // setting it to last valid index
        i--;

        // ignoring the empty spaces
        while (i >= 0 && A.charAt(i) == ' ') {
            i--;
        }

        // calculating the actual length
        while (i >= 0 && A.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
