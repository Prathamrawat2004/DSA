package Stackque;

import java.util.*;

public class BalancedParentheses {
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
