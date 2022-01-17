/**
 * Description
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 *
 * Example
 * Example 1:
 *
 * Input:[0,1,3]
 * Output:2
 * Example 2:
 *
 * Input:[1,2,3]
 * Output:0
 * Challenge
 * Do it in-place with O(1) extra memory and O(n) time.
 */
public class MissingNumber_196 {
    public static int findMissing(int[] nums) {
        int originSum = nums.length * (nums.length + 1) /2;
        int sum = 0;
        for(int i : nums) {
            sum+=i;
        }
        return originSum - sum;
    }

    public static void main(String ...argt) {
        int [] test = {9,8,7,6,2,0,1,5,4};
        findMissing(test);
    }
    public static int findMissingXor(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res = res ^ num;
        }
        for(int i=0; i<=nums.length; i++) {
            res = res ^ i ;
        }
        return res;
    }

}
