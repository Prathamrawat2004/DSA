package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MissingElementsOfRange {
    // brute force approach
    public void findMissing1(int[] arr, int n, int low, int high){
        // creating an Array to store elements not in array
        ArrayList<Integer> missingElements = new ArrayList<>();

        for(int i = low; i <= high; i++){
            // maintaining a flag 
            boolean found = false;

            // searching the element inside the array
            for(int j = 0; j < n; j++){
                if(arr[j] == i){
                    found = true;
                    break;
                }
            }

            // if the flag remains false i.e element is not present in the array
            if(!found){
                missingElements.add(i);
            }
        }

        // printing missing elements
        for(int i = 0; i < missingElements.size(); i++){
            System.out.print(missingElements.get(i) + " ");
        }

        

    }

    // optimized approach
    public void findMissing2(int[] arr, int n, int low, int high){
        // creating a hashset to store the elements of the array
        HashSet<Integer> uniqueSet = new HashSet<>();
        ArrayList<Integer> missingElements = new ArrayList<>();

        for(int i = 0; i < n; i++){
            uniqueSet.add(arr[i]);
        }

        // finding the missing elements 
        for(int j = low; j <= high; j++){
            if(!uniqueSet.contains(j)){
                missingElements.add(j);
            }
        }

        // printing the missing elements
        for(int num: missingElements){
            System.out.print(num + " ");
        }
    }
}
