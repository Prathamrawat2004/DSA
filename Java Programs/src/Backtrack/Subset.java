package Backtrack;

import java.util.*;

public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // resultant arraylist
        ArrayList<ArrayList<Integer>> resultant = new ArrayList<>();

        // sorting the given arraylist to maintain lexicographicity
        Collections.sort(A);

        // helper function to generate subsets
        generateSubsets(A, 0, new ArrayList<>(), resultant);

        return resultant;
    }

    // helper function definition
    public void generateSubsets(ArrayList<Integer> A, int index, ArrayList<Integer> processed,
            ArrayList<ArrayList<Integer>> resultant) {
        // adding the empty sublist + other from recursions
        resultant.add(new ArrayList<>(processed));

        for (int i = 0; i < A.size(); i++) {
            processed.add(A.get(i));

            // recursively adding other elements
            generateSubsets(A, i + 1, processed, resultant);

            // backtrack
            processed.remove(processed.size() - 1);
        }

    }
}
