package Stackque;

import java.util.*;

public class RedundantBraces {
    public int braces(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // implementing stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            // if the character is open bracket or any operator
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // push it in stack
                stack.push(ch);

            } else if (ch == ')') {
                boolean isRedundant = true;

                // removing elements from the stack until opening bracket is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();

                    // if top is any operator, not redundant
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        isRedundant = false;
                    }
                }

                // removing the opening brace
                if (!stack.isEmpty()) {
                    stack.pop();
                }

                if (isRedundant) {
                    return 1;
                }

            }
        }

        // no redundant braces found
        return 0;
    }
}
