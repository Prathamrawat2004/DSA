package DynamicProgramming.KnapSackProblems;

public class EqualSumPartition {
    // recursive solution
    public boolean IsEqualSum(int[] arr) {
        // getting the sum of given elements inside array
        int totalSum = 0; // or long
        for (int element : arr) {
            totalSum += element;
        }

        // base condition
        if (totalSum % 2 != 0) {
            return false; // cannot be divided to two equal halves
        }

        // similar to "Subset Sum" problem now
        return helperRecursion(arr, arr.length, totalSum / 2);
    }
    // helper function definition
    public boolean helperRecursion(int[] arr, int n, int Sum) {
        if (Sum == 0) {
            return true; // sum = 0 is always possible
        }

        if (n == 0) {
            return false;
        }

        // current element's value > given sum
        if (arr[n - 1] > Sum) {
            return helperRecursion(arr, n - 1, Sum); // skip it
        }

        // we have two choices
        return helperRecursion(arr, n - 1, Sum - arr[n - 1]) || helperRecursion(arr, n - 1, Sum);
    }


    // memoization
    public boolean IsEqualSum2(int[] arr) {
        // getting the sum of given elements inside array
        int totalSum = 0; // or long
        for (int element : arr) {
            totalSum += element;
        }

        // base condition
        if (totalSum % 2 != 0) {
            return false; // cannot be divided to two equal halves
        }

        Boolean[][] dp = new Boolean[arr.length + 1][(totalSum / 2) + 1];

        return helperMemo(arr, totalSum / 2, arr.length, dp);
    }
    // definition of helper function
    public boolean helperMemo(int[] arr, int Sum, int n, Boolean[][] dp) {
        if (Sum == 0) {
            return true; // sum = 0 is always possible
        }

        if (n == 0) {
            return false;
        }

        // current element's value > given sum
        if (arr[n - 1] > Sum) {
            return dp[n][Sum] = helperMemo(arr, n - 1, Sum, dp); // skip it
        }

        // we have two choices
        return dp[n][Sum] = helperMemo(arr, n - 1, Sum - arr[n - 1], dp) || helperMemo(arr, n - 1, Sum, dp);
    }


    // tabulation
    public boolean IsEqualSum3(int[] arr) {
        // getting the sum of given elements inside array
        int totalSum = 0; // or long
        for (int element : arr) {
            totalSum += element;
        }

        // base condition
        if (totalSum % 2 != 0) {
            return false; // cannot be divided to two equal halves
        }

        // creating a dp array for storing the subset sum
        Boolean[][] dp = new Boolean[arr.length + 1][(totalSum / 2) + 1];

        // base condition
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true; // sum = 0 is always possible
        }

        // filling the matrices
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= totalSum / 2; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; // skip it
                } else {
                    // we have two choices
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                }
            }
        }

        return dp[arr.length][totalSum / 2];
    }

}
