package Stackque;

import java.util.*;
// revisions = 1
public class RedundantBraces {
    // brute force solution
    public int braces1(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // creating a stringbuilder
        StringBuilder sb = new StringBuilder(A);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ')') {
                // start moving backwards till opening braces
                int j = i - 1;
                boolean isRedundant = true;

                while (j >= 0 && sb.charAt(j) != '(') {
                    if (A.charAt(j) == '+' || A.charAt(j) == '-' || A.charAt(j) == '*' || A.charAt(j) == '/') {
                        isRedundant = false;
                        sb.setCharAt(j, '#'); // marking the processed operator
                    }
                    j--;
                }

                if (isRedundant) {
                    return 1;
                }

                // removing the processed opening and closing braces
                sb.setCharAt(i, '#');
                sb.setCharAt(j, '#');

            }
        }

        return 0;
    }

    // optimized solution
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
