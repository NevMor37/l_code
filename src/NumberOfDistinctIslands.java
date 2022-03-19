/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
 *
 * Return the number of distinct islands.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
 * Output: 1
 * Example 2:
 *
 *
 * Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
import java.util.*;
public class NumberOfDistinctIslands {
    Set<String> set = new HashSet<>();
    public int numDistinctIslands(int[][] grid) {
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, "0", sb);
                    set.add(sb.toString());
                }
            }
        }
        System.out.println(set);
        return set.size();
    }
    int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void dfs(int [][] grid, int x, int y, String dir, StringBuilder path) {
        grid[x][y] = 0;
        path.append(dir);
        for(int i = 0; i<4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                if(i == 0) {
                    dfs(grid, newX, newY, "d", path);
                } else if(i == 1) {
                    dfs(grid, newX, newY, "u", path);
                } else if(i == 2) {
                    dfs(grid, newX, newY, "r", path);
                } else {
                    dfs(grid, newX, newY, "l", path);
                }
            }
        }
        path.append("b");
    }

    public static void main(String [] args) {
        NumberOfDistinctIslands n = new NumberOfDistinctIslands();
        int [][] test = {{1,1,0},{0,1,1},{0,0,0},{1,1,1},{0,1,0}};
        n.numDistinctIslands(test);
    }
}
