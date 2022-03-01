/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 *
 *   0  1  2  3
 *   4  5  6  7
 *   8  9 10 11
 *  12 13 14 15
 *  16 17 18 19
 *
 */
public class SearchA2DMatrixII {
    public boolean searchMatrixBS(int[][] matrix, int target) {
        int len = matrix.length;
        int wid = matrix[0].length;
        int start = 0, end = len * wid-1;
        while(start < end) {
            int mid = start + (end - start)/2;
            int x = mid/(len * wid-1) * len;
            int y = mid%wid;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int wid = matrix[0].length;
        int x = len -1, y = 0;
        while(x >= 0 && y <wid) {
            if(matrix[x][y] == target) {
                return true;
            }
            if(matrix[x][y] > target) {
                x--;
            }
            else {
                y++;
            }
        }
        return false;
    }
}
