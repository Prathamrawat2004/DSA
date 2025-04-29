package Arrays;

import java.util.*;

public class MaxSumSubarray {
    public ArrayList<Integer> maxSet(ArrayList<Integer> A) {
        // resultant arraylist
        ArrayList<Integer> result = new ArrayList<>();

        // pointers for finding max sum subarray of non-negative elements
        long currentSum = 0; // for current subarray sum
        long maxSum = 0; // for max subarray sum
        int start = 0, end = 0; // for current subarray
        int maxStart = -1, maxEnd = -1; // for max subarray

        // traversing the given list
        for (int i = 0; i < A.size(); i++) {
            // if current index has positive element
            if (A.get(i) > 0) {
                currentSum += A.get(i);
                end = i;
            } else {
                // negative element found
                if ((currentSum > maxSum) || ((currentSum == maxSum) && (end - start) > (maxEnd - maxStart))
                        || ((currentSum == maxSum) && (end - start) == (maxEnd - maxStart) && (start < maxStart))) {
                    maxSum = currentSum;
                    maxStart = start;
                    maxEnd = end;
                }
                start = i + 1;
                currentSum = 0; // for processing next non-negative subarray
            }
        }

        // if last element is not negative, i.e, processing last subarray
        if ((currentSum > maxSum) || ((currentSum == maxSum) && (end - start) > (maxEnd - maxStart))
                || ((currentSum == maxSum) && (end - start) == (maxEnd - maxStart) && (start < maxStart))) {
            maxStart = start;
            maxEnd = end;
        }

        // storing inside the resultant list
        if (maxStart != -1) {
            for (int i = maxStart; i <= maxEnd; i++) {
                result.add(A.get(i));
            }
        }

        return result;

    }
}
