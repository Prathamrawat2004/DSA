package Sorting;
// revisions = 1
import java.util.Arrays;

public class Bubble {
    public void sort(int[] arr, int n) {
        // no. of passes
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // for stopping the loop if no swapping in any pass

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // if at any pass no swapping is done
            if (!swapped) {
                break;
            }

        }
    }
}
