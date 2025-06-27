package Strings;

public class AmazingSubarrays {
    public int solve(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        int mod = 10003;
        int count = 0; // counting the subarrays
        int n = A.length();

        // checking if the character at ith position is a vowel or not
        for (int i = 0; i < n; i++) {
            if (isVowel(A.charAt(i))) {
                count = (count + (n - i));
            }

        }

        return count % mod;
    }

    // function to check vowel
    public boolean isVowel(char ch) {
        // converting to lowercase
        ch = Character.toLowerCase(ch);

        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
