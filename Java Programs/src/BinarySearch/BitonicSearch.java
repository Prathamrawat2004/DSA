package BinarySearch;
// revisions = 1
import java.util.*;

public class BitonicSearch {
    public int solve(ArrayList<Integer> A, int B) {
        // getting the size of given arraylist
        int N = A.size();

        // finding the bitonic(peak) element's index
        int bitonicpt = findBitonic(A);

        // search in the increasing part
        int idx = BinarySearcher(A, 0, bitonicpt, B, true);
        if (idx != -1) {
            return idx;
        }

        return BinarySearcher(A, bitonicpt + 1, N - 1, B, false);
    }

    // helper function to find the bitonic point
    public int findBitonic(ArrayList<Integer> list) {
        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) < list.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // helper function to perform binary search
    public int BinarySearcher(ArrayList<Integer> A, int start, int end, int B, boolean increasing) {
        int low = start, high = end;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (increasing) {
                if (A.get(mid) == B) {
                    return mid;
                } else if (A.get(mid) < B) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (A.get(mid) == B) {
                    return mid;
                } else if (A.get(mid) < B) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        // no element found
        return -1;
    }
}
