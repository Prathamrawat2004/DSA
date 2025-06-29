package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FindPermutation {
    public ArrayList<Integer> findPerm(final String A, int B) {
        // resultant arraylist
        ArrayList<Integer> resultant = new ArrayList<>(Collections.nCopies(B, 0));

        // base case
        if (A == "" || A.length() == 0) {
            return resultant; // no permutation possible
        }

        int left = 1, right = B;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'I') {
                resultant.set(i, left++);
            } else {
                resultant.set(i, right--);
            }
        }

        // setting the last position
        resultant.set(B - 1, left);

        return resultant;

    }
}
