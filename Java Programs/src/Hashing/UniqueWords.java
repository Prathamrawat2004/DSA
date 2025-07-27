package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueWords {
    // brute force solution
    public void printUniqueWords(String str) {
        // removing the leading and trailing spaces
        str = str.trim();

        // converting to string array
        // removing case sensitivity issue by converting to lowercase
        String[] words = str.toLowerCase().split("[^A-Za-z0-9]+");

        // travering the array
        for (int i = 0; i < words.length; i++) {
            // flag to check if the word is repeating or not
            boolean found = false;

            for (int j = i; j < words.length; j++) {
                if (i != j && words[i].equals(words[j])) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.print(words[i] + " ");
            }
        }

    }

    // optimized solution
    public void printUniqueWords2(String str) {
        // removing the leading and trailing spaces
        str = str.trim();

        // creating a string array
        String[] words = str.toLowerCase().split("[^A-Za-z0-9]+");

        // creating a hashset to store words
        HashMap<String, Integer> uniqueMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (uniqueMap.containsKey(words[i])) {
                uniqueMap.put(words[i], uniqueMap.get(words[i]) + 1);
            } else {
                uniqueMap.put(words[i], 1);
            }

            // or
            // uniqueMap.put(words[i], uniqueMap.getOrDefault(words[i], 0) + 1);
        }

        // printing the keys with value = 1
        for (String key : uniqueMap.keySet()) {
            if (uniqueMap.get(key) == 1) {
                System.out.print(key + " ");
            }
        }
    }
}
