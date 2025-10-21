package DynamicProgramming.KnapSackProblems;

public class CountOfSubsets {
    // recursive method
    public int countSubsets1(int[] arr, int Sum, int n) {
        // base condition
        if (Sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        // current element's val > Sum
        if (arr[n - 1] > Sum) {
            // skip it
            return countSubsets1(arr, Sum, n - 1);
        }

        // we have choices
        return countSubsets1(arr, Sum - arr[n - 1], n - 1) + countSubsets1(arr, Sum, n);
    }

    // memoization
    public int countSubsets2(int[] arr, int Sum, int n){
        int[][] dp = new int[n + 1][Sum + 1];
        return SubsetCountMemo(arr, Sum, n, dp);
    }
    // definition of helper function
    public int SubsetCountMemo(int[] arr, int target, int n, int[][] dp){
        // base conditions
        if(target == 0){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        // if the value is already present
        if(dp[n][target] != -1){
            return dp[n][target];
        }

        // the current element's val > target
        if(arr[n - 1] > target){
            // skip it
            return dp[n][target] = SubsetCountMemo(arr, target, n - 1, dp);
        }

        // we have choices
        return dp[n][target] = SubsetCountMemo(arr, target - arr[n - 1], n - 1, dp) + SubsetCountMemo(arr, target , n - 1, dp);
    }

    // tabulation
    public int countSubsets3(int[] arr, int Sum, int n){
        int[][] dp = new int[n + 1][Sum + 1];

        // base conditions
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1; // sum = 0 is always possible
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= Sum; j++){
                if(arr[i - 1] > j){
                    dp[i][j] = dp[i - 1][j]; // skip it
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][Sum];
    }
}
