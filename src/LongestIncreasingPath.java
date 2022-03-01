/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down.
 * You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 *
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 * we don't need visited array to save space, because we are trying to go ascending order, prev will always less than next
 */
public class LongestIncreasingPath {
    Integer [][] memo;
    int m;
    int n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        this.memo = new Integer [m][n];
        int res = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                res = Math.max(dfs(i, j, matrix), res);
            }
        }
        return res;
    }
    int [][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int dfs(int x, int y, int [][] matrix) {
        if(memo[x][y] != null) return memo[x][y];
        int res = 0;
        for(int [] direction : directions){
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX < m && newY >=0 && newY < n && matrix[x][y] < matrix[newX][newY]) {
                res = Math.max(res, dfs(newX, newY, matrix));
            }
        }
        memo[x][y] = res +1;
        return res +1;
    }
}
