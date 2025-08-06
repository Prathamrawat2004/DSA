package Stackque;

import java.util.Stack;

public class StockSpan {
    // brute force approach
    public int[] stockSpan(int[] arr, int n) {
        // resultant array
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {

            int count = 0; // for counting span

            for (int j = i; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    count++;
                } else {
                    break; // once we found it bigger
                }
            }

            span[i] = count;

        }

        return span;
    }

    // optimized approach
    public int[] stockSpan2(int[] arr, int n) {
        // resultant array
        int[] span = new int[n];

        // initializing stack
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // updating the span array
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            stack.push(i);
        }

        return span;
    }

}
