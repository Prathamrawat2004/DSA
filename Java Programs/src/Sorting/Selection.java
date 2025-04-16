package Sorting;

import java.util.Arrays;

public class Selection {
    public void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // minimum element index

            // finding element with minIndex
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[minIndex]) {
                    minIndex = j;
                }

            }

            // swapping
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
    }
}
