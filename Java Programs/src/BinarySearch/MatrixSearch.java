package BinarySearch;

import java.util.*;

public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int rows = A.size(), cols = A.get(0).size();

        // as every row is sorted &
        // Last row's last integer <= Next row's first integer
        int low = 0;
        int high = (rows * cols) - 1;

        // assuming the 2d array as 1d array
        while (low <= high) {
            int mid = low + (high - low) / 2; // linear format

            // locating this mid in 2d array given
            int midValue = A.get(mid / cols).get(mid % cols);

            if (midValue == B) {
                return 1;
            } else if (midValue < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // if not found
        return 0;
    }
}
