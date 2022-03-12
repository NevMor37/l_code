/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
import java.util.*;
public class NQueens {
    List<List<String>> res;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        char [][] board = new char [n][n];
        for(char [] b : board) {
            Arrays.fill(b, '.');
        }
        backtrack(board, 0, new ArrayList<>());
        return res;
    }
    public void backtrack(char [][] board, int row, List<String> subRes) {
        if(row == n) {
            subRes = new ArrayList<>();
            for(int i = 0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<n; j++) {
                    sb.append(board[i][j]);
                }
                subRes.add(sb.toString());
            }
            res.add(new ArrayList<>(subRes));
            return;
        }
        for(int i=0; i<n; i++) {
            if(board[row][i] == '.' && isValid(board, row, i)) {
                board[row][i] = 'Q';
                backtrack(board, row + 1, subRes);
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
