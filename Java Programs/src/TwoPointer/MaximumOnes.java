package TwoPointer;

import java.util.*;

public class MaximumOnes {
    public int solve(ArrayList<Integer> A, int B) {
        // req pointers
        int left = 0, right = 0;
        int maxLength = 0;
        int zeroCount = 0;

        // sliding window approach
        while (right < A.size()) {

            if (A.get(right) == 0) {
                zeroCount++;
            }

            // if the count of zero becomes more than B
            while (zeroCount > B && left <= right) {
                // left is responsible for decreasing the window
                // ensuring the zeroCount between right and left remains <= B
                if (A.get(left) == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;

    }
}
