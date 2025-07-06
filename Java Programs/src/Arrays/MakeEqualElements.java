package Arrays;

import java.util.ArrayList;

public class MakeEqualElements {
    public int solve(ArrayList<Integer> A, int B){
        // base case
        if(A.size() == 1){
            return 1;
        }

        // getting the targets to achieve
        // optimizing by reducing the search from N to 3 targets
        int[] targets = {A.get(0), A.get(0) - B, A.get(0) + B};

        for(int target: targets){
            Boolean possible = true;

            // checking if every integer can get to target by +B or -B or nothing
            for(int i = 0; i < A.size(); i++){
                int num = A.get(i);
                if(!(num == target || num - B == target || num + B == target)){
                    possible = false;
                    break;
                }
            }

            if(possible) return 1;
        }

        return 0; // cannot make equal


    }
}
