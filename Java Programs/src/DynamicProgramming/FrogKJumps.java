package DynamicProgramming;
// revisions = 1
import java.util.Arrays;

public class FrogKJumps {
    // recursive solution
    public int minEnergy1(int n, int[] height, int k) {
        // base case
        if (n == 0) {
            return 0; // energy req to jump from 0 -> 0
        }

        int minimumEnergy = Integer.MAX_VALUE;

        // taking 'k' steps
        for (int j = 1; j <= k; j++) {

            int jumps = Integer.MAX_VALUE;

            if (n - j >= 0) {
                jumps = minEnergy1(n - j, height, k) + Math.abs(height[n] - height[n - j]);
            }

            minimumEnergy = Math.min(minimumEnergy, jumps);
        }

        return minimumEnergy;
    }

    // memoization
    public int minEnergy2(int n, int[] height, int k, int[] dp) {
        // base case
        if (n == 0) {
            return 0; // energy req to jump from 0 -> 0
        }

        // if the dp already has value, return it
        if (dp[n] != -1) {
            return dp[n];
        }

        int minimumEnergy = Integer.MAX_VALUE;

        // taking 'k' steps
        for (int j = 1; j <= k; j++) {

            int jumps = Integer.MAX_VALUE;

            if (n - j >= 0) {
                jumps = minEnergy1(n - j, height, k) + Math.abs(height[n] - height[n - j]);
            }

            minimumEnergy = Math.min(minimumEnergy, jumps);
        }

        return dp[n] = minimumEnergy;
    }

    // tabulation solution
    public int minEnergy3(int n, int[] height, int k) {
        
        // taking a dp array
        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            // taking 'k' steps
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }

            dp[i] = minSteps; // store the best answer
        }

        return dp[n - 1];
    }

}
