package Hashing;

import java.util.*;

public class PairsWithDiffK {
    // brute force solution
    public int countPairs(int[] arr, int k) {
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // optimized solution
    // we also have to count the duplicates(not just distinct elements)
    public int countPairs2(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int cnt = 0;

        // moving from right to left i.e i < j
        for (int i = arr.length - 1; i >= 0; i--) {

            // Check if the complement (arr[i] + k)
            // exists in the map. If yes, increment count
            if (freq.containsKey(arr[i] + k))
                cnt += freq.get(arr[i] + k);

            // Check if the complement (arr[i] - k)
            // exists in the map. If yes, increment count
            if (freq.containsKey(arr[i] - k))
                cnt += freq.get(arr[i] - k);

            // Increment the frequency of arr[i]
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        return cnt;
    }
}
