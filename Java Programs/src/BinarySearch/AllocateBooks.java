package BinarySearch;

import java.util.*;

public class AllocateBooks {
    public int Books(ArrayList<Integer> A, int B) {
        // base condition
        if (A.size() < B) {
            return -1; // not enough books to distribute
        }

        // using binary search

        int low = getMax(A); // min number of pages each should be receiving(Atleast)
        int high = getSum(A); // max number of pages each can get
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(A, B, mid)) {
                result = mid;
                high = mid - 1; // minimize allocation
            } else {
                low = mid + 1; // maximize allocation
            }

        }

        return result;

    }

    // helper function to check possibility
    public boolean isPossible(ArrayList<Integer> A, int B, int maxPages) {
        int students = 1, pagesAllocated = 0;

        for (int pages : A) {
            if (pagesAllocated + pages > maxPages) {
                students++;
                pagesAllocated = pages; // start from that book
                if (students > B) {
                    return false;
                }
            } else {
                pagesAllocated += pages;
            }

        }

        return true;
    }

    // helper function to get maximum
    public int getMax(ArrayList<Integer> A) {
        int max = 0;
        for (int num : A) {
            max = Math.max(max, num);
        }

        return max;
    }

    // helper function to get sum of all elements of A
    public int getSum(ArrayList<Integer> A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        return sum;
    }
}
