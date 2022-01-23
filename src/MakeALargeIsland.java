/**
 * ou are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 *
 * Return the size of the largest island in grid after applying this operation.
 *
 * An island is a 4-directionally connected group of 1s.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 *
 * Input: grid = [[1,1],[1,0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 *
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] is either 0 or 1.
 */
public class MakeALargeIsland {
    int m;
    int n;
    public int largestIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        int max = 0;
        boolean hasZero = false;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(dfs(grid, i, j, new boolean[m][n]), max);
                    if(max == m * n) return max;
                    grid[i][j] = 0;
                    hasZero = true;
                }
            }
        }
        return hasZero ? max : m * n;
    }

    int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

//    public int countIsland(int [][] grid) {
//        int res = 0;
//        boolean [][] visited = new boolean [grid.length][grid[0].length];
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[0].length; j++) {
//                if(grid[i][j] == 1 && !visited[i][j]) {
//                    res = Math.max (dfs(grid, i, j, visited), res);
//                }
//            }
//        }
//        return res;
//    }
    public int dfs(int [][] grid, int x, int y, boolean [][]visited) {
        visited[x][y] = true;
        int area = 1;
        for(int [] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if(nextX >= 0 && nextX <m && nextY >=0 && nextY < n && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                area += dfs(grid, nextX, nextY, visited);
            }
        }
        return area;
    }

    public static void main(String ... args) {
        int [][] testCount = {{1, 0, 1}, {0, 0, 0}, {0, 1, 1}};
        MakeALargeIsland m = new MakeALargeIsland();
        //System.out.println(m.countIsland(testCount));
        System.out.println(m.largestIsland(testCount));
    }
}
