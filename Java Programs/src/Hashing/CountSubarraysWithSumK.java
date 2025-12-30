package Hashing;

import java.util.*;

public class CountSubarraysWithSumK {
    public int countSubarraysWithSumK(int[] revenues, int k) {
        int N = revenues.length;
        int count = 0, currentSum = 0;

        // map<Sum, freq>
        Map<Integer, Integer> freqMap = new HashMap<>();

        // base value
        freqMap.put(0, 1);

        for (int i = 0; i < N; i++) {
            currentSum += revenues[i];

            // freq of (currentSum - k) = number of valid subarrays
            if (freqMap.containsKey(currentSum - k)) {
                count += freqMap.get(currentSum - k);
            }

            freqMap.put(currentSum, freqMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
