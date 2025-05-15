package TwoPointer;

import java.util.*;

public class ThreeSum {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        // getting the size
        int n = A.size();

        // base condition
        if (n < 3)
            return 0; // ask the interviewer

        // sorting
        Collections.sort(A);

        // initial closest sum
        int closestSum = A.get(0) + A.get(1) + A.get(2);

        // sliding window approach
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = A.get(i) + A.get(left) + A.get(right);

                if (currentSum == B) {
                    return currentSum;
                }

                // checking the closeness of current value
                if (Math.abs(currentSum - B) < Math.abs(closestSum - B)) {
                    closestSum = currentSum;
                }

                // moving pointers
                if (currentSum < B) {
                    // increase the sum
                    left++;
                } else {
                    right--;
                }
            }

        }
        return closestSum;
    }
}
