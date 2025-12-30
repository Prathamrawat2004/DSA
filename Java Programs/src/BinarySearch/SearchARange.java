package BinarySearch;
// revisions = 2
import java.util.*;

public class SearchARange {
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int B) {
        // resultant arraylist
        ArrayList<Integer> resultant = new ArrayList<>();
        resultant.add(findStart(A, B));
        resultant.add(findEnd(A, B));
        return resultant;
    }

    // function to return start
    public int findStart(ArrayList<Integer> A, int B) {
        // using binary search
        int low = 0, high = A.size() - 1;
        int start = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == B) {
                start = mid;
                high = mid - 1; // search left
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return start;
    }

    // function to return end
    public int findEnd(ArrayList<Integer> A, int B) {
        // using binary search
        int low = 0, high = A.size() - 1;
        int end = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == B) {
                end = mid;
                low = mid + 1; // search right
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return end;
    }
}
