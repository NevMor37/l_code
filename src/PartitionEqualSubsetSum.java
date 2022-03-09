/**
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two
 * subsets such that the sum of elements in both subsets is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
import java.util.*;
public class PartitionEqualSubsetSum {
    Map<String, Boolean> map;
    public boolean canPartition(int[] nums) {
        if(nums.length < 2) return false;
        map = new HashMap<>();
        int sum = 0;
        for(int i : nums) sum+=i;
        if(sum % 2 != 0) return false;
        int target = sum/2;
        return backtrack(nums, 0, target, 0);
    }

    public boolean backtrack(int [] nums, int index, int target, int cur) {
        if(index == nums.length) {
            return false;
        }
        if(cur == target) return true;
        String key = index + "" + cur;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        boolean res = backtrack(nums, index + 1, target, cur + nums[index]) || backtrack(nums, index + 1, target, cur);
        map.put(key, res);
        return res;
    }
}
