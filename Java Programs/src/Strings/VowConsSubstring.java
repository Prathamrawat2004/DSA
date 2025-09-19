package Strings;
// revisions = 1
public class VowConsSubstring {
    public int solve(String A) {
        // removing the leading and trailing spaces
        A = A.trim();
        final int mod = 1000000007;

        // initializing pointers
        int vowelCount = 0, consonantCount = 0;
        int result = 0;

        for (int i = 0; i < A.length(); i++) {
            if (isVowel(A.charAt(i))) {
                vowelCount++;

                // as there might be consonants before
                result = (result + consonantCount);

            } else {
                consonantCount++;

                // as there might be vowels before
                result = (result + vowelCount);
            }
        }

        return (result % mod);

    }

    // helper function vowel
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
