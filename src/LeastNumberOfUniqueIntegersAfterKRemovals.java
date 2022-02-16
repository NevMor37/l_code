/**
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 */
import java.util.*;
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Pair> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.count));
        for(int i : arr) {
            if(!map.containsKey(i)) {
                Pair pair = new Pair();
                pair.num = i;
                pair.count = 0;
                map.put(i, pair);
            }
            map.get(i).count++;
        }
        map.values().stream().forEach(p -> pq.offer(p));
        while(pq.size() > 0 && k >0) {
            Pair cur = pq.poll();
            if(k-cur.count >= 0) {
                k-= cur.count;
            } else {
                pq.offer(cur);
                break;
            }
        }
        return pq.size();
    }
    class Pair {
        int num;
        int count;
    }
}
