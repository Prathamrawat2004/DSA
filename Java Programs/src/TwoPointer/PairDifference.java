package TwoPointer;

import java.util.ArrayList;
import java.util.HashSet;
// revisions = 1
public class PairDifference {
    // brute force approach
    public int Solve1(ArrayList<Integer> A, int B){
        int n = A.size();

        // base condition
        if(n < 2){
            return 0; // no pair possible with just 1 element
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(A.get(j) - A.get(i) == B){
                    return 1;
                }
            }
        }

        // no pair found
        return 0;
    }

    // optimized approach
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
