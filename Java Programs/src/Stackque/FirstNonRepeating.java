package Stackque;

// revisions = 1
import java.util.*;

public class FirstNonRepeating {

    // brute force solution
    public String solve1(String A) {
        StringBuilder B = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            boolean found = false;

            for (int j = 0; j <= i; j++) {
                char ch = A.charAt(j);
                if (countChar(A, j, i, ch) == 1) {
                    B.append(ch);
                    found = true;
                    break;
                }
            }

            if (!found) {
                B.append('#');
            }
        }

        return B.toString();
    }

    // Count how many times 'ch' appears between index start to end
    private int countChar(String A, int start, int end, char ch) {
        int count = 0;
        for (int k = start; k <= end; k++) {
            if (A.charAt(k) == ch)
                count++;
        }
        return count;
    }

    // optimized approach
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
