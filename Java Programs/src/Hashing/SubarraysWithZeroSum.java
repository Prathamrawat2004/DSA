package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraysWithZeroSum {
    // User defined pair class
    class Pair {
        int first, second;

        Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    // brute force solution
    public ArrayList<Pair> findSubArrays(int[] arr, int n) {
        // resultant arraylist
        ArrayList<Pair> resultant = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int currentSum = 0;

            for (int j = i; j < n; j++) {
                currentSum += arr[j];

                if (currentSum == 0) {
                    Pair IndexPair = new Pair(i, j);

                    // adding to resultant
                    resultant.add(IndexPair);
                }

            }
        }

        return resultant;

    }

    // optimized solution
    public ArrayList<Pair> findSubArrays2(int[] arr, int n) {
        // resultant arraylist
        ArrayList<Pair> resultant = new ArrayList<>();

        // creating a hashmap
        HashMap<Integer, Integer> PairMap = new HashMap<>();

        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            // If subarray from 0 to i has sum 0
            if (currentSum == 0) {
                resultant.add(new Pair(0, i));
            }

            // if the same sum is found at two indices
            // the middle elements contains the sum = 0
            // creating a subarray out of it
            if (PairMap.containsKey(currentSum)) {
                resultant.add(new Pair(PairMap.get(currentSum) + 1, i));
            }

            // adding the current sum
            PairMap.put(currentSum, i);

        }

        return resultant;
    }
}
