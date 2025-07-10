package Hashing;

import java.util.Arrays;
import java.util.HashSet;

// https://www.geeksforgeeks.org/dsa/find-whether-an-array-is-subset-of-another-array-set-1/
public class IsSubsetArray {
    public static boolean isSubset(int[] a, int[] b){
        // brute force solution
        // sorting both the arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // pointers for traversing both the arrays
        int i = 0, j = 0;

        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                // move to next element & closer towards b
                i++;
            }else if(a[i] == b[j]){
                // both elements matching
                i++;
                j++;
            }else{
                return false; // a[i] > b[j]
            }
        }

        return j == b.length;
    }

    // optimized solution
    public static boolean isSubset2(int[] a, int[] b){
        // creating hashset for storing a's elements
        HashSet<Integer> setA = new HashSet<>();

        for(int num: a){
            setA.add(num);
        }

        // checking if 'a' contains 'b' element
        for(int num: b){
            if(!setA.contains(num)){
                return false;
            }
        }

        return true;
    }

}
