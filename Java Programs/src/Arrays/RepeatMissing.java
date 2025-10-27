package Arrays;
// revisions = 1
import java.util.ArrayList;
import java.util.List;

public class RepeatMissing {
    public ArrayList<Integer> RepeatedNum(final List<Integer> A) {
        // size of current arraylist
        int N = A.size();

        // resultant list
        ArrayList<Integer> resultant = new ArrayList<>();

        // sum of first N natural numbers
        long SumN = N * (N + 1) / 2;

        // sum of square of first N natural numbers
        long SumNSquare = (N * (N + 1) * (2 * N + 1)) / 6;

        // pointers for curent sum and square
        long SumA = 0, SumSquareA = 0;

        // calculating the sum & sumsquare of current list of first N natural numbers
        for (int num : A) {
            SumA += (long) num;
            SumSquareA += (long) (num * num);
        }

        // calculating the difference between the actual & current sum
        long diff1 = SumN - SumA; // A - B
        long diff2 = SumNSquare - SumSquareA; // A^2 - B^2

        // using the identity
        long sumReq = diff2 / diff1;

        int missing = (int) (sumReq + diff1) / 2;
        int repeating = (int) (missing - diff1);

        // adding to the result list
        resultant.add(repeating);
        resultant.add(missing);

        return resultant;

    }
}
