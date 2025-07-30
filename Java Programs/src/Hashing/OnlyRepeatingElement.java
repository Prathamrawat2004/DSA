package Hashing;
import java.util.*;

public class OnlyRepeatingElement {
    // brute force solution
    public int findDuplicate(int[] arr){
        // as the numbers are from 1 -> n - 1
        // equivalent to natural numbers
        // sorting the given array
        Arrays.sort(arr);

        int repetitiveElement = -1;

        // every element has the relation of value = index + 1
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i - 1]){
                repetitiveElement = arr[i];
            }
        }

        return repetitiveElement;
    }

    // optimized solution
    public int findDuplicate2(int[] arr){
        int n = arr.length;

        // creating hashset
        HashSet<Integer> uniqueSet = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(uniqueSet.contains(arr[i])){
                return arr[i];
            }
            uniqueSet.add(arr[i]);
        }

        // no repeating element
        return -1;
    }
}
