/**
 * Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: data = [1,0,1,0,1]
 * Output: 1
 * Explanation: There are 3 ways to group all 1's together:
 * [1,1,1,0,0] using 1 swap.
 * [0,1,1,1,0] using 2 swaps.
 * [0,0,1,1,1] using 1 swap.
 * The minimum is 1.
 * Example 2:
 *
 * Input: data = [0,0,0,1,0]
 * Output: 0
 * Explanation: Since there is only one 1 in the array, no swaps are needed.
 * Example 3:
 *
 * Input: data = [1,0,1,0,1,0,0,1,1,0,1]
 * Output: 3
 * Explanation: One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
 *
 *
 * Constraints:
 *
 * 1 <= data.length <= 105
 * data[i] is either 0 or 1.
 */
public class MinimumSwapsToGroupAll1sTogether {
    public static int minSwaps(int[] data) {
        int count1 = 0, res = 0, count0 = 0;
        for(int i:data) {
            count1+=i;
        }
        for(int i=0; i<count1; i++) {
            if(data[i] == 0) {
                count0++;
            }
        }
        res = count0;
        int start =0, end = count1-1;
        while(end < data.length-1) {
            if(data[++end] == 0) {
                count0++;
            }
            if(data[start++] == 0) count0--;
            res = Math.min(res, count0);
        }
        return res;
    }
    public static void main(String [] args) {
        int [] test = {1,0,1,0,1};
        minSwaps(test);
    }
}
