package TwoPointer;

import java.util.ArrayList;
// revisions = 1
public class MaximumOnes2 {
    // brute force approach
    public ArrayList<Integer> maxOnes1(ArrayList<Integer> A, int B) {
        int n = A.size();
        int bestStart = -1; // no best start initially
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            int zeroCount = 0;

            for (int j = i; j < n; j++) {
                if (A.get(j).equals(0)) {
                    zeroCount++;
                }

                if (zeroCount > B) {
                    break;
                }

                // keep updating maxlength & best starting index
                if ((j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    bestStart = i;
                }
            }
        }

        // build the resultant list
        ArrayList<Integer> resultant = new ArrayList<>();
        for (int k = bestStart; k < bestStart + maxLength; k++) {
            resultant.add(k);
        }

        return resultant;
    }

    // optimized approach
    public ArrayList<Integer> maxOnes(ArrayList<Integer> A, int B) {
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

            while (zeroCount > B && left <= right) {
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

        // resultant array
        ArrayList<Integer> resultant = new ArrayList<>();

        // adding the indexes to the resultant list
        for (int i = bestLeft; i < bestLeft + maxLength; i++) {
            resultant.add(i);
        }

        return resultant;
    }
}
