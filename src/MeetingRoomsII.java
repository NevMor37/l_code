import java.util.*;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 *
 * public int minMeetingRooms(int[][] intervals) {
 *         if(intervals.length == 1) return 1;
 *         int res = 1;
 *         PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
 *         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
 *         pq.offer(intervals[0]);
 *         for(int i=1; i<intervals.length; i++) {
 *             int [] cur = intervals[i];
 *             if(cur[0] < pq.peek()[1]) {
 *                 res++;
 *                 pq.offer(cur);
 *             } else {
 *                 pq.poll();
 *                 pq.offer(cur);
 *             }
 *         }
 *         return res;
 *     }
 */
public class MeetingRoomsII {
    //we use heap to populate the earlist ending meeting (by sort the interval in heap by ending time)
    //if the next meeting start time is earlier than current top meeting ending time in the heap
    //we need to allocate another room
    //otherwise it means we can reuse this room, so we pop the meeting room out and push the current meeeing schedule(count together as one)
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= pq.peek()[1]) {
                pq.poll();
            }
            pq.offer(intervals[i]);
        }
        return pq.size();
    }
}
