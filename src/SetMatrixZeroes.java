/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 *
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 *
 * Follow up:
 *
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int len = matrix.length;
        int wid = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for(int i=0; i<len; i++) {
            for(int j=0; j<wid; j++) {
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(int row : rowSet) {
            for(int i = 0; i<wid; i++) matrix[row][i] = 0;
        }

        for(int col : colSet) {
            for(int i=0; i<len; i++) matrix[i][col] =0;
        }
    }

    // trying to implement with O(1) space complexitybvgyh
    public void setZeroesSpace(int[][] matrix) {
        int len = matrix.length;
        int wid = matrix[0].length;
        boolean row0 = false, col0 = false;
        for(int i=0; i<len; i++) {
            for(int j=0; j<wid; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) row0 = true;
                    if(j == 0) col0 = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i<len; i++) {
            if(matrix[i][0] == 0) {
                for(int j=1; j<wid; j++) matrix[i][j] = 0;
            }
        }

        for(int i=1; i<wid; i++) {
            if(matrix[0][i] == 0) {
                for(int j=1; j<len; j++) matrix[j][i] = 0;
            }
        }

        if(row0) {
            for(int i=0; i<wid; i++) matrix[0][i] = 0;
        }
        if(col0) {
            for(int i=0; i<len; i++) matrix[i][0] = 0;
        }
    }
}
