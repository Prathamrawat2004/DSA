package Arrays;

import java.util.ArrayList;
// revisions = 1
public class MinSteps {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B){
        // getting the size of given array
        int n = A.size();

        // total number of steps to reach from starting point to ending point
        int totalSteps = 0;

        for(int i = 0; i < n - 1; i++){
            // getting the two points
            int x1 = A.get(i), y1 = B.get(i);
            int x2 = A.get(i + 1), y2 = B.get(i + 1);

            // minimum number of steps is achieved via moving diagonally
            int diagonalSteps = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));

            totalSteps += diagonalSteps;

        }

        return totalSteps;
    }
}
