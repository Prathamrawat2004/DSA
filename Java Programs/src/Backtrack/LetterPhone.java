package Backtrack;

import java.util.*;

public class LetterPhone {
    // globally creating digitToLetters
    private static final String[] digitToLetters = {
            "0", // 0
            "1", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqr", // 7
            "stu", // 8
            "wxyz" // 9
    };

    public static ArrayList<String> letterCmbinations(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // resultant arraylist
        ArrayList<String> resultant = new ArrayList<>();

        // base condition
        if (A == null || A.isEmpty()) {
            return resultant;
        }

        // function to generate combinations
        generateLetterCombinations(A, 0, new StringBuilder(), resultant);

        return resultant;
    }

    // helper function definition
    public static void generateLetterCombinations(String A, int index, StringBuilder current,
            ArrayList<String> resultant) {
        // base condition
        if (index == A.length()) {
            resultant.add(current.toString());
            return;
        }

        // getting the corresponding letters to digits
        int digit = A.charAt(index) - '0';
        String letters = digitToLetters[digit];

        // forming combinations
        for (char letter : letters.toCharArray()) {
            current.append(letter);

            // recursion
            generateLetterCombinations(A, index + 1, current, resultant);

            // backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }
}
