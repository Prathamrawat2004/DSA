package Stackque;

import java.util.Stack;

public class LargestRectangleInHistogram {
    // brute force solution
    public int largestRectangleArea(int[] heights) {
        // size of the current heights array
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int minHeight = heights[i];

            for (int j = i; j < n; j++) {
                // resetting minHeight everytime to include other histograms
                minHeight = Math.min(minHeight, heights[j]);

                // setting the width
                int width = j - i + 1;

                // finding the current area
                int area = minHeight * width;

                // updating the maxArea
                maxArea = Math.max(maxArea, area);
            }

        }

        return maxArea;
    }

    // optimized approach
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Use 0 height for the imaginary bar at the end
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                // time to finalize the rectangle
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
