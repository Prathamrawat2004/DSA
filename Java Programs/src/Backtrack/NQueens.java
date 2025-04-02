package Backtrack;

import java.util.*;

public class NQueens {
    public int queens(boolean[][] board, int row) {
        // base condition
        if (row == board.length) {
            // display the board
            Display(board);
            return 1;
        }

        // to count the number of possible valid boards
        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true; // place the queen
                count += queens(board, row + 1);
                board[row][col] = false; // backtrack
            }
        }

        return count;
    }

    // function to check if the queen placed is safe
    public boolean isSafe(boolean[][] board, int row, int col) {
        // checking the vertical direction
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // checking the diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // checking the diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    // function to display the board
    public void Display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
