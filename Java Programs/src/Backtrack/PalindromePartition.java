package Backtrack;

import java.util.*;

public class PalindromePartition {
    public ArrayList<ArrayList<String>> partition(String a) {
        // resultant arraylist
        ArrayList<ArrayList<String>> resultant = new ArrayList<>();

        // base condition
        if (a == null || a.isEmpty()) {
            return resultant;
        }

        // function to generate palindromes
        generatePalindromes(a, 0, new ArrayList<>(), resultant);

        return resultant;
    }

    // helper function
    public void generatePalindromes(String a, int index, ArrayList<String> current,
            ArrayList<ArrayList<String>> resultant) {
        // base condition
        if (index == a.length()) {
            resultant.add(current);
            return;
        }

        for (int i = index; i < a.length(); i++) {
            // getting the substring
            String sub = a.substring(index, i + 1);

            if (isPalindrome(sub)) {
                current.add(sub);
                generatePalindromes(a, i + 1, current, resultant);

                // backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str) {
        int low = 0, high = str.length() - 1;

        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
}
