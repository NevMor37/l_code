import java.util.*;
/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = n - 1;
        int down = m - 1;

        while (result.size() < m * n) {

            for (int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }

            for (int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            }

            if (up != down) {
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[down][col]);
                }
            }

            if (left != right) {
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }

    public static void main(String ... args) {
        int [][] test = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix sm = new SpiralMatrix();
        System.out.println(sm.spiralOrder(test));
    }
}
