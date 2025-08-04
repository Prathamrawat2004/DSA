package TwoPointer;

import java.util.*;
// revisions = 1
public class RemoveDuplicates {
    // brute force solution
    public int removeDuplicates1(ArrayList<Integer> a) {
        // creating a hashset to store unique values
        HashSet<Integer> uniqueSet = new HashSet<>();
        ArrayList<Integer> resultSet = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            if (!uniqueSet.contains(a.get(i))) {
                resultSet.add(a.get(i));
            }
            uniqueSet.add(a.get(i));
        }

        // resetting the values of list 'a'
        // the extra values doesn't matter
        // only fix 'a' till the size of resultset
        for (int j = 0; j < resultSet.size(); j++) {
            a.set(j, resultSet.get(j));
        }
        
        return resultSet.size();
    }

    // optimized approach
    public int removeDuplicates(ArrayList<Integer> a) {
        // base condition
        if (a.size() <= 1) {
            return a.size();
        }

        // pointer to maintain unique element at every index
        int uniqueIndex = 0;

        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(a.get(uniqueIndex))) {
                uniqueIndex++;
                a.set(uniqueIndex, a.get(i));
            }
        }

        return uniqueIndex + 1;
    }
}
