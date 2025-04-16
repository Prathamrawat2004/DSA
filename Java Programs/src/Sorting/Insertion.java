package Sorting;

import java.util.Arrays;

public class Insertion {
    public static void InsertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // considering key because the elements at i will change
            int j = i - 1; // just befor i, there's a sorted list of elements

            while (j >= 0 && arr[j] > key) {
                // shifting elements ahead to make position for this key
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
