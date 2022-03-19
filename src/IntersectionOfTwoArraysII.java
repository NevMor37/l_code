import java.util.Arrays;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
 * must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
import java.util.*;
public class IntersectionOfTwoArraysII {
    public int[] intersectSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i++];
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int [] res = new int [k];
        for(i = 0; i<k; i++) {
            res[i] = nums1[i];
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
        int k = 0;
        for(int i = 0; i<nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                nums1[k++] = nums1[i];
                int frq = map.get(nums1[i]);
                frq--;
                if(frq == 0) map.remove(nums1[i]);
                else map.put(nums1[i], frq);
            }
        }
        int [] res = new int [k];
        for(int i = 0; i<k; i++) {
            res[i] = nums1[i];
        }
        return res;
    }
}
