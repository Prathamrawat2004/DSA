package RECURSION.Backtracking;

import java.util.ArrayList;

public class Permutation {
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.isEmpty()) {
            return result;
        }

        // Helper function to generate permutations
        generatePermutations(nums, 0, result);
        return result;
    }

    private static void generatePermutations(ArrayList<Integer> nums, int index, ArrayList<ArrayList<Integer>> result) {
        // Base case: If index is at the end of the array, we've formed a valid
        // permutation
        if (index == nums.size()) {
            result.add(new ArrayList<>(nums)); // Add a copy of the current permutation
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            // Swap the current element with the element at the index
            swap(nums, i, index);

            // Recurse for the next index
            generatePermutations(nums, index + 1, result);

            // Backtrack to restore the original order
            swap(nums, i, index);
        }
    }

    private static void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        resultList = permute(nums);
        System.out.println(resultList);

    }

}