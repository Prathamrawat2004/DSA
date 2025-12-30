package BinarySearch;
// revisions = 2
import java.util.*;

// considering the arraylist is SORTED & contains no DUPLICATE elements
public class Algorithm {
    public int BinarySearch(ArrayList<Integer> A, int B) {
        int low = 0, high = A.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A.get(mid) == B) {
                // no duplicate elements, hence there will be only one element
                // if arraylist had duplicate then shrink the size by high = mid - 1

                return mid;

            } else if (A.get(mid) < B) {
                // shrink the size to greater as the list is sorted
                low = mid + 1;

            } else {
                // shrink the size to smaller part as list is sorted
                high = mid - 1;
            }
        }

        // if the target is not found
        return -1;

    }
}
