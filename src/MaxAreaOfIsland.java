/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
public class MaxAreaOfIsland {
    int res = 0;
    int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public int dfs(int [][] grid, int x, int y) {
        grid[x][y] = 0;
        int res = 1;
        for(int [] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX < m && newY >=0 && newY < n && grid[newX][newY] == 1) {
                res += dfs(grid, newX, newY);
            }
        }
        if(res > this.res) {
            this.res = res;
        }
        return res;
    }
}
