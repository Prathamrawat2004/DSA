package TwoPointer;

import java.util.*;
// revisions = 1
public class CountingSubarrays {
    // brute force approach
    public int solve1(ArrayList<Integer> A, int B){
        // getting the size of array
        int n = A.size();
        int count = 0;

        for(int i = 0; i < n; i++){
            // resetting the sum each time for every iteration
            int sum = 0;
            
            for(int j = i; j < n; j++){
                sum += A.get(j);

                if(sum < B){
                    count++;
                }else{
                    break;
                }
                
            }
        }


        return count;
    }
    
    
    // optimized approach
    public int solve(ArrayList<Integer> A, int B) {

        // counting the number of subarrays
        int count = 0;

        // for counting the current sum
        int currentSum = 0;

        // sliding window approach
        int left = 0;
        for (int right = 0; right < A.size(); right++) {
            currentSum += A.get(right);

            while (currentSum >= B && left <= right) {
                currentSum -= A.get(left);
                left++;
            }

            count += (right - left) + 1;
        }

        return count;
    }
}
