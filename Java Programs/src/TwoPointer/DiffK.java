package TwoPointer;

import java.util.*;
// revisions = 1
public class DiffK {
    // brute force approach
    public int diffPossible1(ArrayList<Integer> A, int B){
        // getting the size of arraylist
        int n = A.size();

        // base condition
        if(n < 2){
            return 0;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && A.get(i) - A.get(j) == B){
                    return 1;
                }
            }
        }

        // no difference possible
        return 0;
        
    }

    // optimized approach
    public int diffPossible(ArrayList<Integer> A, int B) {
        // using sliding window approach
        int left = 0, right = 1;

        // why the condition should not be (left < right): [1,3,3,5], B = 0
        // apply algo using above example
        while (right < A.size()) {
            if (left == right) {
                right++;
                continue; // as i != j
            }

            int diff = A.get(right) - A.get(left);

            if (diff == B) {
                return 1;

            } else if (diff < B) {

                // increase difference
                right++;

            } else {
                // decrease difference
                left++;
            }
        }

        return 0;
    }

    // second approach
    public int diffPossible2(ArrayList<Integer> A, int B) {
        // implementing hashset
        HashSet<Integer> set = new HashSet<>();

        // storing the values of arraylist in this set
        for (int i = 0; i < A.size(); i++) {
            // if the set contains value, return 1
            if (set.contains(A.get(i) - B) || set.contains(A.get(i) + B)) {
                return 1;
            }

            set.add(A.get(i));
        }

        // if no indices possible
        return 0;
    }
}
