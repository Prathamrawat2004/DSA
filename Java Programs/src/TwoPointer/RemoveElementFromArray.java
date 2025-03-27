package TwoPointer;

import java.util.*;

public class RemoveElementFromArray {
    public int removeElement(ArrayList<Integer> a, int B) {
        // pointer to manage the expected length
        int uniqueIndex = 0;

        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(B)) {
                a.set(uniqueIndex, a.get(i));
                uniqueIndex++;
            }
        }

        return uniqueIndex;
    }
}
