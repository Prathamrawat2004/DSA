package Arrays;

import java.util.ArrayList;

public class ArrayBug {
    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B){
        // resultant arraylist
        ArrayList<Integer> resultant = new ArrayList<>();

        // effective rotations
        B = B % A.size();

        for(int i = 0; i < A.size(); i++){
            resultant.add(A.get((i + B) % A.size()));
        }

        return resultant;
    }
}
