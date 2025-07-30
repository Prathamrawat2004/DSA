package Hashing;
// Palindrome Rule: (Rearrangement allowed)

import java.util.HashMap;
import java.util.Map;

// For a string to be rearranged into a palindrome:
// 1. At most one character can have odd frequency
// 2. All other characters must have even frequency
// 3. Minimum insertions needed = max(0, oddCount - 1)

public class MinInsertionsForPalindrome {
    // brute force approach
    public int minInsertion(String str) {
        // removing the leading and trailing spaces
        str = str.trim();

        int oddCount = 0; // for counting odd freq characters

        for (char ch = 'a'; ch <= 'z'; ch++) {

            int freq = 0;

            for (int i = 0; i < str.length(); i++) {
                if (ch == str.charAt(i))
                    freq++;
            }

            // checking if the character has odd frequency
            if (!(freq % 2 == 0))
                oddCount++;

        }

        // no. of insertions
        return Math.max(0, oddCount - 1);
    }

    // optimized approach
    public int minInsertion2(String str) {
        // removing the leading and trailing spaces
        str = str.trim();

        // creating a frequncy array to store the frequencies of characters
        int[] freq = new int[26]; // 26 Alphabets

        // calculating the frequency of each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
        }

        // counting characters with odd fequencies
        int oddCount = 0;
        for (int i = 0; i < freq.length; i++) {
            if (!(freq[i] % 2 == 0)) {
                oddCount++;
            }
        }

        return Math.max(0, oddCount - 1);

    }

    // another optimized approach using hashmap
    public int minInsertion3(String str) {
        str = str.trim();

        // creating a hashmap to store characters and their frequencies
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int oddCount = 0;

        // storing values in hashmap
        for (int i = 0; i < str.length(); i++) {
            freqMap.put(str.charAt(i), freqMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        // counting the characters with odd frequencies
        for (HashMap.Entry<Character, Integer> Entry : freqMap.entrySet()) {
            if (!(Entry.getValue() % 2 == 0)) {
                oddCount++;
            }

        }

        return Math.max(0, oddCount - 1);
    }

}