package Stackque;

// revisions = 1
import java.util.*;

public class BalancedParentheses {

    // brute force solution
    public int isBalanced(String A) {
        int count = 0;

        for (char c : A.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    // More closing brackets than opening at some point
                    return 0;
                }
            }
        }

        // If all opened brackets are properly closed
        return count == 0 ? 1 : 0;
    }

    // optimized approach
    public int solve(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // to store opening brackets
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            // opening bracket
            if (ch == '(') {

                stack.push(ch);

            } else {

                // if the first character is closing bracket
                // or the opening bracket is finished while traversal
                if (stack.isEmpty()) {
                    return 0;

                } else {

                    // balancing the parentheses
                    stack.pop();
                }
            }
        }

        // might be a possibility of more opening brackets than closing
        return stack.isEmpty() ? 1 : 0;
    }
}
