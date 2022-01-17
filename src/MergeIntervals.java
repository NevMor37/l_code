import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
import java.util.*;
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int []> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int [] cur = intervals[0];
        int curEnd = cur[1];

        for(int [] interval : intervals) {
            if(interval[0] <= curEnd) {
                curEnd = Math.max(interval[1], curEnd);
                cur[1] = curEnd;
            } else {
                res.add(cur);
                cur = interval;
                curEnd = cur[1];
            }
        }
        res.add(cur);
        int [][] ret = new int [res.size()][2];
        for(int i=0; i<res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String ... args) {
        Map map = new HashMap();
        map.put(123, "456");
        map.put("abc", "def");
        if(map.containsKey(123)) System.out.println(map.get(123));
        if(map.containsKey("abc")) System.out.println(map.get("abc"));
    }
}
