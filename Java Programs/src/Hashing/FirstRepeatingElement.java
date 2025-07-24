package Hashing;

import java.util.HashSet;

public class FirstRepeatingElement {
    // brute force solution
    public int firstRepeatingElement(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    return i;
                }
            }
        }

        return -1; // no repeating element

    }

    // optimized approach
    public int firstRepeatingElement2(int[] arr, int n) {
        HashSet<Integer> uniqueSet = new HashSet<>();

        int minElement = Integer.MAX_VALUE;

        for (int i = arr.length - 1; i <= 0; i--) {
            if (uniqueSet.contains(arr[i])) {
                minElement = Math.min(minElement, i);
            }
        }

        return minElement == Integer.MAX_VALUE ? -1 : minElement;
    }
}
