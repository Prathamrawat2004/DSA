package Arrays;
// revisions = 1
import java.util.ArrayList;

public class BalanceArray {
    public int solve(ArrayList<Integer> A) {
        // getting the size of array
        int N = A.size();

        // base condition
        if (N == 1){
            return 0;
        }
        
        // declaring pointers
        long totalEven = 0, totalOdd = 0;
        long leftEven = 0, leftOdd = 0;
        long newEvenSum = 0, newOddSum = 0;
        int specialCount = 0;

        // calculating the total sum at even & odd indices
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                totalEven += A.get(i);
            } else {
                totalOdd += A.get(i);
            }
        }

        // counting the special elements by removing from every index & calculating the
        // even and odd sum
        for (int j = 0; j < N; j++) {
            int curr = A.get(j);

            // removing the current element
            if (j % 2 == 0) {
                totalEven -= curr;
            } else {
                totalOdd -= curr;
            }

            // checking the even & odd sum
            newEvenSum = leftEven + totalOdd;
            newOddSum = leftOdd + totalEven;

            if (newEvenSum == newOddSum) {
                specialCount++;
            }

            // updating the lefteven & leftodd values as we move forward to process new
            // elements
            if (j % 2 == 0) {
                leftEven += curr;
            } else {
                leftOdd += curr;
            }
        }

        return specialCount;
    }
}
