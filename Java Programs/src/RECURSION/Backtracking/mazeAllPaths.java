package RECURSION.Backtracking;

public class mazeAllPaths {

    // In this case, the answer would be stack overflow because it will again come
    // back to the origin from where it started because it can move in all
    // directions,
    // causing the same recursion to again start and that will lead to an infinite
    // loop causing the overflow.
    // static void allPaths(String p, boolean[][] maze, int r, int c){
    // // base condition
    // if(r == maze.length - 1 && c == maze[0].length - 1){
    // System.out.println(p);
    // return;
    // }

    // // if obstacle
    // if(maze[r][c] == false){
    // return;
    // }

    // // keep moving down
    // if (r < maze.length - 1) {
    // allPaths(p + 'D', maze, r + 1, c);
    // }

    // // keep moving right
    // if (r < maze[0].length - 1) {
    // allPaths(p + 'R', maze, r, c + 1);
    // }

    // // keep moving up
    // if (r > 0) {
    // allPaths(p + 'R', maze, r - 1, c);
    // }

    // // keep moving left
    // if (c > 0) {
    // allPaths(p + 'L', maze, r, c - 1);
    // }

    // }

    static void allPaths(String p, boolean[][] maze, int r, int c) {
        // base condition
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        // if obstacle
        if (maze[r][c] == false) {
            return;
        }

        // considering this block in my path
        maze[r][c] = false;

        // keep moving down
        if (r < maze.length - 1) {
            allPaths(p + 'D', maze, r + 1, c);
        }

        // keep moving right
        if (r < maze[0].length - 1) {
            allPaths(p + 'R', maze, r, c + 1);
        }

        // keep moving up
        if (r > 0) {
            allPaths(p + 'R', maze, r - 1, c);
        }

        // keep moving left
        if (c > 0) {
            allPaths(p + 'L', maze, r, c - 1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made
        // by the function
        // i.e BACKTRACK
        maze[r][r] = true; // reverting the changes

    }
}
