package BinarySearch;

import java.util.*;

public class MatrixMedian {
    public double findMedian(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size(), cols = A.get(0).size();
        int totalElements = rows * cols;

        // finding the min and max values to set low and high for binary search
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            min = Math.min(A.get(i).get(0), min);
            max = Math.max(A.get(i).get(cols - 1), max);
        }

        // as even number of elements
        // here the totalElements / 2 or totalElements / 2 + 1 are the desired positions
        // of median in a linearly sorted array
        int median1 = findKthSmallest(A, min, max, (totalElements / 2));
        int median2 = findKthSmallest(A, min, max, (totalElements / 2) + 1);

        return ((median1 + median2) / 2.0);

    }

    // helper function to find kth smallest
    public int findKthSmallest(ArrayList<ArrayList<Integer>> A, int min, int max, int k) {
        int rows = A.size();

        while (min < max) {
            int mid = min + (max - min) / 2;

            int count = 0; // counting the number of elements smaller than target because the median is Kth
                           // smallest number
            for (int i = 0; i < rows; i++) {
                count += countSmallerOrEqualTo(A.get(i), mid);
            }

            if (count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }

        }

        return min;
    }

    public int countSmallerOrEqualTo(ArrayList<Integer> rows, int target) {
        int low = 0, high = rows.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (rows.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

}
