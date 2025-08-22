package BinarySearch;
// revisions = 1
import java.util.*;

public class SortedInsetPosition {
    public int searchInsert(ArrayList<Integer> a, int b) {
        int low = 0, high = a.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) < b) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // if target not found
        return low;
    }
}
