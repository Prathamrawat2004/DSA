package BinarySearch;
// revisions  = 1
public class Sqrt {
    // brute force approach
    public int sqrt1(int A){
        for(int i = 1; i <= A; i++){
            if(i * i == A){
                return i;
            }else if(i * i > A){
                return i - 1;
            }
        }

        return 0; // for A == 0

    }

    // optimized approach
    public int sqrt(int A) {
        // base condition
        if (A == 0 || A == 1) {
            return A;
        }

        // BINARY SEARCH
        // as we will be multiplying the mid val
        long low = 0, high = A, ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid == A) {
                return (int) mid;
            } else if (mid * mid < A) {
                low = mid + 1;
                ans = mid; // for the ones who are not perfect square number
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }
}
