package DynamicProgramming.KnapSackProblems;

public class CountSubsetsWithGivenDiff {
    // recursive code
    public static int countSubsetsWithDiff(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr)
            totalSum += num;

        if ((totalSum + diff) % 2 != 0)
            return 0; // not possible
        int target = (totalSum + diff) / 2;

        return countSubsetsRecursive(arr, arr.length, target);
    }

    // definition of helper function
    static int countSubsetsRecursive(int[] arr, int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }

        if (arr[n - 1] <= sum) {
            return countSubsetsRecursive(arr, n - 1, sum - arr[n - 1])
                    + countSubsetsRecursive(arr, n - 1, sum);
        } else {
            return countSubsetsRecursive(arr, n - 1, sum);
        }
    }

    // memoization
    public static int countSubsetsWithDiff2(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr)
            totalSum += num;

        if ((totalSum + diff) % 2 != 0)
            return 0;
        int target = (totalSum + diff) / 2;

        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(arr, arr.length, target, dp);
    }

    // definition of helper function
    static int helper(int[] arr, int n, int sum, int[][] dp) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }

        if (dp[n][sum] != -1)
            return dp[n][sum];

        if (arr[n - 1] <= sum) {
            dp[n][sum] = helper(arr, n - 1, sum - arr[n - 1], dp)
                    + helper(arr, n - 1, sum, dp);
        } else {
            dp[n][sum] = helper(arr, n - 1, sum, dp);
        }

        return dp[n][sum];
    }

    // tabulation
    public static int countSubsetsWithDiff3(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr)
            totalSum += num;

        if ((totalSum + diff) % 2 != 0)
            return 0;
        int target = (totalSum + diff) / 2;

        return countSubsetsTabulation(arr, target);
    }

    // definition of helper function
    static int countSubsetsTabulation(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        // base case: sum == 0 → 1 way (take empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
