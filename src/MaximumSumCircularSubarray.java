/**
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 *
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n]
 * and the previous element of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j],
 * there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3.
 * Example 2:
 *
 * Input: nums = [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
 * Example 3:
 *
 * Input: nums = [-3,-2,-3]
 * Output: -2
 * Explanation: Subarray [-2] has maximum sum -2.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 */
public class MaximumSumCircularSubarray {

    // Time Limit Exceeded
    public int maxSubarraySumCircular(int[] nums) {
        int arr [] = new int [nums.length * 2];
        for(int i = 0; i<arr.length; i++) arr[i] = nums[i % nums.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
           int start = i, end = i + nums.length;
           int [] dp = new int [nums.length];
           dp[0] = arr[start];
           max = Math.max(max, dp[0]);
           for(int j = start + 1; j < end; j++) {
               dp[j - start] = Math.max(arr[j], dp[j - start - 1] + arr[j]);
               max = Math.max(dp[j - start], max);
           }
        }
        return max;
    }

    /**Great Solution*/
    //O(n)
    public int maxSubarraySumCircularDP(int[] nums) {
        int sum = 0;
        int [] minSub = new int [nums.length];
        int [] maxSub = new int [nums.length];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            sum += nums[i];
            minSub[i] = i == 0 ? nums[0] : Math.min(nums[i], nums[i] + minSub[i-1]);
            maxSub[i] = i == 0 ? nums[0] : Math.max(nums[i], nums[i] + maxSub[i-1]);
            min = Math.min(minSub[i], min);
            max = Math.max(maxSub[i], max);
        }

        //all negative number
        if(min == sum) {
            return max;
        }
        //first is subarray in middle, second is subarry on two sides, so we use sum to subtract the minimum subarray to get the maximum sub on two sides
        return Math.max(max, sum - min);
    }
}
