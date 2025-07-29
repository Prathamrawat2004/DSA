package Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveMinElements {
    // brute force solution
    public int minRemove(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length;
        int m = arr2.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr1[i] == arr1[i - 1])
                continue; // skip duplicates

            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j]) {
                    count++;
                    break; // found a match, move to next unique element
                }
            }
        }

        return count;

    }

    // optimized solution
    public int minRemove2(int[] arr1, int[] arr2) {
        // storing the elements of arr1 in hashset
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }

        int count = 0;

        // hashset to check duplicates
        HashSet<Integer> seen = new HashSet<>();

        // finding the common elements in second array
        for (int num : arr2) {
            if (set.contains(num) && !seen.contains(num)) {
                count++;
                seen.add(num);
            }
        }

        return count;
    }
}
