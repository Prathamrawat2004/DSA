package TwoPointer;
import java.util.*;
// revisions = 1
public class MergeSortedLists {
    // brute force approach
    public void merge1(ArrayList<Integer> a, ArrayList<Integer> b){
        // adding the elements of B to A
        for(int i = 0; i < b.size(); i++){
            a.add(b.get(i));
        }

        // sorting the resultant 'A' list
        Collections.sort(a);
    }

    // optimized approach
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b){
        // getting the sizes of both lists
        int m = a.size();
        int n = b.size();

        // incrementing the size of list a
        for(int i = 0; i < n; i++){
            a.add(0);
        }

        // declaring pointers from last to avoid overwriting
        int i = (m - 1);
        int j = (n - 1);
        int k = (m + n - 1);

        // merging the lists
        while(i >= 0 && j >= 0){
            if(a.get(i) > b.get(j)){
                a.set(k--, a.get(i--));
            }else{
                a.set(k--, b.get(j--));
            }
        }

        // if b still has elements (a had much bigger elements than b)
        while(j >= 0){
            a.set(k--, b.get(j--));
        }
    }
}
