package Hashing;

import java.util.ArrayList;
import java.util.*;

public class DistinctElements {
    // brute force approach
    public int countDistinct(int[] arr, int n) {
        // sorting the array
        Arrays.sort(arr);

        // array to store the unique elements
        ArrayList<Integer> uniqueElements = new ArrayList<>();

        // the first element would always be there
        uniqueElements.add(arr[0]);

        int uniqueIndex = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] != uniqueElements.get(uniqueIndex)) {
                uniqueElements.add(arr[i]);
                uniqueIndex++;
            }
        }

       return uniqueElements.size();
    }

    // optimized approach
    public int countDistinct2(int[] arr, int n){
        // to count the number of distinct elements
        int count = 0;

        // creating a hashset to store unique elements
        HashSet<Integer> uniqueSet = new HashSet<>();

        for(int num: arr){
            if(!uniqueSet.contains(num)){
                count++;
            }
            uniqueSet.add(num);
        }

        return count;

    }
}
