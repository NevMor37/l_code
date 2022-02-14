import java.util.*;
/**
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation:
 * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Sum is 17.
 * Example 2:
 *
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 */
public class SumOfSubarryMinimums_Monotous_Stack {
    public static int sumSubarrayMins(int[] arr) {
        long res = 0;
        Stack<int []> stack = new Stack<>();
        int [] left = new int [arr.length];
        int [] right = new int [arr.length];

        for(int i=0; i<arr.length; i++) {
            int count = 1;
            while(!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                count+=stack.peek()[1];
                stack.pop();
            }
            int [] temp = new int [] {arr[i], count};
            stack.push(temp);
            left[i] = count;
        }
        stack.clear();
        for(int i=arr.length-1; i>=0; i--) {
            int count = 1;
            while(!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                count+=stack.peek()[1];
                stack.pop();
            }
            int [] temp = new int [] {arr[i], count};
            stack.push(temp);
            right[i] = count;
        }
        for(int i=0; i<arr.length; i++) {
            res = (res + (long)arr[i] * left[i] * right[i]) % 100000007;
        }
        return (int)res;
    }
    public static void main(String [] args) {
        int [] test = {3,1,2,4};
        int [] test2 = {71,55,82,55};
        int [] test3 = {1,2,1};
        sumSubarrayMins(test3);
    }
}
