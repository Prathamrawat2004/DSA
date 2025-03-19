package Backtrack;

import java.util.ArrayList;

public class Combinations2 {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        // resultant arraylist
        ArrayList<ArrayList<Integer>> resultant = new ArrayList<>();

        // base condition
        if (A == 0) {
            return resultant; // as 0 is not a natural number
        }

        // function to generate req combinations
        generateCombinations(1, A, B, new ArrayList<>(), resultant);

        return resultant;
    }

    // helper function definition
    public void generateCombinations(int index, int A, int B, ArrayList<Integer> current,
            ArrayList<ArrayList<Integer>> resultant) {
        // base condition
        // B is acting as my count
        if (B == 0) {
            resultant.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i <= A; i++) {
            current.add(i);

            // recursion to generate further combinations
            generateCombinations(i + 1, A, B - 1, current, resultant);

            // backtracking condition
            current.remove(current.size() - 1);
        }
    }
}
