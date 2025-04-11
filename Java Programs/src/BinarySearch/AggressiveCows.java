package BinarySearch;

import java.util.*;

public class AggressiveCows {
    public int aggressiveCows(ArrayList<Integer> stalls, int k) {
        // base condition
        if (stalls.size() < k) {
            return -1; // not enough stalls to place cows
        }

        // sorting the stalls
        Collections.sort(stalls);
        int result = -1;

        int low = 1; // min distance between two cows
        int high = stalls.get(stalls.size() - 1) - stalls.get(0); // max distance between two cows

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(stalls, k, mid)) {
                result = mid;
                low = mid + 1; // maximize the min distance
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // helper function to check the possibility
    public boolean isPossible(ArrayList<Integer> stalls, int k, int minDistance) {
        int cows = 1;
        int lastPosition = stalls.get(0);

        for (int i = 1; i < stalls.size(); i++) {
            if (stalls.get(i) - lastPosition >= minDistance) {
                cows++;
                lastPosition = stalls.get(i);
            }
        }

        return cows >= k;
    }
}
