/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int [] max = new int [nums.length];
        int [] min = new int [nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for(int i=1; i<nums.length; i++) {
            int maxProduct = nums[i] * max[i-1];
            int minProduct = nums[i] * min[i-1];
            max[i] = Math.max(Math.max(maxProduct, minProduct), nums[i]);
            min[i] = Math.min(Math.min(maxProduct, minProduct), nums[i]);
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
