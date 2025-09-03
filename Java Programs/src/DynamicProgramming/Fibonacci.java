package DynamicProgramming;

public class Fibonacci {
    // using memoization(top-down) - recursion + cache(array/hashmap)
    // time complexity - O(n)
    // space complexity - O(n)
    public int fibonacci(int n, int[] memo) {
        // base case
        if (n <= 1) {
            return n;
        }

        // checking the memo
        if (memo[n] != -1) {
            return memo[n];
        }

        // compute the sub-problem and store it in memo
        return memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
    }

    // using tabulation(bottom-up) - iteration + cache(array/hashmap)
    // time complexity - O(n)
    // space complexity - O(n)
    public int fibonacci2(int n) {
        // array to store values
        int[] memo = new int[n + 1];

        // solving base cases first
        memo[0] = 0;
        memo[1] = 1;

        // solving nth case
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    // space optimized tabulation
    // space complexity - O(1)
    public int fibonacci3(int n) {
        // base case
        if (n <= 1) {
            return n;
        }

        int prev2 = 0, prev1 = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
