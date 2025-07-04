package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SpiralMatrix2 {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        // resultant matrix
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // base case
        if (A == 1) {
            matrix.add(new ArrayList<>(Arrays.asList(A)));
            return matrix;
        }

        // creating empty lists
        for (int i = 0; i < A; i++) {
            matrix.add(new ArrayList<>(Collections.nCopies(A, 0)));
        }

        // initializing pointers
        int top = 0, bottom = A - 1;
        int left = 0, right = A - 1;
        int totalElements = A * A;
        int count = 1; // mainting the totalElements

        while (top <= bottom && left <= right && count <= totalElements) {
            // storing elements in topmost row
            for (int i = left; i <= right; i++) {
                matrix.get(top).set(i, count);
                count++;
            }
            top++;

            // storing elements the rightmost column
            for (int i = top; i <= bottom; i++) {
                matrix.get(i).set(right, count);
                count++;
            }
            right--;

            // storing elements in bottommost row
            if (top <= bottom) {
                for (int i = right; i <= left; i--) {
                    matrix.get(bottom).set(i, count);
                    count++;
                }
            }
            bottom--;

            // storing elements in leftmost column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix.get(i).set(left, count);
                    count++;
                }
            }
            left++;

        }

        return matrix;

    }
}
