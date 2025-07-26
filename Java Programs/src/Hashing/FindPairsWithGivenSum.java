package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

// "Arrays.aslist()" while converting to list sees every object as seperate argument 
// but when it comes to primitives it sees them as one argument

public class FindPairsWithGivenSum {
    // Brute-force approach
    public List<List<Integer>> distinctPairs(int[] arr, int target) {
        // resultant array
        List<List<Integer>> resultant = new ArrayList<>();

        // sorting the given array to ensure q1 <= q2
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            // skipping duplicates
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int j = i + 1; j < arr.length; j++) {
                // Skip duplicates for arr[j]
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                if (arr[i] + arr[j] == target) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(arr[i]);
                    pair.add(arr[j]);
                    resultant.add(pair);
                }
            }
        }

        return resultant;

    }

    // optimized approach
    public List<List<Integer>> optimizedPairs(int[] arr, int target) {
        // resultant arraylist
        List<List<Integer>> resultant = new ArrayList<>();

        // creating hashsets
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> added = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                // pair found
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);

                // tracking the current key
                String key = a + ":" + b;

                if (!added.contains(key)) {
                    // add it to resultant list
                    resultant.add(Arrays.asList(a, b));

                    added.add(key);

                }
            }
            seen.add(num);
        }

        return resultant;

    }
}
