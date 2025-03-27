package RECURSION.Backtracking;

import java.util.*;

public class GenerateParentheses {
    public ArrayList<String> generateAllParentheses(int A) {
        // resultant arraylist
        ArrayList<String> resultant = new ArrayList<>();

        // function to generate parentheses
        parentheses(A, "", 0, 0, resultant);

        return resultant;
    }

    // helper function definition
    public void parentheses(int max, String current, int open, int close, ArrayList<String> resultant) {
        // base condition
        if (current.length() == max * 2) {
            resultant.add(current);
            return;
        }

        // adding open brackets
        if (open < max) {
            parentheses(max, current + "(", open + 1, close, resultant);
        }

        // adding close brackets
        if (close < open) {
            parentheses(max, current + ")", open, close + 1, resultant);
        }
    }
}
