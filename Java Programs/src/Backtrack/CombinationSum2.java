package Backtrack;

import java.util.*;

// number should not be repeated in the combination
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        // resultant list
        ArrayList<ArrayList<Integer>> resultant = new ArrayList<>();

        // base condition
        if (a.isEmpty()) {
            return resultant;
        }

        // sorting the given array
        Collections.sort(a);

        // function to generate combinations
        generateCombinations(a, b, 0, new ArrayList<>(), resultant);

        return resultant;
    }

    // helper function definition
    public void generateCombinations(ArrayList<Integer> a, int target, int start, ArrayList<Integer> path,
            ArrayList<ArrayList<Integer>> resultant) {
        // base condition
        if (target == 0) {
            resultant.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < a.size(); i++) {
            // skipping the consecutive elements
            if (i > start && a.get(i).equals(a.get(i - 1))) {
                continue;
            }

            path.add(a.get(i));

            // call the recursion
            generateCombinations(a, target - a.get(i), i + 1, path, resultant);

            // backtrack
            path.remove(path.size() - 1);
        }
    }
}
