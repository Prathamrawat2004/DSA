package Arrays;
// revisions = 1
import java.util.*;
import java.util.Arrays;

public class AddingOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        // removing the leading zeros from the output
        while (A.size() > 1 && A.get(0) == 0) {
            A.remove(0);
        }

        // getting the size again
        int n = A.size();
        int i = n - 1;

        while (i >= 0) {
            if (A.get(i) < 9) {
                A.set(i, A.get(i) + 1);
                return A;
            } else {
                A.set(i, 0);
                i--;
            }
        }

        // if all the digits were 9
        A.add(0, 1);
        return A;
    }

}
