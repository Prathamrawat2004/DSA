package Arrays;

import java.util.ArrayList;

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        // getting the size of matrix
        int N = a.size();

        // base case
        if (N == 1) {
            return;
        }

        // declaring pointers for matrix rotation
        int rows = N, cols = N;
        int top = 0, bottom = (rows - 1);
        int left = 0, right = (cols - 1);

        while (top < bottom) {
            for (int i = left; i <= right; i++) {
                swap(a, top, i, bottom, i);
            }
            top++;
            bottom--;
        }

        // symmetricity (only swap upper triangle)
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                swap(a, i, j, j, i);
            }
        }
    }

    // helper function to swap
    public void swap(ArrayList<ArrayList<Integer>> a, int i, int j, int x, int y) {
        int temp = a.get(i).get(j);
        a.get(i).set(j, a.get(x).get(y));
        a.get(x).set(y, temp);
    }
}
