package TwoPointer;

import java.util.*;
// revisions = 1
// removing duplicates more than 2

public class RemoveDuplicates2 {

    // brute force approach
    public int remove1(ArrayList<Integer> A) {
        // base condition
        if (A.size() <= 2) {
            return A.size();
        }

        int i = 0;
        while (i < A.size()) {
            int count = 0, j = i;

            while (j < A.size() && A.get(j).equals(A.get(i))) {
                count++;
                j++;
            }

            while (count > 2) {
                j--;
                A.remove(j);
                count--;
            }

            i = j; // Safely move i to the next group start
        }

        return A.size();

    }

    // optimized approach
    public int remove(ArrayList<Integer> A) {
        // base condition
        if (A.size() <= 2) {
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
