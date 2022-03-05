/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
import java.util.*;
public class PascalsTrinange {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for(int i = 1; i<numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 1; j<i; j++) {
                list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
