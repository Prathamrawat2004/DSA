package Hashing;

import java.util.ArrayList;
import java.util.*;

public class GroupAnagrams {
    // brute force approach
    public ArrayList<ArrayList<String>> anagrams(ArrayList<String> inputStr, int n) {
        // resultant arraylist
        ArrayList<ArrayList<String>> groupedAnagrams = new ArrayList<>();
        ArrayList<Boolean> isAnagramed = new ArrayList<>(Collections.nCopies(n, false));

        for (int i = 0; i < inputStr.size(); i++) {
            // skipping already anagrammed strings
            if (isAnagramed.get(i)) {
                continue;
            }

            // sorting the given string
            char[] ch = inputStr.get(i).toCharArray();
            Arrays.sort(ch);
            ArrayList<String> anagram = new ArrayList<>();
            anagram.add(inputStr.get(i));

            for (int j = 0; j < n; j++) {
                char[] ch1 = inputStr.get(j).toCharArray();
                Arrays.sort(ch1);

                if (i != j && Arrays.equals(ch, ch1)) {
                    // adding to current anagram
                    anagram.add(inputStr.get(j));
                    isAnagramed.set(j, true);
                }

            }

            // adding to resultant
            groupedAnagrams.add(anagram);
        }

        return groupedAnagrams;
    }

    // optimized solution
    public ArrayList<ArrayList<String>> anagramsOptimized(ArrayList<String> inputStr, int n) {
        // creating a hashmap to store the anagrams
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<>();

        for (int i = 0; i < inputStr.size(); i++) {
            // sorting the given string
            char[] ch = inputStr.get(i).toCharArray();
            Arrays.sort(ch);

            String sortedList = new String(ch); // works only with byte[] and char[]

            // checking if it already exits in the hashmap
            // if not, add new input
            if (anagramMap.containsKey(sortedList)) {
                anagramMap.get(sortedList).add(inputStr.get(i));
            } else {
                // creating a new arraylist
                ArrayList<String> newList = new ArrayList<>();

                newList.add(inputStr.get(i));

                // adding new input with key as sortedList string
                anagramMap.put(sortedList, newList);
            }
        }

        // resultant arraylist
        ArrayList<ArrayList<String>> groupedAnagrams = new ArrayList<>(anagramMap.values());
        return groupedAnagrams;

    }
}
