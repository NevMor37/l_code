import java.util.Arrays;

/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti < endi <= 106
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length <= 1) return true;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int [] cur = intervals[0];
        for(int i = 1; i<intervals.length; i++) {
            if(cur[1] > intervals[i][0]) {
                return false;
            }
            cur = intervals[i];
        }
        return true;
    }
}
