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
    public int countPairs2(int[] arr, int k) {
        int count = 0;

        // creating a hashset
        HashSet<Integer> seen = new HashSet<>();

        for (int i = arr.length - 1; i >= 0; i++) {
            if (seen.contains(arr[i] - k) || seen.contains((arr[i] + k))) {
                count++;
            }
            seen.add(arr[i]);
        }

        return count;
    }
}
