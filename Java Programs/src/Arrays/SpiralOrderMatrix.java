package Arrays;

import java.util.*;

public class SpiralOrderMatrix {
    public ArrayList<Integer> spiralOrder(final List<List<Integer>> A) {
        // resultant arraylist
        ArrayList<Integer> result = new ArrayList<>();

        int rows = A.size(), cols = A.get(0).size();

        // initializing pointers
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // printing topmost row
            for (int i = left; i <= right; i++) {
                result.add(A.get(top).get(i));
            }
            top++;

            // printing rightmost column
            for (int i = top; i <= bottom; i++) {
                result.add(A.get(i).get(right));
            }
            right--;

            // printing bottommost row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(A.get(bottom).get(i));
                }
                bottom--;
            }

            // printing rightmost column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(A.get(i).get(left));
                }
                left++;
            }

        }

        return result;
    }
}
