package DynamicProgramming.KnapSackProblems;

// knapsack variation - 1
public class SubsetSum {
    // recursive solution
    public boolean IssubsetSum(int[] arr, int Sum, int n) {
        // base condition
        if (Sum == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        // current element's value > Sum required
        if (arr[n - 1] > Sum) {
            return IssubsetSum(arr, Sum, n - 1); // skip it
        }

        // we have two choices
        // either include it or exclude it
        return IssubsetSum(arr, Sum - arr[n - 1], n) || IssubsetSum(arr, Sum, n - 1);
    }

    // memoization
    public boolean IssubsetSum2(int[] arr, int Sum, int n) {
        // creating a boolean dp
        Boolean[][] dp = new Boolean[n + 1][Sum + 1];
        return helper(arr, Sum, n, dp);
    }

    // definition of helper function
    public boolean helper(int[] arr, int target, int n, Boolean[][] dp) {
        // base condition
        if (target == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        // the value is already present
        if (dp[n][target] != null) {
            return dp[n][target];
        }

        // call recursion and store it's value
        return dp[n][target] = helper(arr, target - arr[n - 1], n, dp) || helper(arr, target, n - 1, dp);
    }

    // tabulation
    public boolean IssubsetSum3(int[] arr, int Sum, int n) {
        // creating a dp
        Boolean[][] dp = new Boolean[n + 1][Sum + 1];

        // base condition
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // sum = 0 is always possible
        }

        // filling the matrices
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; // skip it
                } else {
                    // we have two choices
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                }
            }
        }

        return dp[n][Sum];
    }
}
