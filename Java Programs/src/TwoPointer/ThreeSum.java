package TwoPointer;

import java.util.*;
// revisions = 1
public class ThreeSum {
    // brute force approach
    public int threeSumClosest1(ArrayList<Integer> A, int B) {
        // size of the given arraylist
        int n = A.size();

        // base condition
        if (n < 3) {
            return 0;
        }

        // initial closest sum
        int closestSum = A.get(0) + A.get(1) + A.get(2);

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int currentSum = A.get(i) + A.get(j) + A.get(k);

                    // checking if the currentsum is closer or earlier closest sum
                    // can be both greater or smaller than B
                    if (Math.abs(currentSum - B) < Math.abs(closestSum - B)) {
                        // updating the closest sum
                        closestSum = currentSum;
                    }

                }
            }
        }

        return closestSum;
    }

    // optmized approach
    // check triangles as well
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        // getting the size
        int n = A.size();

        // base condition
        if (n < 3)
            return 0; // ask the interviewer

        // sorting
        Collections.sort(A);

        // initial closest sum
        int closestSum = A.get(0) + A.get(1) + A.get(2);

        // sliding window approach
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = A.get(i) + A.get(left) + A.get(right);

                if (currentSum == B) {
                    return currentSum;
                }

                // checking the closeness of current value
                if (Math.abs(currentSum - B) < Math.abs(closestSum - B)) {
                    closestSum = currentSum;
                }

                // moving pointers
                if (currentSum < B) {
                    // increase the sum
                    left++;
                } else {
                    right--;
                }
            }

        }
        return closestSum;
    }
}
