package Arrays;

import java.util.ArrayList;

public class Partitions {
    public int solve(int A, ArrayList<Integer> B) {
        // calculating the total sum
        long totalSum = 0;

        for (int num : B) {
            totalSum += num;
        }

        if (totalSum % 3 != 0) {
            return 0; // cannot be divided into 3 parts
        }

        long targetSum = totalSum / 3; // for each part
        int ways = 0;
        int countTargetSum = 0;
        long sum = 0;

        for (int i = 0; i < A - 1; i++) {
            sum += B.get(i);

            if (sum == 2 * targetSum) {
                ways += countTargetSum;
            }

            if (sum == targetSum) {
                countTargetSum++;
            }

        }

        return ways;
    }
}
