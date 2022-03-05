public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length) {
            if(right == 0 || nums[right] != nums[right-1]) {
                nums[left++] = nums[right++];
            }
            while(right < nums.length && nums[right] == nums[right - 1]) right++;
        }
        return left;
    }
}
