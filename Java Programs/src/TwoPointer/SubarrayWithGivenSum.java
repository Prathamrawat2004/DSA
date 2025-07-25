package TwoPointer;

import java.util.*;

public class SubarrayWithGivenSum {
    // brute force approach
    public ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length;

        // resultant arraylist
        ArrayList<Integer> result = new ArrayList<>();

        // outer loop for starting index
        for(int i = 0; i < n; i++){
            int currentSum = 0;

            for(int j = i; j < n; j++){
                currentSum += arr[j];

                // target found
                if(currentSum == target){
                    result.add(i + 1); // 1-based indexing
                    result.add(j + 1); // 1-based indexing
                    return result;

                }else if(currentSum > target){
                    break;
                }
            }
        }

        // if no subarray found
        result.add(-1);
        return result;

    }

    // optimized approach
    public ArrayList<Integer> subarraySum2(int[] arr, int target){
        int n = arr.length;

        // resultant arraylist
        ArrayList<Integer> result = new ArrayList<>();

        int start = 0, currentSum = 0;

        // using a sliding window approach
        for(int end = 0; end < n; end++){
            currentSum += arr[end];

            // start shrinking the window
            while (currentSum > target && start < end) {
                currentSum -= arr[start];
                start++;
            }

            if(currentSum == target){
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }

        }

        // if no subarray found
        result.add(-1);
        return result;
        
    }
}
