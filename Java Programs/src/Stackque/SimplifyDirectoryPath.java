package Stackque;

import java.util.*;

public class SimplifyDirectoryPath {
    public String simplifyPath(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // declaring stack
        Stack<String> stack = new Stack<>();

        // splitting the string based on slashes
        String[] parts = A.split("/");

        // traversing the array
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue; // skip
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    // move one level up
                    stack.pop();
                }
            } else {
                // adding elements to stack
                stack.push(part);
            }
        }

        // creating an absolute string
        StringBuilder absolutePath = new StringBuilder();
        while (!stack.isEmpty()) {
            absolutePath.insert(0, "/" + stack.pop());
        }

        return absolutePath.length() == 0 ? "/" : absolutePath.toString();
    }
}
