/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 1 3 5 9
 * 2 4 6 8
 *
 * if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
 *         int length1 = nums1.length;
 *         int length2 = nums2.length;
 *         //to keep left partition has one more value than the right side
 *         //partition line is the (right  + itself)
 *         int partition = (length1 + length2 + 1)/2;
 *         int start = 0, end = length1;
 *         while(start <= end) {
 *             int mid = start + (end - start)/2;
 *             int secondPartition = partition - mid;
 *
 *             int maxLeft1 = mid == 0 ? Integer.MIN_VALUE : nums1[mid -1];
 *             int minRight1 = mid == length1 ? Integer.MAX_VALUE : nums1[mid];
 *
 *             int maxLeft2 = secondPartition == 0 ? Integer.MIN_VALUE : nums2[secondPartition-1];
 *             int minRight2 = secondPartition == length2 ? Integer.MAX_VALUE : nums2[secondPartition];
 *
 *             //find the cut
 *             if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
 *                 if((length1 + length2) % 2 == 0) {
 *                     return (double)((Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)))/2;
 *                 } else {
 *                     return (double)(Math.max(maxLeft1, maxLeft2));
 *                 }
 *             } else if(maxLeft1 > minRight2) {
 *                 end = mid -1;
 *             } else {
 *                 start = mid +1;
 *             }
 *         }
 *         return -1;
 *
 *  1 3 4 6 9
 *
 *  5 2 7 8
 *
 *  1 2 3 4
 *  5 6 7 8 9 10
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //we need nums2 is shorter
        if(len2 > len1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int partitionNum = (len1 + len2 + 1)/2;
        // for end we have to use len2 instead of len1
        // because we might use len2 itself as the partition line, in this case the entire nums2 will be used as the left side
        int start =0, end = len2;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int nums1Partition = partitionNum - mid;

            int nums2LeftMax = mid == 0 ? Integer.MIN_VALUE : nums2[mid-1];
            int nums2RightMin = mid == len2 ? Integer.MAX_VALUE : nums2[mid];
            int nums1LeftMax = nums1Partition == 0 ? Integer.MIN_VALUE : nums1[nums1Partition-1];
            int nums1RightMin = nums1Partition == len1 ? Integer.MAX_VALUE : nums1[nums1Partition];

            if(nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                if((len1 + len2)%2 == 0) {
                    return ((double)Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums2RightMin, nums1RightMin))/2;
                } else {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
            } else if(nums1LeftMax > nums2RightMin) {
                start = mid +1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
