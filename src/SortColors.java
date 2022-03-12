/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0] 0 0 2 1 1 2 ->
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
import java.util.*;
public class SortColors {
    //one pass with O(n) time and O(1) space
    public  void sortColors(int[] nums) {
        int i = 0, left =0, right = nums.length -1;
        while(i <= right) {
            if(nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if(nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    public  void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColorsHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int k = 0;
        for(int i = 0; i<=2; i++) {
            if(map.containsKey(i)) {
                int count = map.get(i);
                for(int j = 0; j<count; j++) {
                    nums[k++] = i;
                }
            }
        }
    }

    public static void main(String [] args) {
        SortColors sc = new SortColors();
        int [] test = {2,0,2,1,1,0};
        sc.sortColors(test);
        for(int i : test) System.out.println(i);
    }
}
