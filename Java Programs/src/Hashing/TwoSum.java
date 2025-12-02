package Hashing;

import java.util.*;

public class TwoSum {
    public List<Integer> twoSumProblem(int[] nums, int target) {
        // map to store the indices a values of element
        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (map.containsKey(need)) {
                result.add(map.get(need)); // index of 1st element
                result.add(i); // index of 2nd element 
                return result;
            }

            // storing index of ith element
            map.put(nums[i], i);
        }

        return result;
    }
}
