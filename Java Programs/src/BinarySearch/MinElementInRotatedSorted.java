package BinarySearch;

import java.util.*;

public class MinElementInRotatedSorted {
    public int findMin(final List<Integer> a) {
        int low = 0, high = a.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            // if the array is rotated
            if (a.get(mid) > a.get(high)) {
                // min value is towards right
                low = mid + 1;
            } else {
                // if array is not rotated or
                // rotated in a way it becomes original sorted
                high = mid;
            }
        }

        return a.get(low);
    }
}
