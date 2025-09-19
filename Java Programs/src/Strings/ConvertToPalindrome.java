package Strings;
// revisions = 1
public class ConvertToPalindrome {
    public int solve(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // base case
        if (isPalindrome(A)) {
            return 1; // already a palindrome
        }

        // finding the mismatch
        int i = 0, j = A.length() - 1;
        while (i < j) {
            if (A.charAt(i) != A.charAt(j)) {
                // removing both of them one by one
                // and checking if either removal converts remaining to a palindrome or not
                return (isPalindrome(A.substring(i + 1, j + 1)) || isPalindrome(A.substring(i, j)) ? 1 : 0);
            }

            i++;
            j--;
        }

        // syntactical correctness
        return 0;
    }

    // helper function to check if the string is palindrome or not
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        // it's a palindrome
        return true;
    }
}
