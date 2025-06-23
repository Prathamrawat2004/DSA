package Arrays;

import java.util.Stack;

public class MinimumParentheses {
    public int solve(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // to count number of parentheses required
        int count = 0;

        // getting the size of given string
        int n = A.length();

        // implementing stack for open brackets
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else {
                // if the first character is closed bracket
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }

        // counting the opening brackets
        while (!stack.isEmpty()) {
            stack.pop();
            count++;
        }

        return count;
    }
}
