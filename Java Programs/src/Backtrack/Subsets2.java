package Backtrack;

import java.util.*;

public class Subsets2 {
    public ArrayList<ArrayList<Integer>> subsetII(ArrayList<Integer> A) {
        // resultant array
        ArrayList<ArrayList<Integer>> resultant = new ArrayList<>();

        // sorting the given array for ascending subsets
        Collections.sort(A);

        // function to generate subsets
        generateSubsets(A, 0, new ArrayList<>(), resultant);

        return resultant;
    }

    // function to generate subsets
    public void generateSubsets(ArrayList<Integer> A, int index, ArrayList<Integer> processed,
            ArrayList<ArrayList<Integer>> resultant) {
        // adding the current processed list
        resultant.add(new ArrayList<>(processed));

        for (int i = index; i < A.size(); i++) {
            // skipping the duplicates
            if (i > index && A.get(i).equals(A.get(i - 1)))
                continue;

            processed.add(i);

            // recursively adding the other items
            generateSubsets(A, i + 1, processed, resultant);

            // backtracking
            processed.remove(processed.size() - 1);
        }
    }
}
