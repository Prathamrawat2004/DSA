package Backtrack;

import java.util.*;

public class Combinations1 {
    public ArrayList<String> specialStrings(ArrayList<String> A) {
        // resultant list
        ArrayList<String> result = new ArrayList<>();

        // helper function to generate the special strings
        generateStrings(A, 0, "", result);

        // sorting to get the lexicographic order
        Collections.sort(result);

        return result;
    }

    // helper function definition
    public void generateStrings(ArrayList<String> A, int index, String current, ArrayList<String> result) {
        // base condition
        if (index == A.size()) {
            result.add(current);
            return;
        }

        for (char c : A.get(index).toCharArray()) {
            generateStrings(A, index + 1, current + c, result);

        }
    }
}
