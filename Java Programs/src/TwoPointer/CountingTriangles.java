package TwoPointer;

import java.util.*;
// revisions = 1
public class CountingTriangles {
    // brute force approach
    public int nTriangles1(ArrayList<Integer> A){
        // getting the size of given arraylist
        int n = A.size();
        int mod = 1000000007;

        // to count the number of possible triangles
        int count = 0;


        // sorting the given list
        // ensuring a <= b <= c
        // only one condition to check i.e a + b > c
        Collections.sort(A);

        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    if(A.get(i) + A.get(j) > A.get(k)){
                        count = (count + 1) % mod;
                    }
                }
            }
        }

        return count;
    }



    // optimized approach
    public int nTriangles(ArrayList<Integer> A) {
        // getting the size of list
        int n = A.size();

        int mod = 1000000007;

        // base condition
        if (n < 3){
            // not enough elements for triangle
            return 0;
        } 

        // sorting
        Collections.sort(A);

        // initializing pointers
        int count = 0;

        // sliding window approach
        for (int i = n - 1; i >= 2; i--) {
            int left = 0; // resetting for next iteration
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
