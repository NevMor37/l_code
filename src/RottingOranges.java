/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
import java.util.*;
public class RottingOranges {
    int [][] directions = {{0, 1}, {1, 0}, {0, -1},{-1, 0}};
    public int orangesRotting(int[][] grid) {
        int goodOrangeCount = 0, step = 0;
        int len = grid.length;
        int wid = grid[0].length;
        Queue<int []> queue = new LinkedList<>();
        for(int i=0; i<len; i++) {
            for(int j=0; j<wid; j++) {
                if(grid[i][j] == 1) {
                    goodOrangeCount++;
                } else if(grid[i][j] == 2) {
                    queue.offer(new int [] {i, j});
                }
            }
        }
        if(goodOrangeCount == 0) {
            return 0;
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i = 0; i<size; i++) {
                int [] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                for(int [] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if(newX >= 0 && newX < len && newY >=0 && newY < wid && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        goodOrangeCount--;
                        queue.offer(new int [] {newX, newY});
                    }
                }
            }
        }
        if(goodOrangeCount == 0) {
            return step-1;
        }
        return -1;
    }
}
