package Strings;

public class IsPalindrome {
    public int isPalindrome(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // replacing all the non-alphanumeric characters from the string
        String result = A.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int n = result.length();

        int i = 0, j = n - 1;

        while (j >= i) {
            if (result.charAt(i) != result.charAt(j)) {
                return 0;
            }
            i++;
            j--;
        }

        return 1;
    }
}
