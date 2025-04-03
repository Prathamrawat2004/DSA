package BinarySearch;

import java.util.*;

public class Median {
    public double findMedian(final ArrayList<Integer> A, final ArrayList<Integer> B) {
        // base condition
        if (A.isEmpty() && B.isEmpty()) {
            return 0.0;
        }

        // combined list
        ArrayList<Integer> merged = new ArrayList<>();

        // adding elements
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                merged.add(A.get(i));
                i++;
            } else {
                merged.add(B.get(j));
                j++;
            }
        }

        // if remaining elements in any array
        while (i < A.size()) {
            merged.add(A.get(i));
            i++;
        }
        while (j < B.size()) {
            merged.add(B.get(j));
            j++;
        }

        int totalElements = merged.size();

        if (totalElements % 2 == 1) {
            // odd number of elements
            return (double) merged.get(totalElements / 2);
        } else {
            // even number of elements
            // 0 based indexing
            return (double) (merged.get(totalElements / 2 - 1) + merged.get(totalElements / 2)) / 2;
        }
    }
}
