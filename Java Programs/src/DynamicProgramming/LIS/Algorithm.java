package DynamicProgramming.LIS;

public class Algorithm {
    // recursive solution
    public static int lis(int[] arr, int i, int prevIndex) {
        // base case
        if (i == arr.length) {
            return 0;
        }

        // either not take the element
        int notTake = lis(arr, i + 1, prevIndex);

        // or take this element
        int take = 0;
        if (prevIndex == -1 || arr[i] > arr[prevIndex]) {
            take = 1 + lis(arr, i + 1, i);
        }

        return Math.max(notTake, take);
    }

    // memoization
    public static int lisMemo(int[] arr, int i, int prevIndex, int[][] dp) {
        // base case
        if (i == arr.length) {
            return 0;
        }

        // already having an answer
        if (dp[i][prevIndex + 1] != -1) {
            return dp[i][prevIndex + 1];
        }

        // either not take the element
        int notTake = lis(arr, i + 1, prevIndex);

        // or take this element
        int take = 0;
        if (prevIndex == -1 || arr[i] > arr[prevIndex]) {
            take = 1 + lis(arr, i + 1, i);
        }

        return dp[i][prevIndex + 1] = Math.max(notTake, take);

    }

    // tabulation
    public static int lisTabu(int[] arr) {
        // getting the length of the given array
        int n = arr.length;

        // base case
        if (n == 0) {
            return 0;
        }

        // creating a dp array to solve the subproblems
        int[] dp = new int[n]; // index-based dp problem

        // initializing base lengths
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
