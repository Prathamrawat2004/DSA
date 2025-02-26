package RECURSION.Backtracking;

public class mazeObst {
    static void mazeObstacles(String p, boolean maze[][], int r, int c) {
        // base condition
        // considering from (0,0)
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        // checking the false conditon or obstacle
        if (maze[r][c] == false) {
            return;
        }

        // keep moving down
        if (r < maze.length - 1) {
            mazeObstacles(p + 'D', maze, r + 1, c);
        }

        // keep moving right
        if (r < maze[0].length - 1) {
            mazeObstacles(p + 'R', maze, r, c + 1);
        }
    }
}
