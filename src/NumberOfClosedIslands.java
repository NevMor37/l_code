/**
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally
 * (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * Example 2:
 *
 *
 *
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 *                [1,1,1,1,1,1,1]]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        for(int i = 0; i<grid.length; i++) {
            if(grid[i][0] == 0) dfs(grid, i, 0);
            if(grid[i][grid[0].length -1] == 0) dfs(grid, i, grid[0].length-1);
        }
        for(int i = 0; i<grid[0].length; i++) {
            if(grid[0][i] == 0) dfs(grid, 0, i);
            if(grid[grid.length-1][i] == 0) dfs(grid, grid.length-1, i);
        }
        int res = 0;
        for(int i = 1; i<grid.length; i++) {
            for(int j = 1; j<grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int [][] grid, int x, int y) {
        grid[x][y] = 1;
        for(int [] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                dfs(grid, newX, newY);
            }
        }
    }
}
