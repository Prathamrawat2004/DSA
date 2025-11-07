package DynamicProgramming;
// revisions = 1
import java.util.Arrays;

public class HouseRobber2 {
    // recursive (forward version)
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0]; // only one house

        // Option 1: exclude last house
        int option1 = solve(nums, 0, n - 2);
        // Option 2: exclude first house
        int option2 = solve(nums, 1, n - 1);

        return Math.max(option1, option2);
    }

    private static int solve(int[] nums, int start, int end) {
        if (start > end)
            return 0;
        if (start == end)
            return nums[start];

        int pick = nums[start] + solve(nums, start + 2, end);
        int notPick = solve(nums, start + 1, end);

        return Math.max(pick, notPick);
    }

    // memoization
    public static int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int option1 = solve(nums, 0, n - 2, dp1);
        int option2 = solve(nums, 1, n - 1, dp2);

        return Math.max(option1, option2);
    }

    private static int solve(int[] nums, int start, int end, int[] dp) {
        if (start > end)
            return 0;
        if (start == end)
            return nums[start];
        if (dp[start] != -1)
            return dp[start];

        int pick = nums[start] + solve(nums, start + 2, end, dp);
        int notPick = solve(nums, start + 1, end, dp);

        return dp[start] = Math.max(pick, notPick);
    }

    // tabulation
    public static int rob3(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int case1 = solveTab(nums, 0, n - 2);
        int case2 = solveTab(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private static int solveTab(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];

        dp[start] = nums[start]; // base case

        for (int i = start + 1; i <= end; i++) {
            int pick = nums[i];
            if (i - 2 >= start)
                pick += dp[i - 2]; // safe only if within [start..end]
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[end];
    }
}
