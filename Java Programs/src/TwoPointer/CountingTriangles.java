package TwoPointer;

import java.util.*;

public class CountingTriangles {
    public int nTriangles(ArrayList<Integer> A) {
        // getting the size of list
        int n = A.size();

        int mod = 1000000007;

        // base condition
        if (n < 3){
            // not enought elements for triangle
            return 0;
        } 

        // sorting
        Collections.sort(A);

        // initializing pointers
        int left = 0, count = 0;

        // sliding window approach
        for (int i = n - 1; i >= 2; i--) {
            int right = i - 1;
            while (left < right) {
                if (A.get(left) + A.get(right) > A.get(i)) {
                    count += (right - left) % mod;
                    right--;
                } else {
                    left++;
                }

            }
        }

        return count;

    }
}
