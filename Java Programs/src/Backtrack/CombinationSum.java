package Backtrack;
import java.util.*;

// number can we repeated to form combinations
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> CombinationSum(ArrayList<Integer> A, int B){
        // resultant arraylist
        ArrayList<ArrayList<Integer>> resultant = new ArrayList<>();

        // sorting the given list 
        Collections.sort(A);

        // function to generate combinations
        generateCombinations(A, B, 0, new ArrayList<>(), resultant);

        return resultant;
    }

    // helper function to generate desired combinations
    public void generateCombinations(ArrayList<Integer> A, int target, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> resultant){
        // base condition
        if(target == 0){
            resultant.add(path);
            return;
        }

        // target might go negative
        if(target < 0){
            return;
        }

        for(int i = start; i < A.size(); i++){
            // avoid consecutive elements
            if(i > start && A.get(i).equals(A.get(i - 1))){
                // skip that element
                continue;
            }

            // add it to the path
            path.add(A.get(i));

            // call recursion 
            generateCombinations(A, target - A.get(i), i, path, resultant);

            // backtracking to allow other elements as well
            path.remove(path.size() - 1);
        }
    }
}
