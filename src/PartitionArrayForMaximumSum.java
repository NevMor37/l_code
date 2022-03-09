/**
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their
 * values changed to become the maximum value of that subarray.
 *
 * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * Example 2:
 *
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * Example 3:
 *
 * Input: arr = [1], k = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 *
 *
 * we define dp[] where dp[i] stands for the largest sum for array end at index i
 *
 * dp[i] = dp[i-1] + nums[i]
 * dp[i] = dp[i-2] + Math.max(nums[i-1], nums[i]) * 2
 * dp[i] = dp[i-3] + Math.max(nums[i-1], nums[i-2], nums[i]) * 3
 * ...
 * dp[i] = dp[i-k+1] + Math.max(nums[i-k+1], ... nums[i]) * k
 *
 * dp[i] is the maximum of these numbers
 *
 * we can initialize the first 0->k-1 parts, and then from the k -> n-1
 */
public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int [] dp = new int [len];
        dp[0] = arr[0];
        int max = dp[0];
        for(int i=1; i<k; i++) {
            max = Math.max(max, arr[i]);
            dp[i] = max * (i + 1);
        }

        for(int i = k; i<len; i++) {
            int maxSub = arr[i];
            for(int size = 1; size <=k; size++) {
                maxSub = Math.max(arr[i-size +1], maxSub);
                dp[i] = Math.max(dp[i], dp[i-size] + size * maxSub);
            }
        }
        return dp[len-1];
    }
}
