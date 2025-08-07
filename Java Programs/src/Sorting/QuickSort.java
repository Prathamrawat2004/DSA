package Sorting;

public class QuickSort {
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pI = partition(arr, low, high); // correct position of pivot

            // sort left & right subarrays
            quickSort(arr, low, pI - 1);
            quickSort(arr, pI + 1, high);
        }
    }

    // function to perform the partition
    public int partition(int[] arr, int low, int high) {
        // creating a pivot
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            // finding the element greater than pivot
            while (i <= high && arr[i] <= arr[pivot]) {
                i++;
            }

            // finding the element smaller than pivot
            while (j >= 0 && arr[j] >= arr[pivot]) {
                j--;
            }

            // Swap elements that are on wrong side of pivot
            if (i < j) {
                swap(arr, i, j);
            }

        }

        // the point where they both cross each other
        // 'j' will be pointing to the correct pivot's position
        swap(arr, low, j);

        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
