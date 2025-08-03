package Stackque;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    // brute force solution
    // circular array given
    public int[] NextGreaterElement(int[] nums) {
        // resultant array
        int[] resultant = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            boolean found = false;

            for (int j = 1; j < nums.length; j++) {

                int index = (i + j) % nums.length; // this gives circular traversal

                if (nums[index] > nums[i]) {
                    resultant[i] = nums[j];
                    found = true;
                    break;
                }
            }

            if (!found) {
                resultant[i] = -1;
            }
        }

        return resultant;

    }

    // optimized approach
    public int[] NextGreaterElement2(int[] nums) {
        int n = nums.length;

        int[] resultant = new int[nums.length];

        Arrays.fill(resultant, -1);

        Stack<Integer> stack = new Stack<>();

        // incrementing i twice for circular array
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;

            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                int topIndex = stack.pop();
                resultant[topIndex] = nums[currentIndex];
            }

            // to not store same index twice
            if (i < n) {
                stack.push(currentIndex);
            }
        }

        return resultant;
    }
}
