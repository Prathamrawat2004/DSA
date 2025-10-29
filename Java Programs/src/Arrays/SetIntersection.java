package Arrays;
// revisions = 1
import java.util.*;

public class SetIntersection {
    public int setIntersection(ArrayList<ArrayList<Integer>> A) {
        // sorting the given list
        Collections.sort(A, (ArrayList<Integer> a, ArrayList<Integer> b) -> {
            // sort on the basis of end, otherwise start
            return (a.get(1) != b.get(1)) ? (a.get(1) - b.get(1)) : (a.get(0) - b.get(0));
        });

        // declaring pointers
        int S_size = 0, largest = -1, second = -1;
        for (ArrayList<Integer> interval : A) {
            int a = interval.get(0), b = interval.get(1);

            boolean is_largest_in = (a <= largest);
            boolean is_second_in = (a <= second);

            // if both largest and second_largest present in current interval
            if (is_largest_in && is_second_in){
                continue; // skip current interval
            }

            // setting the size of S set
            S_size += (is_largest_in ? 1 : 2);

            // setting the new largest and second_largest
            second = (is_largest_in ? largest: b - 1);
            largest = b;


        }

        return S_size;

    }
}
