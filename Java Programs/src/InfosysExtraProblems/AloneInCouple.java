package InfosysExtraProblems;

import java.util.HashSet;

public class AloneInCouple {
    public int solve(int[] arr, int n) {
        // variable to store the 'alone' element
        int x = 0;

        // using bitwise operator
        // XOR is associative i.e ordering does not matter
        for (int i = 0; i < n; i++) {
            // 0 ^ 1 = 1 i.e different number being XOR'ed
            // 1 ^ 1 = 0 i.e same number being XOR'ed
            x = x ^ arr[i];
        }

        return x;
    }

    // approach 2
    public void solve2(int[] arr, int n) {
        // creating a hashset to store the unique values
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }

        // print the remaining element
        if (!set.isEmpty()) {
            System.out.println(set.iterator().next());
        } else {
            System.out.println("No person alone");
        }
    }
}
