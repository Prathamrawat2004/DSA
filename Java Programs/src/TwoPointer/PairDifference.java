package TwoPointer;

import java.util.ArrayList;
import java.util.HashSet;

public class PairDifference {
    public int Solve(ArrayList<Integer> A, int B){
        // intializing the hashset
        HashSet<Integer> set = new HashSet<>();

        // traversing the arraylist
        for(int i = 0; i < A.size(); i++){
            // if the current set includes the element required to complete the pair
            if(set.contains(A.get(i) - B) || set.contains(A.get(i) + B)){
                return 1;
            }

            // adding the element after processing
            set.add(A.get(i));

        }

        // if no pair found 
        return 0;
    }
}
