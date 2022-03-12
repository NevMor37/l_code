/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
import java.util.*;
public class NQueensII {
    int res;
    int n;
    public int totalNQueens(int n) {
        this.n = n;
        char [][] board = new char [n][n];
        for(char [] b : board) {
            Arrays.fill(b, '.');
        }
        backtrack(board, 0);
        return res;
    }
    public void backtrack(char [][] board, int row) {
        if(row == n) {
            res++;
            return;
        }
        for(int i=0; i<n; i++) {
            if(board[row][i] == '.' && isValid(board, row, i)) {
                board[row][i] = 'Q';
                backtrack(board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    public boolean isValid(char [][] board, int x, int y) {
        for(int i = 0; i<n; i++) {
            if(board[i][y] == 'Q') return false;
            if(board[x][i] == 'Q') return false;
            if(x + i < n && y + i < n && board[x + i][y + i] == 'Q') return false;
            if(x - i >= 0 && y - i >=0 && board[x-i][y-i] == 'Q') return false;
            if(x + i < n && y - i >=0 && board[x + i][y - i] == 'Q') return false;
            if(x - i >= 0 && y + i < n && board[x - i][y + i] == 'Q') return false;
        }
        return true;
    }
}
