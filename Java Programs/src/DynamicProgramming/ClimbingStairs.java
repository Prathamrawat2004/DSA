package DynamicProgramming;
// revisions = 1

public class ClimbingStairs {
    // similar to fibonacci
    // use memoization and tabulation
    public int climbStairs(int n){
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        // total count
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
