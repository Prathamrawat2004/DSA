package Arrays;

import java.util.ArrayList;

public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A){
        // getting the size of given arraylist
        int N = A.size();

        // base case
        if(N == 0 || N == 1){
            return A;
        }

        // resultant arraylist
        ArrayList<ArrayList<Integer>> resultant = new ArrayList<>();

        // storing elements till the longest diagonal
        for(int cols = 0; cols < N; cols++){
            int i = 0, j = cols;
            ArrayList<Integer> diagonal = new ArrayList<>();
            while(i < N && j >= 0){
                diagonal.add(A.get(i).get(j));
                i++;
                j--;
            }
            resultant.add(diagonal);
        }

        // storing the remaining elements
        for(int rows = 1; rows < N; rows++){
            int i = rows, j = N - 1;
            ArrayList<Integer> diagonal = new ArrayList<>();
            while(i < N && j >= 0){
                diagonal.add(A.get(i).get(j));
                i++;
                j--;
            }
            resultant.add(diagonal);
        }

        return resultant;
    }
}
