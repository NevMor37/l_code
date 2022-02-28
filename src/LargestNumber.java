/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
import java.util.*;
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String [] copy = new String [nums.length];
        for(int i=0; i<nums.length; i++) {
            copy[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String a, String b) {
                String a1 = a + b;
                String a2 = b + a;
                return -a1.compareTo(a2);
            }
        };

        Arrays.sort(copy, comparator);
        String res = "";
        if(Integer.valueOf(copy[0]) == 0) return "0";
        for(String str : copy) res+=str;
        return res;
    }
}
