package Arrays;

import java.util.ArrayList;

import java.util.Collections;

public class WaveArray {
    public ArrayList<Integer> waveArray(ArrayList<Integer> A){
        // base condition
        if(A.size() == 1){
            return A;
        }

        Collections.sort(A);

        int i = 0;
        while(i + 1 < A.size()){
            // swapping the elements
            int temp = A.get(i);
            A.set(i, A.get(i + 1));
            A.set(i + 1, temp);

            i = i + 2;
        }

        return A;
    }
    
}
