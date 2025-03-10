package BinarySearch;

import java.util.*;

public class RotatedSortedSearch {
    public int search(final List<Integer> A, int B) {
        int low = 0, high = A.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // if the mid is target
            if (A.get(mid) == B)
                return mid;

            // search in sorted part
            if (A.get(low) <= A.get(mid)) {
                // left half sorted
                if (A.get(low) <= B && B < A.get(mid)) {
                    // search in left half
                    high = mid - 1;
                } else {
                    // search in right half
                    low = mid + 1;
                }

            } else {
                // right half sorted
                if (A.get(mid) < B && B <= A.get(high)) {
                    // search in right half
                    low = mid + 1;
                } else {
                    // search in left half
                    high = mid - 1;
                }

            }
        }

        // if element not found
        return -1;
    }
}
