package TwoPointer;

import java.util.*;
// revisions = 1
public class MaximumOnes {
    // brute force approach
    public int solve1(ArrayList<Integer> A, int B) {
        int n = A.size();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int zeroCount = 0;

            for (int j = i; j < n; j++) {
                if (A.get(j).equals(0)) {
                    zeroCount++;
                }

                if (zeroCount > B) {
                    break;
                }

                // keep updating maxlength
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    // optimized approach
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
