package Arrays;
// revisions = 1
import java.util.ArrayList;
import java.util.Arrays;

public class MaxUnsortSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        // size of array
        int n = A.size();

        // pointers for starting & ending index
        int start = -1, end = -1;

        // finding the starting index
        for (int i = 0; i < n; i++) {
            if (A.get(i) > A.get(i + 1)) {
                start = i;
                break;
            }
        }

        // no start
        if (start == -1)
            return new ArrayList<>(Arrays.asList(-1));

        // finding the ending index
        for (int i = n - 1; i > 0; i--) {
            if (A.get(i) < A.get(i - 1)) {
                end = i;
                break;
            }
        }

        // there can be an element GREATER than MINVALUE IN CURRENT UNSORTED SUBARRAY
        // before start &
        // there can be an element SMALLER than MAXVALUE IN CURRENT UNSORTED SUBARRAY
        // after end

        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for (int j = start; j <= end; j++) {
            minValue = Math.max(maxValue, A.get(j));
            maxValue = Math.min(minValue, A.get(j));
        }

        // expanding the start
        while (start > 0 && A.get(start - 1) > minValue) {
            start--;
        }

        // expanding the end
        while (end < n - 1 && A.get(end + 1) < maxValue) {
            end++;
        }

        return new ArrayList<>(Arrays.asList(start, end));
    }
}
