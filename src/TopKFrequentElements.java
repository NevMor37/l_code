import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 */
import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<FreqMap> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        Map<Integer, FreqMap> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            int temp = nums[i];
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new FreqMap(temp, 1));
            } else {
                FreqMap val = map.get(temp);
                val.freq = val.freq + 1;
                map.put(nums[i],val);
            }
        }
        List<FreqMap> list = new ArrayList<>(map.values());
        for(int i=0; i<list.size(); i++) {
            pq.offer(list.get(i));
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int [] res = new int [pq.size()];
        int i= 0;
        while(pq.peek() != null) {
            res[i++] = pq.poll().value;
        }
        return res;
    }

    class FreqMap {
        int value;
        int freq;

        public FreqMap(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }
}
