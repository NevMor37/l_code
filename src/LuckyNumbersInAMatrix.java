/**
 * Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 2:
 *
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 *
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 * Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 105.
 * All elements in the matrix are distinct.
 */
import java.util.*;
public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return res;
        int [] rows = new int [matrix.length];
        int [] cols = new int [matrix[0].length];
        for(int i = 0; i<matrix.length; i++) {
            int minRow = Integer.MAX_VALUE;
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[i][j] < minRow) {
                    minRow = matrix[i][j];
                }
            }
            rows[i] = minRow;
        }

        for(int i = 0; i<matrix[0].length; i++) {
            int maxCol = 0;
            for(int j = 0; j<matrix.length; j++) {
                if(matrix[j][i] > maxCol) {
                    maxCol = matrix[j][i];
                }
            }
            cols[i] = maxCol;
        }

        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(matrix[i][j] == rows[i] && matrix[i][j] == cols[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}
