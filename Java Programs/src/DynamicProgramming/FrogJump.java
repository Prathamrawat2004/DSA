package DynamicProgramming;
// 1D dp hence used dp[n]
public class FrogJump {
    // recursive solution
    public int frogJump1(int n, int[] h) {
        // base condition
        // no cost at start
        if (n == 0) {
            return 0;
        }

        // jump one step (from n - 1)(0 - based index)
        // calculating the energy
        int oneStep = frogJump1(n - 1, h) + Math.abs(h[n] - h[n - 1]);

        int twoStep = Integer.MAX_VALUE;
        if (n > 1) {
            twoStep = frogJump1(n - 2, h) + Math.abs(h[n] - h[n - 2]);
        }

        return Math.min(oneStep, twoStep);
    }

    // memoization
    public int frogJump2(int n, int[] h, int[] dp) {
        // base condition
        // no cost at start
        if (n == 0) {
            return 0;
        }

        // check if the current index is precomputed or not
        if (dp[n] != -1) {
            return dp[n];
        }

        // jump one step (from n - 1)(0 - based index)
        // calculating the energy
        int oneStep = frogJump2(n - 1, h, dp) + Math.abs(h[n] - h[n - 1]);

        int twoStep = Integer.MAX_VALUE;
        if (n > 1) {
            twoStep = frogJump2(n - 2, h, dp) + Math.abs(h[n] - h[n - 2]);
        }

        // store the result in dp before returning
        return dp[n] = Math.min(oneStep, twoStep);
    }

    // tabulation
    public int frogJump3(int n, int[] h) {
        // array to store the values
        int[] dp = new int[n];

        // base case
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int oneStep = dp[i - 1] + Math.abs(h[i] - h[i - 1]);

            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = dp[i - 2] + Math.abs(h[i] - h[i - 2]);
            }

            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[n - 1];
    }
}
