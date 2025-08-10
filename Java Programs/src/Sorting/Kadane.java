package Sorting;
// revisions = 1
import java.util.Arrays;

public class Kadane {
    public int Kadane(int[] arr){
        // pointer for recording the max sum
        int max_Sum_So_Far = arr[0];
        int max_Ending_Here = arr[0];

        for(int i = 1; i < arr.length; i++){
            max_Ending_Here = Math.max(arr[i], max_Ending_Here + arr[i]);
            max_Sum_So_Far = Math.max(max_Ending_Here, max_Sum_So_Far);
        }

        return max_Sum_So_Far;
    }
}
