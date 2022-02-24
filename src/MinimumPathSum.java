/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        for(int i=1; i<grid[0].length; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for(int i=1; i<grid.length; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for(int i=1; i<grid.length; i++) {
            for(int j=1; j<grid[i].length; j++) {
                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
