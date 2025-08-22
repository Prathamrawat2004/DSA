package BinarySearch;
// revisions = 1
import java.util.ArrayList;

public class SmallerOrEqualElement {
    public int solve(ArrayList<Integer> A, int B){
        int low = 0, high = A.size() - 1;
        int result = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(A.get(mid) <= B){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return result + 1;
    }
}
