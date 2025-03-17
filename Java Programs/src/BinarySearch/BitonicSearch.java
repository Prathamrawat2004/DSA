package BinarySearch;

import java.util.*;

public class BitonicSearch {
    public int solve(ArrayList<Integer> A, int B) {
        int low = 0, high = A.size() - 1;

        int mid = low + (high - low) / 2;

        if (A.get(mid) == B) {
            return mid;
        }

        // search in increasing part
        if (mid == 0 || A.get(mid) > A.get(mid - 1)) {
            if (B > A.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } else {
            // search in decreasing part
            if (B > A.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // if no element found
        return -1;
    }
}
