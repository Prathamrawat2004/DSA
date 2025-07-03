package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class SetMatrixZeros {
    public void setZeros(ArrayList<ArrayList<Integer>> a) {
        // getting rows & cols
        int M = a.size();
        int N = a.get(0).size();

        // creating hashset for storing rows with 0 element
        // creating hashset for storing cols with 0 element
        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroCols = new HashSet<>();

        // storing indexes
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (a.get(i).get(j) == 0) {
                    // storing rows & cols
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // setting the entire rows & cols to 0
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    a.get(i).set(j, 0);
                }
            }
        }
    }

    public void setZeros2(ArrayList<ArrayList<Integer>> a) {
        // getting rows & cols
        int M = a.size();
        int N = a.get(0).size();

        // creating arrays for specific rows & cols
        boolean[] zeroRows = new boolean[2];
        boolean[] zeroCols = new boolean[2];

        // marking the desired rows & cols with 0 element
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (a.get(i).get(j) == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // setting desired rows & cols to 0
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (zeroRows[i] || zeroCols[i]) {
                    a.get(i).set(j, 0);
                }
            }
        }

    }
}
