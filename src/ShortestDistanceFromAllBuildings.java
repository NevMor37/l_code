/**
 *You are given an m x n grid grid of values 0, 1, or 2, where:
 *
 * each 0 marks an empty land that you can pass by freely,
 * each 1 marks a building that you cannot pass through, and
 * each 2 marks an obstacle that you cannot pass through.
 * You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move up, down, left, and right.
 *
 * Return the shortest travel distance for such a house. If it is not possible to build such a house according to the above rules, return -1.
 *
 * The total travel distance is the sum of the distances between the houses of the friends and the meeting point.
 *
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * Output: 7
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
 * So return 7.
 * Example 2:
 *
 * Input: grid = [[1,0]]
 * Output: 1
 * Example 3:
 *
 * Input: grid = [[1]]
 * Output: -1
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0, 1, or 2.
 * There will be at least one building in the grid.
 */
import java.util.*;
public class ShortestDistanceFromAllBuildings {
    int [][] canReach;
    int [][] distance;
    int [][] directions = new int [][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int m;
    int n;

    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        canReach = new int [m][n];
        distance = new int [m][n];

        int numHouse = 0, res = Integer.MAX_VALUE;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    boolean [][] visited = new boolean[m][n];
                    bfs(grid, i, j, visited);
                    numHouse++;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                //System.out.printf("%d ", canReach[i][j]);
                if(grid[i][j] == 0 && canReach[i][j] == numHouse) {
                    res = Math.min(res, distance[i][j]);
                }
            }
            //System.out.println();
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void bfs(int [][] grid, int i, int j, boolean [][] visited) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        int d = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k=0; k<size;k++) {
                int [] p = queue.poll();
                for(int [] direction : directions) {
                    int row = p[0] + direction[0];
                    int col = p[1] + direction[1];
                    if(row >= 0 && row < m && col >=0 && col < n && grid[row][col] == 0 && !visited[row][col]) {
                        visited[row][col] = true;
                        queue.offer(new int [] {row, col});
                    }
                }
                if(grid[p[0]][p[1]] == 0) {
                    canReach[p[0]][p[1]]++;
                    distance[p[0]][p[1]] += d;
                }
            }
            d++;
        }
    }

    public static void main(String ... args) {
        int [][] test = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        ShortestDistanceFromAllBuildings s = new ShortestDistanceFromAllBuildings();
        s.shortestDistance(test);
    }
}
