/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 */
public class diagonalTraverse {
    //simulation
    //need up boolean value to choose go upwards or go downwards
    //start from [0, 0], up
    //every time we go inside the outboard in the inner iteration
    //after the inner iteration, we do one more i++ but row and col stay the same due to in each loop we change row and col by 1
    //we decide the next direction by checking current row and col value
    //reverse the up value in each iteration
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [] arr = new int [m * n];
        int i = 0;
        int row = 0, col = 0;
        boolean up = true;
        while(row < m && col < n) {
            if(up) {
                while(row >0 && col < n-1) {
                    arr[i++] = mat[row][col];
                    row--;
                    col++;
                }
                arr[i++] = mat[row][col];
                if(col == n-1) {
                    row++;
                } else {
                    col++;
                }
                up = false;
            } else {
                while(row < m-1 && col >0) {
                    arr[i++] = mat[row][col];
                    row++;
                    col--;
                }
                arr[i++] = mat[row][col];
                if(row == m-1) {
                    col++;
                } else {
                    row++;
                }
                up = true;
            }
        }
        return arr;
    }
}
