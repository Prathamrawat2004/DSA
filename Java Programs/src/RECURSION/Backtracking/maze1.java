package RECURSION.Backtracking;

public class maze1 {
    // counting the paths to reach the desired cell in the maze
    static int count(int r, int c) {
        // base condition
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = count(r - 1, c);
        int right = count(r, c - 1);

        return right + left;

    } 
}
