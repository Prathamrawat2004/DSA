package TwoPointer;

import java.util.ArrayList;

public class MaximumOnes2 {
    public ArrayList<Integer> maxOnes(ArrayList<Integer> A, int B) {
        // resultant array
        ArrayList<Integer> resultant = new ArrayList<>();

        // declaring pointers for sliding window
        int left = 0, zeroCount = 0;
        int bestLeft = 0; // for best starting index
        int maxLength = 0;

        // traversing the given array
        for (int right = 0; right < A.size(); right++) {
            // if the current index has 0
            if (A.get(right) == 0) {
                zeroCount++;
            }

            while (zeroCount > B) {
                if (A.get(left) == 0) {
                    zeroCount--;
                }
                left++;
            }

            // setting up the maxlength and starting index
            if (maxLength < right - left + 1) {
                maxLength = right - left + 1;
                bestLeft = left;
            }
        }

        // adding the indexes to the resultant list
        for (int i = bestLeft; i < bestLeft + maxLength; i++) {
            resultant.add(i);
        }

        return resultant;
    }
}
