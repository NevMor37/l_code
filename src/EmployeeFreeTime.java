/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 *
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 *
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
 *
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example,
 * schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 *
 *
 *
 * Example 1:
 *
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 * Example 2:
 *
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 *
 *
 * Constraints:
 *
 * 1 <= schedule.length , schedule[i].length <= 50
 * 0 <= schedule[i].start < schedule[i].end <= 10^8
 */
import java.util.*;
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> flat = new ArrayList<>();
        List<Interval> res=  new ArrayList<>();
        List<Interval> merged = new ArrayList<>();
        if(schedule == null || schedule.size() == 0) return res;
        for(List<Interval> list : schedule) {
            for(Interval interval : list) {
                flat.add(interval);
            }
        }
        Collections.sort(flat, (a, b) -> a.start - b.start);
        Interval prev = flat.get(0);
        for(int i = 1; i<flat.size(); i++) {
            Interval cur = flat.get(i);
            if(prev.end >= cur.start) {
                prev.end = Math.max(cur.end, prev.end);
            } else {
                merged.add(prev);
                prev = cur;
            }
        }
        merged.add(prev);
        for(int i = 1; i<merged.size(); i++) {
            Interval temp = new Interval(merged.get(i-1).end, merged.get(i).start);
            res.add(
                    temp
            );
        }
        return res;
    }
}
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
