import java.util.LinkedList;
import java.util.Queue;

/**
 * You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.
 *
 * You are given an m x n character matrix, grid, of these different types of cells:
 *
 * '*' is your location. There is exactly one '*' cell.
 * '#' is a food cell. There may be multiple food cells.
 * 'O' is free space, and you can travel through these cells.
 * 'X' is an obstacle, and you cannot travel through these cells.
 * You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.
 *
 * Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
 * Output: 3
 * Explanation: It takes 3 steps to reach the food.
 * Example 2:
 *
 *
 * Input: grid = [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X"],["X","X","X","X","X"]]
 * Output: -1
 * Explanation: It is not possible to reach the food.
 * Example 3:
 *
 *
 * Input: grid = [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O","X"],["X","O","O","X","O","O","X","X"],["X","O","O","O","O","#","O","X"],["X","X","X","X","X","X","X","X"]]
 * Output: 6
 * Explanation: There can be multiple food cells. It only takes 6 steps to reach the bottom food.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * grid[row][col] is '*', 'X', 'O', or '#'.
 * The grid contains exactly one '*'.
 */
public class ShortestPathToGetFood {
    int res = -1;
    int [][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int getFood(char[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '*') {
                    bfs(i, j, grid);
                }
            }
        }
        return res;
    }

    public void bfs(int row, int col, char [][] grid) {
        int len = grid.length;
        int wid = grid[0].length;
        boolean [][] visited = new boolean[len][wid];
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int [] {row, col});
        visited[row][col] = true;
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                int [] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if(grid[x][y] == '#') {
                    res = step;
                    return;
                }
                for(int [] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if(newX >= 0 && newX < len && newY >= 0 && newY < wid && grid[newX][newY] != 'X' && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new int [] {newX, newY});
                    }
                }
            }
            step++;
        }
    }
}
