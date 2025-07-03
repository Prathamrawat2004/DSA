package Strings;

import java.util.HashMap;
import java.util.Map;

public class BullsCows {
    public String solve(String A, String B) {
        // removing the leading & trailing spaces
        A = A.trim();
        B = B.trim();

        // pointers to count bulls & cows
        int Bulls = 0, Cows = 0;

        // creating hashmaps for counting the frequencies of secret elements & guessed
        // elements
        HashMap<Character, Integer> secretMap = new HashMap<>();
        HashMap<Character, Integer> guessedMap = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            // getting the element of secret and guessed
            char sChar = A.charAt(i);
            char gChar = B.charAt(i);

            if (sChar == gChar) {
                // same position & same value
                Bulls++;
            } else {
                // adding the elements to respective maps with their frequencies
                secretMap.put(sChar, secretMap.getOrDefault(sChar, 0) + 1);
                guessedMap.put(gChar, guessedMap.getOrDefault(gChar, 0) + 1);
            }
        }

        // traversing guess map for cows
        for (Map.Entry<Character, Integer> entry : guessedMap.entrySet()) {
            // getting the key
            char gChar = entry.getKey();

            // getting the value
            int gCount = entry.getValue();

            if (secretMap.containsKey(gChar)) {
                Cows += Math.min(gCount, secretMap.get(gChar));
            }
        }

        return Bulls + "A" + Cows + "B";
    }
}
