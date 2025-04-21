package Strings;
public class RemoveConsecutiveChars {
    public String solve(String A, int B) {
        // resultant string
        StringBuilder result = new StringBuilder();

        // removing the leading and trailing spaces
        A = A.trim();

        // pointer for each character
        int i = 0;

        // size of given string
        int n = A.length();
        int count = 0;

        while (i < n) {
            int j = i + 1;
            count = 1;

            while (j < n && A.charAt(i) == A.charAt(j)) {
                count++;
                j++;
            }

            // add to result
            if (count != B) {
                result.append(A.substring(i, j));
            }

            // moving i to next character
            i = j;
        }

        return result.toString();
    }
}
