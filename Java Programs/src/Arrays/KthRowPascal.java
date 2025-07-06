package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class KthRowPascal {
    public ArrayList<Integer> getRow(int A) {
        // resultant arraylist
        ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(A + 1, 0));

        // the first value will always be 1
        // also corresponds to first row of pascal triangle
        row.set(0, 1);

        // finding the required row by creating rows
        for (int i = 1; i <= A; i++) {

            // from right to left
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;

    }

}
