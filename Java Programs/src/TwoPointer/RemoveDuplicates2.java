package TwoPointer;

import java.util.*;

// removing duplicates more than 2

public class RemoveDuplicates2 {
    public int remove(ArrayList<Integer> A) {
        // base condition
        if (A.size() <= 1) {
            return A.size();
        }

        // the first two elements would always be there
        int j = 2;

        for (int i = 2; i < A.size(); i++) {
            if (!A.get(i).equals(A.get(j - 2))) {
                A.set(j, A.get(i));
                j++;
            }

        }

        return j;
    }
}
