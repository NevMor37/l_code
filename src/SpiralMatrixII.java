/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int [][] res = new int [n][n];
        int left = 0, right = n-1, bot = n-1, up = 0;
        int i = 1;
        while(i <= n * n) {
            for(int j = left; j<=right; j++) {
                res[up][j] = i++;
            }
            up++;
            for(int j = up; j <= bot; j++) {
                res[j][right] = i++;
            }
            right--;
            for(int j = right; j>=left;j--) {
                res[bot][j] = i++;
            }
            bot--;
            for(int j = bot; j>=up; j--) {
                res[j][left] = i++;
            }
            left++;
        }
        return res;
    }
}
