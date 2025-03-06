package TwoPointer;

import java.util.ArrayList;

public class IntersectionOfArrays {
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
