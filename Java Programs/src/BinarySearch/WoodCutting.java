package BinarySearch;

import java.util.*;

public class WoodCutting {
    public int solve(ArrayList<Integer> A, int B) {
        // using the binary search
        int low = 0, high = 0;
        int result = -1;

        // getting the max height
        for(int height: A){
            high = Math.max(height, high);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(A, mid, B)) {
                result = mid;
                low = mid + 1; // check for more greater height
            } else {
                high = mid - 1; // lower the height of the tree
            }

        }

        return result;
    }

    // helper function definition
    public boolean isPossible(ArrayList<Integer> A, int SawHeight, int B) {
        long wood = 0; // wood to get

        for (int height : A) {
            if (height > SawHeight) {
                wood += (height - SawHeight); // add the wood cut from each tree
            }
        }

        return (wood >= B);
    }
}
