package BinarySearch;

import java.util.ArrayList;

public class PainterPartition {
    public int Paint(int A, int B, ArrayList<Integer> C) {
        int max = 0, sum = 0;
        int mod = 10000003;

        // getting the max element
        max = getMax(C);

        // getting the sum of given arraylist
        sum = getSum(C);

        // using binary search
        long low = max * B; // min time req

        long high = sum * B; // max time req

        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(A, B, C, (int) mid)) {
                result = mid;
                high = mid - 1; // minimizing the time
            } else {
                low = mid + 1; // maximize the time
            }
        }

        return (int) (result % mod);
    }

    // helper function to check the possibility
    public boolean isPossible(int painters, int timePerUnit, ArrayList<Integer> C, int maxTime) {
        int count = 1; // for counting the painters
        long CurrentSum = 0; // counting the time for each painter

        for (int num : C) {
            long timeRequired = (long) (num * timePerUnit);

            if (CurrentSum + timeRequired > maxTime) {
                count++; // assign work to new painter
                CurrentSum = timeRequired;
                if (count > painters) {
                    return false;
                }
            } else {
                CurrentSum += timeRequired;
            }

        }

        return true;
    }

    // helper function to get max
    public int getMax(ArrayList<Integer> C) {
        int maxElement = C.get(0);

        for (int i = 1; i < C.size(); i++) {
            maxElement = Math.max(maxElement, C.get(i));
        }

        return maxElement;
    }

    // helper function to get sum
    public int getSum(ArrayList<Integer> C) {
        int sum = 0;

        for (int num : C) {
            sum += num;
        }

        return sum;
    }
}
