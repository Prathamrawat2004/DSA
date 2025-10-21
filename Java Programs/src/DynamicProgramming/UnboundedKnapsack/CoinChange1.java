package DynamicProgramming.UnboundedKnapsack;
// number of ways to create given sum with infinite supply of coins
public class CoinChange1 {
    // recursive solution
    public int countWays(int[] coins, int sum, int n){
        // base condition
        if(sum == 0){
            return 1; // sum = 0 is always possible
        }

        if(n == 0){
            return 0;
        }

        // the current coin's value > sum
        if(coins[n - 1] > sum){
            return countWays(coins, sum, n - 1); // skip it
        }

        // two choices
        int include = countWays(coins, sum - coins[n - 1], n); // unbounded
        int exclude = countWays(coins, sum, n - 1); // processed

        // total count
        return include + exclude;
    }

    // memoization
    public int countWays2(int[] coins, int sum, int n, int[][] dp){
         // base condition
        if(sum == 0){
            return 1; // sum = 0 is always possible
        }

        if(n == 0){
            return 0;
        }

        // if already stored
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }

        // the current coin's value > sum
        if(coins[n - 1] > sum){
            return countWays(coins, sum, n - 1); // skip it
        }

        // two choices
        int include = countWays(coins, sum - coins[n - 1], n); // unbounded
        int exclude = countWays(coins, sum, n - 1); // processed

        return dp[n][sum] = include + exclude;

    }

    // tabulation
    public int countWays3(int[] coins, int sum, int n){
        // array to store the elements
        int[][] dp = new int[n + 1][sum + 1];

        // sum = 0 is always possible
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(coins[i - 1] > j){
                    dp[i][j] = dp[i - 1][j]; // skip it
                }else{
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
