package Stackque;

import java.util.*;

public class FirstNonRepeating {
    public String solve(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // String B
        StringBuilder B = new StringBuilder();

        // to maintain the freq of each character
        int[] freq = new int[26]; // 26 characters in an alphabet

        // queue for maintaing the processing of characters
        Queue<Character> queue = new LinkedList<>();

        // processing the given string
        for (char c : A.toCharArray()) {
            // incrementing the freq of each character after it has been processed
            freq[c - 'a']++;

            // adding to the queue
            queue.offer(c);

            // checking if the current character is first non repeating
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                // removing from the queue
                queue.poll();
            }

            // if the queue is not empty
            if (!queue.isEmpty()) {
                B.append(queue.peek());
            } else {
                B.append('#');
            }

        }

        return B.toString();
    }

}
