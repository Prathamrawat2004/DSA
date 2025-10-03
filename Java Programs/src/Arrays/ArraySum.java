package Arrays;
// revisions = 1
import java.util.ArrayList;
import java.util.Collections;

public class ArraySum {
    public ArrayList<Integer> addArrays(ArrayList<Integer> A, ArrayList<Integer> B) {
        // resultant array
        ArrayList<Integer> resultant = new ArrayList<>();

        // pointers for addition operation
        int m = A.size(), n = B.size(); // sizes of individual arrays
        int sum = 0; // calculating the individual sum
        int i = m - 1, j = n - 1; // pointing one's digit
        int carry = 0; // carry digit

        while (i >= 0 || j >= 0 || carry > 0) {
            // starting with carry
            sum = carry;

            // adding A's digit
            if (i >= 0) {
                sum += A.get(i);
                i--;
            }

            // adding B's digit
            if (j >= 0) {
                sum += B.get(j);
                j--;
            }

            // setting the resultant list
            resultant.add(sum % 10);

            // setting the carry digit
            carry = sum / 10;
        }

        Collections.reverse(resultant);

        return resultant;

    }
}
