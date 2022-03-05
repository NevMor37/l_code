/**
 * A Range Module is a module that tracks ranges of numbers. Design a data structure to track the ranges represented as half-open intervals and query about them.
 *
 * A half-open interval [left, right) denotes all the real numbers x where left <= x < right.
 *
 * Implement the RangeModule class:
 *
 * RangeModule() Initializes the object of the data structure.
 * void addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
 * boolean queryRange(int left, int right) Returns true if every real number in the interval [left, right) is currently being tracked, and false otherwise.
 * void removeRange(int left, int right) Stops tracking every real number currently being tracked in the half-open interval [left, right).
 *
 *
 * Example 1:
 *
 * Input
 * ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
 * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
 * Output
 * [null, null, null, true, false, true]
 *
 * Explanation
 * RangeModule rangeModule = new RangeModule();
 * rangeModule.addRange(10, 20);
 * rangeModule.removeRange(14, 16);
 * rangeModule.queryRange(10, 14); // return True,(Every number in [10, 14) is being tracked)
 * rangeModule.queryRange(13, 15); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
 * rangeModule.queryRange(16, 17); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
 *
 *
 * Constraints:
 *
 * 1 <= left < right <= 109
 * At most 104 calls will be made to addRange, queryRange, and removeRange.
 */
import java.util.*;
public class RangeModule {
    TreeMap<Integer, Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if(right <= left) return;
        Integer start = map.floorKey(left);
        if(start == null) {
            start = map.ceilingKey(left);
        }
        while(start != null && start <= right) {
            int end = map.get(start);
            if(end >= left) {
                map.remove(start);
                if(start < left) left = start;
                if(end > right) right = end;
            }
            start = map.ceilingKey(end);
        }

        map.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        if(start == null) return false;
        return map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        if(right <= left) return;
        Integer start = map.floorKey(left);
        if(start == null) start = map.ceilingKey(left);
        while(start != null && start < right) {
            int end = map.get(start);
            if(end >= left) {
                map.remove(start);
                if(start < left) map.put(start, left);
                if(end > right) map.put(right, end);
            }
            start = map.ceilingKey(end);
        }
    }
}
