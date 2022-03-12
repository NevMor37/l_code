/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 1, count = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] == nums[i-1] + 1) {
                count++;
            } else if(nums[i] == nums[i-1]) {
                continue;
            }else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        if(count != 1) res = Math.max(res, count);
        return res;
    }



    //100 4 200 1 3 2
    //100 - 1
    //4 - 1
    //200 - 1
    //1 - 1
    // 3 - 2  4 - 2
    // 2 - 4 1 - 4 4- 4
    public int longestConsecutiveOn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for(int i = 0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
            int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
            int length = left + right + 1;
            res=  Math.max(res, length);
            map.put(nums[i], length);
            map.put(nums[i] - left, length);
            map.put(nums[i] + right, length);
        }
//        for(int i : map.keySet()) {
//            System.out.println(i + " -> " + map.get(i));
//        }
        return res;
    }
}
