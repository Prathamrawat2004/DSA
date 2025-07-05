package Arrays;

import java.util.ArrayList;

public class FirstMissingInteger {
    public int firstPositiveMissing(ArrayList<Integer> A) {
        // getting the size of given arraylist
        int N = A.size();

        // setting the positive elements of the given arraylist to desired positions
        // i.e similar to first N natural numbers
        for (int i = 0; i < N; i++) {
            while (A.get(i) > 0 && A.get(i) <= N && A.get(i) != A.get(A.get(i) - 1)) {
                // swapping elements
                int correctPos = A.get(i) - 1;
                int temp = A.get(i);
                A.set(i, A.get(correctPos));
                A.set(correctPos, temp);
            }
        }

        // finding the missing number
        for (int j = 0; j < N; j++) {
            if (A.get(j) != j + 1) {
                return j + 1;
            }
        }

        // everything's alright
        return N + 1;
    }
}
