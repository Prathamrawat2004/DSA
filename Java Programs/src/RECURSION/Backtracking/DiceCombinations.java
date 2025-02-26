package RECURSION.Backtracking;

public class DiceCombinations {
    // returning the total combinations of forming a digit using dice
    static void dice(String p, int target) {
        // base condition
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }
}
