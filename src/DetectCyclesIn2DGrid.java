/**
 * Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.
 *
 * A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of
 * the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.
 *
 * Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because
 * from (1, 2) we visited (1, 1) which was the last visited cell.
 *
 * Return true if any cycle of the same value exists in grid, otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
 * Output: true
 * Explanation: There are two valid cycles shown in different colors in the image below:
 *
 * Example 2:
 *
 *
 *
 * Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
 * Output: true
 * Explanation: There is only one valid cycle highlighted in the image below:
 *
 * Example 3:
 *
 *
 *
 * Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
 * Output: false
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid consists only of lowercase English letters.
 */
public class DetectCyclesIn2DGrid {
    int [][] color;
    int len;
    int wid;
    public boolean containsCycle(char[][] grid) {
        this.len = grid.length;
        this.wid = grid[0].length;
        color = new int [len][wid];
        for(int i = 0; i<len; i++) {
            for(int j = 0; j<wid; j++) {
                if(color[i][j] == 0) {
                    if(dfs(grid, i, j, new int [] {-1, -1})) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean dfs(char [][] grid, int x, int y, int [] parent) {
        char cur = grid[x][y];
        color[x][y] = 1;
        for(int [] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX <len && newY >= 0 && newY < wid && grid[newX][newY] == cur) {
                if(color[newX][newY] == 1 && (newX != parent[0] || newY != parent[1])) return true;
                if(color[newX][newY] == 0) {
                    if(dfs(grid, newX, newY, new int [] {x, y})) return true;
                }
            }
        }
        color[x][y] = 2;
        return false;
    }
}
