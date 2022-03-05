/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 *
 * Constraints:
 *
 * 0 <= rowIndex <= 33
 *
 *
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */
import java.util.*;
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = Arrays.asList(1);
        if(rowIndex == 0) return prev;
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<=rowIndex; i++) {
            res.add(1);
            for(int j=1; j<=i-1; j++) {
                res.add(prev.get(j-1) + prev.get(j));
            }
            res.add(1);
            prev = res;
            res = new ArrayList<>();
        }
        return prev;
    }
}
