package Arrays;

import java.util.*;

public class LeadersInArray {
    public static List<Integer> findLeaders(int[] arr) {
        // getting the size of array
        int N = arr.length;

        // resultant list
        List<Integer> leaders = new ArrayList<>();

        int maxFromRight = arr[N - 1]; // last element is always a leader
        leaders.add(maxFromRight);

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(arr[i]);
            }
        }

        Collections.reverse(leaders);

        return leaders;
    }
}
