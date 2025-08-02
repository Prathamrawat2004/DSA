package TwoPointer;

import java.util.ArrayList;
// revisions = 1
public class IntersectionOfArrays {
    // brute force approach
    public ArrayList<Integer> intersect1(final ArrayList<Integer> A, final ArrayList<Integer> B){
        // resultant arraylist
        ArrayList<Integer> resultant = new ArrayList<>();
        boolean[] freqB = new boolean[B.size()];
        
        for(int i = 0; i < A.size(); i++){
            for(int j = 0; j < B.size(); j++){
                if(A.get(i).equals(B.get(j)) && !freqB[j]){
                    resultant.add(B.get(j));
                    freqB[j] = true;
                    break;
                }
            }
        }

        return resultant;
    }

    // optimized approach
    public ArrayList<Integer> intersect(final ArrayList<Integer> A, final ArrayList<Integer> B){
        // getting the sizes of both the lists
        int m = A.size(), n = B.size();

        // resultant arraylist
        ArrayList<Integer> resultant = new ArrayList<>();

        int i = 0, j = 0;

        while(i < m && j < n){
            if(A.get(i).equals(B.get(j))){
                resultant.add(B.get(j));
                i++;
                j++;
            }else if(A.get(i) < B.get(j)){
                i++;
            }else{
                j++;
            }
        }

        return resultant;
    }
}
