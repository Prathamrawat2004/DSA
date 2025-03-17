package Backtrack;

import java.util.*;

public class Permutation {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // resultant arraylist
        ArrayList<ArrayList<Integer>> resultant = new ArrayList<>();

        // base condition
        if (nums == null || nums.isEmpty()) {
            return resultant;
        }

        // function to generate permutations
        generatePermutations(nums, 0, resultant);

        return resultant;
    }

    public void generatePermutations(ArrayList<Integer> A, int index, ArrayList<ArrayList<Integer>> resultant) {
        // base condition
        if (index == A.size()) {
            resultant.add(new ArrayList<>(A));
            return;
        }

        for (int i = index; i < A.size(); i++) {
            swap(A, i, index);

            generatePermutations(A, index + 1, resultant);

            // backtracking
            swap(A, i, index);
        }
    }

    // function for swapping
    public void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
