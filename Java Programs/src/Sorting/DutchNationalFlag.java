package Sorting;

import java.util.*;

public class DutchNationalFlag {
    public static void sort012(ArrayList<Integer> A) {
        int low = 0;
        int mid = 0;
        int high = A.size() - 1;

        while (mid <= high) {
            switch (A.get(mid)) {
                case 0:
                    swap(A, low, mid);
                    low++;
                    mid++;

                    break;
                case 1:
                    mid++;
                    break;

                case 2:
                    swap(A, mid, high);
                    high--;
                    break;
                default:
                    break;

            }
        }
    }

    public static void swap(ArrayList<Integer> A, int e1, int e2) {
        int temp = A.get(e1);
        A.set(e1, A.get(e2));
        A.set(e2, temp);
    }
}
