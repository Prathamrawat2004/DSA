package BinarySearch;
// revisions = 1
import java.util.*;

public class CountElementOccurence {
    public int findCount(final List<Integer> A, int B) {
        // getting the starting index of the req element
        int start = findStart(A, B);
        int end = findEnd(A, B);

        // counting the number of occurences
        int occurences = (end - start) + 1;

        return occurences;

    }

    // helper function to get the starting index
    public int findStart(List<Integer> A, int B) {
        int low = 0, high = A.size() - 1;
        int start = -1;

        // binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A.get(mid) == B) {
                // got the initial start
                start = mid;

                // checking if start could be found on the left side also
                high = mid - 1;

            } else if (A.get(mid) < B) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }

        return start;
    }

    // helper function to get the end index
    public int findEnd(List<Integer> A, int B) {
        int low = 0, high = A.size() - 1;
        int end = -2; // so that occurences could become 0 in case no element found

        // binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A.get(mid) == B) {
                // got the initial start
                end = mid;

                // checking if start could be found on the left side also
                low = mid + 1;

            } else if (A.get(mid) < B) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }

        return end;
    }
}
