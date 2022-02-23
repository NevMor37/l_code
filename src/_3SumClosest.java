import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class _3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int res = 0, diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int temp = target - nums[i];
            int low = i +1, high = nums.length-1;
            while(low < high) {
                int curDiff = Math.abs(temp - nums[low] - nums[high]);
                if(curDiff == 0) return target;
                if(curDiff< diff) {
                    res = nums[low] + nums[high] + nums[i];
                    diff = curDiff;
                }
                if(nums[low] + nums[high] > temp) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return res;
    }

    public static void main(String [] args) {

    }
}
