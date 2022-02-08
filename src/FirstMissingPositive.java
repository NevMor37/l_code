/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        boolean oneFlag = false;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 1) {
                oneFlag = true;
            }
            if(nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if(!oneFlag) return 1;
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if(nums[val-1] > 0) {
                nums[val-1] = -nums[val-1];
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String [] args) {
        int [] test = {3, 4, -1, 1};
        firstMissingPositive(test);
    }
}
