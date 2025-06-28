package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class SortWithSquares {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        // size of array
        int n = A.size();

        // resultant arraylist
        ArrayList<Integer> resultant = new ArrayList<>(Collections.nCopies(n, 0));

        // base condition
        if (n == 1) {
            resultant.add(A.get(0) * A.get(0));
            return resultant;
        }

        // initializing pointers
        int left = 0;
        int right = n - 1;
        int k = n - 1; // resultant array's indexing

        while (left <= right) {
            int leftValue = A.get(left) * A.get(left);
            int rightValue = A.get(right) * A.get(right);

            if (leftValue >= rightValue) {
                resultant.set(k, leftValue);
                left++;
            } else {
                resultant.set(k, rightValue);
                right--;
            }

            // modifying the resultant index
            k--;

        }

        return resultant;
    }
}
