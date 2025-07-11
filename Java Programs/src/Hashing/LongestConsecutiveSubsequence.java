package Hashing;
import java.util.*;

public class LongestConsecutiveSubsequence {
    // brute force solution
    public int longestConsecutive(int[] arr){
        // sorting the given array
        Arrays.sort(arr);

        // declaring pointers for result & counter
        int count = 1, result = 1;

        for(int i = 1; i < arr.length; i++){
            // skipping the duplicates
            if(arr[i] == arr[i - 1]){
                continue;
            }else if(arr[i] == arr[i - 1] + 1){
                count++;
            }else{
                // resetting the count for next subsequence
                count = 1;
            }

            // updating the result
            result = Math.max(result, count);
        }
        
        return result;
    }

    // optimized approach
    public int longestConsecutive2(int[] arr){
        // using hashset to store the values
        HashSet<Integer> set = new HashSet<>();

        // storing the values in set
        for(int val: arr){
            set.add(val);
        }

        // pointers to check for subsequence
        int count = 0, result = 0;

        for(int val: arr){
            // finding the starting element
            if(set.contains(val) && !set.contains(val - 1)){
                // it's the starting element
                int curr = val;
                count = 0;

                // finding the further sequence
                while(set.contains(curr)){
                    // removing the current element to avoid recomputation
                    set.remove(curr);
                    curr++;
                    count++;
                }

                // updating the result
                result = Math.max(count, result);
            }
        }


        return result;
    }
}
