/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * Example 2:
 *
 *
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
public class UniquePathsII {
    public static int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int len = obstacleGrid.length;
        int wid = obstacleGrid[0].length;
        if(obstacleGrid[len-1][wid-1] == 1) return 0;
        int [][] dp = new int [len][wid];
        for(int i=0; i<len; i++) {
            if(obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for(int i=0; i<wid; i++) {
            if(obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for(int i=1; i<len; i++) {
            for(int j=1; j<wid; j++) {
                int left = obstacleGrid[i][j-1] == 1 ? 0 : dp[i][j-1];
                int up = obstacleGrid[i-1][j] == 1 ? 0 : dp[i-1][j];
                dp[i][j] = left + up;
            }
        }
        return dp[len-1][wid-1];
    }

    public static void main(String [] args) {
        int [][] test = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int [][] test1 = {{0, 0}, {1, 0}};
        uniquePathsWithObstaclesDP(test1);
    }
}
