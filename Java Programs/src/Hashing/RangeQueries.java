package Hashing;

import java.util.*;

public class RangeQueries {
    // brute force approach
    // for one query = O(R - L + 1)
    // for 'Q' queries = O(Q x (R - L + 1))
    public int findFrequency(int[] arr, int n, int left, int right, int element){
        // to count the frequency
        int count = 0;

        for(int i = left - 1; i <= right - 1; i++){
            if(arr[i] == element){
                count++;
            }
        }

        return count;
    }

    // optimized approach
    // time complexity = O(n + Q x log(n)) (better)
    public int findFrequency2(int[] arr, int n, int left, int right, int element){
        // creating a hashmap to store elements and their corresponding indices
        HashMap<Integer, ArrayList<Integer>> indexMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            // adds a new element (if not present)
            // updates the values of current element
            indexMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i); // (0-based)
        }

        // getting the count of occurrences
        if(indexMap.get(element) == null){
            return 0;
        }

        int l = lowerBound(indexMap.get(element), left - 1);
        int r = upperBound(indexMap.get(element), right - 1);

        return (r - l);
    }

    // creating lower bound and upper bound functions
    // using binary search to find the range extremes
    public int lowerBound(ArrayList<Integer> positions, int target){
        int low = 0, high = positions.size() - 1;

        // finding the first index >= target
        while(low < high){
            int mid = low + (high - low) / 2;

            if(positions.get(mid) >= target){ 
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    public int upperBound(ArrayList<Integer> positions, int target){
        int low = 0, high = positions.size() - 1;

        // finding the first index > target
        while(low < high){
            int mid = low + (high - low) / 2;

            if(positions.get(mid) > target){ 
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

  
}
