package Sorting;

import java.util.*;

public class MergeSort {
    public ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        // base condition
        if (list.size() <= 1) {
            return list;
        }

        int midPoint = list.size() / 2;

        // creating left and right sublists
        ArrayList<Integer> leftList = new ArrayList<>(list.subList(0, midPoint));
        ArrayList<Integer> rightList = new ArrayList<>(list.subList(midPoint, list.size()));

        // recursively sorting the list
        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        return merge(leftList, rightList);
    }

    // helper function to merge lists
    public ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        // resultant list to return
        ArrayList<Integer> merged = new ArrayList<>();

        int i = 0, j = 0;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) < rightList.get(j)) {
                merged.add(leftList.get(i));
                i++;
            } else {
                merged.add(rightList.get(i));
                j++;
            }
        }

        // if anylist is remaining
        while (i < leftList.size()) {
            merged.add(leftList.get(i));
            i++;
        }

        while (j < rightList.size()) {
            merged.add(rightList.get(i));
            j++;
        }

        return merged;
    }
}
