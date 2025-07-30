package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class SortAccordingAnotherArray {
    // brute force solution
    public void relativeSort(int[] arr1, int[] arr2) {
        // creating an array to store the elements of arr2
        // present in arr1
        ArrayList<Integer> sameElements = new ArrayList<>();

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    sameElements.add(arr1[j]);
                }
            }
        }

        // creating an array for remaining elements
        ArrayList<Integer> remainingElements = new ArrayList<>();

        // adding elements
        for (int i = 0; i < arr1.length; i++) {
            boolean found = false;

            for (int j = 0; j < sameElements.size(); j++) {
                if (sameElements.get(j) == arr1[i]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                remainingElements.add(arr1[i]);
            }
        }

        // sorting the remaining elements
        Collections.sort(remainingElements);

        // merging all elements
        int i = 0, j = 0;
        ArrayList<Integer> sortedList = new ArrayList<>();
        while (i < sameElements.size()) {
            sortedList.add(sameElements.get(i));
            i++;
        }

        while (j < remainingElements.size()) {
            sortedList.add(remainingElements.get(j));
            j++;
        }

    }

    // optimized approach
    public void relativeSort2(int[] arr1, int[] arr2) {
        // storing elements of arr2 in hashmap for preserving the index of each element
        // the elements of arr2 are just used to provide the relative ordering
        HashMap<Integer, Integer> uniqueMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            if (!(uniqueMap.containsKey(arr2[i]))) {
                uniqueMap.put(arr2[i], i + 1); // no need to add duplicates as just used for relative ordering
            }
        }

        // storing the elements of arr1 in a list
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }

        // using custom comparator to sort the list
        Collections.sort(list, (a, b) -> {
            int idxA = uniqueMap.getOrDefault(a, 0);
            int idxB = uniqueMap.getOrDefault(b, 0);

            // Sorting conditions
            // 1. both 'REMAINING' elements
            if (idxA == 0 && idxB == 0) {
                // sort remaing elements in ascending order
                return a - b;
            }

            // 2. only one 'REMAINING' element
            if (idxA == 0) {
                return 1;
            }
            if (idxB == 0) {
                return -1;
            }

            // 3. both 'SAME ELEMENTS'
            return idxA - idxB;

        });
    }
}
