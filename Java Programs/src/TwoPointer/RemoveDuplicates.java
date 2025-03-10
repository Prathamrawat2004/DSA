package TwoPointer;
import java.util.*;

public class RemoveDuplicates {
    public int removeDuplicates(ArrayList<Integer> a){
        // base condition
        if(a.size() <= 1){
            return a.size();
        }

        // pointer to maintain unique element at every index
        int uniqueIndex = 0;

        for(int i = 0; i < a.size(); i++){
            if(!a.get(i).equals(a.get(uniqueIndex))){
                uniqueIndex++;
                a.set(uniqueIndex, a.get(i));
            }
        }

        return uniqueIndex + 1;
    }
}
