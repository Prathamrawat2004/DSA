package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    // Brute-force solution
    public ArrayList<Integer> Intersection(ArrayList<Integer> A, ArrayList<Integer> B) {
        // sorting the two arrays
        Collections.sort(A);
        Collections.sort(B);

        // resultant arraylist
        ArrayList<Integer> resultant = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            // skipping the duplicates
            if (i > 0 && A.get(i) == A.get(i - 1))
                continue;

            for (int j = 0; j < B.size(); j++) {
                if (A.get(i) == B.get(j)) {
                    resultant.add(A.get(i));
                    break;
                }

            }
        }

        return resultant;

    }

    // optimized approach
    public ArrayList<Integer> Intersection2(ArrayList<Integer> A, ArrayList<Integer> B) {
        // creating a hashset from A
        HashSet<Integer> setA = new HashSet<>(A);

        // creating a result set
        HashSet<Integer> resultSet = new HashSet<>();

        // adding common elements from B
        for (int i = 0; i < B.size(); i++) {
            if (setA.contains(B.get(i))) {
                resultSet.add(B.get(i)); // hashset prevents duplicates automatically
            }
        }

        return new ArrayList<>(resultSet);
    }
}
