package Arrays;

import java.util.ArrayList;

public class NextPermutation {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();

        // base case
        if (n == 1) {
            // no permutation for single element
            return A;
        }

        // finding the element smaller than it's right element
        // also checking if the given array is descending
        int i = n - 2;
        while (i >= 0 && A.get(i) >= A.get(i + 1)) {
            i--;
        }

        // if the given array is not descending
        if (i >= 0) {
            // finding the element from the last just greater than current i'th element
            int j = n - 1;
            while (j >= 0 && A.get(i) >= A.get(j)) {
                j--;
            }

            swap(A, i, j);
        }

        // if the array is descending
        reverse(A, i + 1, n - 1);

        return A;
    }

    // helper function to swap
    public void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    // helper function to reverse
    public void reverse(ArrayList<Integer> A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }
}
