package Arrays;

import java.util.ArrayList;

public class MovingZerosToEnd {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        // getting the size of the given arraylist
        int n = A.size();

        // base case
        if (n == 1) {
            return A;
        }

        // initializing pointers
        int j = 0;
        int count = 0; // counting the number of zeros

        // inplace re-ordering
        for (int i = 0; i < n; i++) {
            if (A.get(i) == 0) {
                count++;
            } else {
                // setting the non-zero element before zero
                A.set(j, A.get(i));
                j++;
            }
        }

        // adding zeros to the end
        while (j < n && count != 0) {
            A.set(j, 0);
            j++;
            count--;

        }

        return A;
    }
}
