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
    public int[] nextSmallerForward(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {

            // solve answers for elements waiting in stack
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int top = stack.pop();
                result[top] = arr[i];
            }

            stack.push(i);
        }

        return result;
    }

}
