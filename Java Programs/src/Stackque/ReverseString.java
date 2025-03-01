package Stackque;

import java.util.*;
import java.lang.*;

public class ReverseString {
    public String reverseString(String A) {
        // removing the leading & trailing spaces
        A = A.trim();

        // if still the input string is empty
        if (A.isEmpty()) {
            return A;
        }

        // initializing stack for character
        Stack<Character> stack = new Stack<>();

        // initializing string builder class for the reversed string
        StringBuilder reversed = new StringBuilder();

        // traversing the string
        for (int i = 0; i < A.length(); i++) {
            // adding every character to stack
            stack.push(A.charAt(i));
        }

        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
