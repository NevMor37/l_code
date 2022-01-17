/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * 123456879
 * 123456897
 * 123456987
 * 123457689
 * 123457698
 * 123457869
 *
 *
 * 123456789
 * 123456798
 * 123456879
 * 987654321
 * looking from backwards
 * find nums[i] > nums[i-1]
 * swap(nums[i-1], min())
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {

        for(int i = nums.length-1; i>0; i--) {
            if(nums[i] > nums[i-1]) {
                //swap i-1 with the "next largest value"
                //then reverse the array from i
                for(int j=nums.length-1; j >=i; j--) {
                    if(nums[j] > nums[i-1]) {
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        break;
                    }
                }
                reverse(nums, i, nums.length-1);
                return;
            }
        }
        reverse(nums, 0, nums.length-1);
        return;
    }
    public void reverse(int [] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
