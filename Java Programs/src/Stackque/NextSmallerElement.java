package Stackque;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    // brute force approach
    public int[] nextSmallerElements1(int[] arr) {
        int n = arr.length;

        // resultant array
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            boolean found = false; // flag to check if the next smaller is present or not

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    found = true;
                    result[i] = arr[j];
                    break;
                }
            }

            if (!found) {
                result[i] = -1;
            }
        }

        return result;
    }

    // optimized approach
    public int[] nextSmallerElements(int[] arr) {
        // resultant array
        int[] result = new int[arr.length];

        // filling the current array with default values
        Arrays.fill(result, -1);

        // implementing a stack
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return result;
    }
}
