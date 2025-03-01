package Stackque;

import java.util.*;

public class Parentheses {
    public int inValid(String A) {
        // removing the leading & trailing spaces
        A = A.trim();

        // base condition
        if (A.isEmpty()) {
            return 1;
        }

        // intializing stack
        Stack<Character> stack = new Stack<>();

        // traversing the given string
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            // if opening: push into stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // closing bracket found
                if (stack.isEmpty()) {
                    // either the first char is closing bracket
                    // or number(closing) > number(opening)
                    return 0;
                }

                char top = stack.peek();
                if (ch == ')' && top == '(' ||
                        ch == '}' && top == '{' ||
                        ch == ']' && top == '[') {
                    stack.pop();
                } else {
                    // mismatch found
                    return 0;
                }
            }

        }

        
        // if number(opening) > number(closing)
        return stack.isEmpty() ? 1 : 0;
    }
}
