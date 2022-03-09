import java.util.HashMap;

/**
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Example 2:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 16
 * 1 <= nums[i] <= 104
 * The frequency of each element is in the range [1, 4].
 */
public class PartitionToKEqualSubSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length < k) return false;
        int sum = 0;
        for(int i : nums) sum+=i;
        if(sum % k != 0) return false;
        int target = sum/k;
        return backtrack(nums, new boolean [nums.length], target, 0, k, 0);
    }

    public boolean backtrack(int [] nums, boolean []visited, int target, int cur, int parts, int index) {
        if(parts == 1) {
            return true;
        }
        if(target == cur) {
           return backtrack(nums, visited, target, 0, parts -1, 0);
        }
        if(target < cur) return false;
        for(int i=index; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(backtrack(nums, visited, target, cur + nums[i], parts, i + 1)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
