package Arrays;
// revisions = 1
import java.util.ArrayList;
import java.util.Collections;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        // resultant arraylist
        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>();

        // base case
        if (A == 0) {
            return pascalTriangle;
        }

        // adding rows inside the pascal triangle list
        // 0 based indexing
        for (int i = 0; i < A; i++) {
            // row to be added
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 0));

            // first element would always be 1
            row.set(0, 1);

            // setting middle elements
            for (int j = 1; j < i; j++) {
                row.set(j, pascalTriangle.get(i - 1).get(j - 1) + pascalTriangle.get(i - 1).get(j));
            }

            // last element would always be 1
            row.set(i, 1);
        }

        return pascalTriangle;
    }
}
