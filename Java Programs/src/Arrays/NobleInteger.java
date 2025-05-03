package Arrays;

import java.util.*;

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        // sorting the current list
        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            // avoiding the duplicates
            if (i < A.size() - 1 && A.get(i) == A.get(i + 1)) {
                continue;

            }

            // counting the number of elements in ahead from current element
            if (A.get(i) == A.size() - 1 - i) {
                return 1;
            }

        }

        return -1;

    }
}
