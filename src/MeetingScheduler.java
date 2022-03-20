/**
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for
 * both of them and is of duration duration.
 *
 * If there is no common time slot that satisfies the requirements, return an empty array.
 *
 * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
 *
 * It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and
 * [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 *
 *
 *
 * Example 1:
 *
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 * Example 2:
 *
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= slots1.length, slots2.length <= 104
 * slots1[i].length, slots2[i].length == 2
 * slots1[i][0] < slots1[i][1]
 * slots2[i][0] < slots2[i][1]
 * 0 <= slots1[i][j], slots2[i][j] <= 109
 * 1 <= duration <= 106
 */
import java.util.*;
public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        while(i < slots1.length && j < slots2.length) {
            int [] slot1 = slots1[i];
            int [] slot2 = slots2[j];
            int maxLeft = Math.max(slot1[0], slot2[0]);
            int minRight = Math.min(slot1[1], slot2[1]);
            if(maxLeft < minRight) {
                if(minRight - maxLeft >= duration) {
                    res.add(maxLeft);
                    res.add(maxLeft + duration);
                    break;
                }
            }
            if(slot1[1] >= slot2[1]) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }

    public List<Integer> minAvailableDurationPQ(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i<slots1.length; i++) {
            //important
            if(slots1[i][1] - slots1[i][0] >= duration)
            pq.offer(slots1[i]);
        }
        for(int i = 0; i<slots2.length; i++) {
            if(slots2[i][1] - slots2[i][0] >= duration)
            pq.offer(slots2[i]);
        }
        List<Integer> res = new ArrayList<>();
        while(pq.size() > 1) {
            int [] first = pq.poll();
            int [] second = pq.peek();
            int end = Math.min(first[1], second[1]);
            if(end - second[0] >= duration) {
                res.add(second[0]);
                res.add(second[0] + duration);
                return res;
            }
        }
        return res;
    }
}
