package Backtrack;

import java.util.*;

public class MaximalString {
    public String solve(String A, int B) {
        // converting to character array for easy swapping
        char[] chars = A.toCharArray();

        // maintaining an array for modifying max result
        String[] maximal = { A };

        // function to generate maximal string
        findMax(chars, B, 0, maximal);

        return maximal[0];
    }

    // definition of helper function
    public void findMax(char[] chars, int swaps, int index, String[] maximal) {
        // base condition
        String current = new String(chars);
        if (current.compareTo(maximal[0]) > 0) {
            maximal[0] = current;
        }

        // swaps are over
        if (swaps == 0){
            return;
        }

        for (int i = index; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] > chars[i]) {
                    swap(chars, i, j);

                    // recursion
                    findMax(chars, swaps - 1, i + 1, maximal);

                    // backtrack
                    swap(chars, i, j);
                }
            }
        }
    }

    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
