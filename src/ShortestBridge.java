/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] is either 0 or 1.
 * There are exactly two islands in grid.
 */
import java.util.*;
public class ShortestBridge {
    boolean [][] visited;
    int m;
    int n;
    Queue<int []> queue;
    int [][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int shortestBridge(int[][] grid) {
        m = grid.length;;
        n = grid[0].length;
        visited = new boolean [m][n];
        queue = new LinkedList<>();
        A:for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    break A;
                }
            }
        }
//        for(int i=0; i<m; i++) {
//            for(int j=0; j<n; j++) {
//                System.out.printf("%d ", grid[i][j]);
//            }
//            System.out.println();
//        }
        // preform bfs to find shortest bridge
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0; i<size; i++) {
                int [] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for(int [] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if(newX >= 0 && newX <m && newY >=0 && newY < n && !visited[newX][newY] && grid[newX][newY] != 2) {
                        if(grid[newX][newY] == 1) {
                           return step;
                        }
                        visited[newX][newY] = true;
                        queue.offer(new int [] {newX, newY});
                    }
                }
            }
            step++;
        }
        return step;
    }
    public void dfs(int [][] grid, int x, int y) {
        grid[x][y] = 2;
        queue.offer(new int [] {x, y});
        for(int [] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX <m && newY >=0 && newY < n && grid[newX][newY] == 1) {
                dfs(grid, newX, newY);
            }
        }
    }

    public static void main(String [] args) {
        ShortestBridge s = new ShortestBridge();
        int [][] test ={{0,1}, {1, 0}};
        s.shortestBridge(test);
    }
}
