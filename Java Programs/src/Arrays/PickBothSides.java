package Arrays;

import java.util.*;

public class PickBothSides {
    public int solve(ArrayList<Integer> A, int B) {
        int leftSum = 0;

        // considering B elements from front
        for (int i = 0; i < B; i++) {
            leftSum += A.get(i);
        }

        int maxSum = leftSum;
        int rightSum = 0;
        int n = A.size();

        // permutations
        for (int j = 0; j < B; j++) {
            leftSum -= A.get(B - j - 1);
            rightSum += A.get(n - j - 1);

            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}
