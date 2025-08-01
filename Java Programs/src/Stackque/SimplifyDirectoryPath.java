package Stackque;

import java.util.*;

public class SimplifyDirectoryPath {
    // brute force approach
    public String simplifyPath1(String A) {
        // removing the leading and trailing spaces
        A = A.trim();
        StringBuilder absolute = new StringBuilder();

        // creating a List to simulate the stack like behavior
        List<String> path = new ArrayList<>();

        String[] parts = A.split("/");

        for (String part : parts) {
            if (part.equals(".") || part.equals("")) {
                continue;
            } else if (part.equals("..")) {
                // remove the last added path
                if (!path.isEmpty()) {
                    path.remove(path.size() - 1);
                }
            } else {
                // valid part
                path.add(part);
            }
        }

        for (String part : path) {
            absolute.append("/").append(part);
        }

        return absolute.length() == 0 ? "/" : absolute.toString();

    }

    // optimized approach
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
