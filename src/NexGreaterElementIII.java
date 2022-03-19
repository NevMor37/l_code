/**
 * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
 *
 * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 21
 * Example 2:
 *
 * Input: n = 21
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 */
import com.sun.jdi.ArrayReference;

import java.util.*;
public class NexGreaterElementIII {
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            int temp = n % 10;
            list.add(0, temp);
            n= n/10;
        }
        int [] nums = list.stream().mapToInt(a -> a).toArray();
        if(nums.length > 10) return -1;
        for(int i = nums.length - 2; i>=0 ;i--) {
            if(nums[i] < nums[i + 1]) {
                for(int j = nums.length - 1; j >i; j--) {
                    if(nums[j] > nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        reverse(nums, i + 1, nums.length-1);
                        long res = 0;
                        for(int k = 0; k <nums.length; k++) {
                            res = res * 10 + nums[k];

                        }
                        if(res > Integer.MAX_VALUE) return -1;
                        return (int)res;
                    }
                }
            }
        }
        return -1;
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

    public static void main(String ...args) {
        //nextGreaterElement(1234234235);
        System.out.println(Integer.MAX_VALUE);
    }
}
