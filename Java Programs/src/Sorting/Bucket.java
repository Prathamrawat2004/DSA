package Sorting;
import java.util.*;

public class Bucket {
    public static void bucketSort(int[] arr) {
        if (arr.length < 2)
            return;

        // finding the min and max elements inside the array
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int n = arr.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1)); // ensuring atleast 1 bucket size
        int bucketCount = (max - min) / bucketSize + 1;

        // creating buckets
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // distributing elements into buckets
        for (int num : arr) {
            int index = (num - min) / bucketSize;
            buckets[index].add(num);
        }

        // sorting the individual buckets
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // concatenate the buckets
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }
}
