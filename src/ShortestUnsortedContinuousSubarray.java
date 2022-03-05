import java.util.Arrays;
import java.util.Stack;

/**
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 0
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 *
 * Follow up: Can you solve it in O(n) time complexity?
 *
 * 2 6 4 8 10  9 15
 * 2 4 6 8  9 10 15
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarraySort(int[] nums) {
        if(nums.length == 1) return 0;
        int [] copy = new int [nums.length];
        for(int i=0; i<nums.length; i++) copy[i] = nums[i];
        Arrays.sort(copy);
        int left = nums.length-1, right = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != copy[i]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return right - left + 1 > 0 ? right - left + 1 : 0;
    }

    //O(n) stack
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0, left = nums.length -1, right = 0;
        while(i < nums.length) {
            if(stack.isEmpty() || stack.peek() <= nums[i]) {
                stack.push(nums[i]);
            } else {
                while(!stack.isEmpty() && stack.peek() > nums[i]) {
                    stack.pop();
                }
                left = Math.min(stack.size(), left);
                stack.push(nums[i]);
            }
            i++;
        }
        stack.clear();
        i = nums.length-1;
        while(i >= 0) {
            if(stack.isEmpty() || stack.peek() >= nums[i]) {
                stack.push(nums[i]);
            } else {
                while(!stack.isEmpty() && stack.peek() < nums[i]) {
                    stack.pop();
                }
                right = Math.max(right, nums.length - stack.size() -1);
                stack.push(nums[i]);
            }
            i--;
        }
        return right - left + 1 >0 ? right - left + 1 : 0;
    }

    public int findUnsortedSubarrayStack(int[] nums) {
        if(nums.length == 1) return 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0, left = nums.length -1, right = 0;
        while(i < nums.length) {
            while(!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
                left = Math.min(stack.size(), left);
            }
            stack.push(nums[i]);
            i++;
        }
        stack.clear();
        i = nums.length-1;
        while(i >= 0) {
            while(!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
                right = Math.max(right, nums.length - stack.size() -1);
            }
            stack.push(nums[i]);
            i--;
        }
        return right - left + 1 >0 ? right - left + 1 : 0;
    }
}
