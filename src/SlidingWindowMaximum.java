import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 *         1, 3, -1, -3, 5, 3, 6, 7
 * deque:                         7
 *                3   3  5  5  6  7
 *
 *
 *
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //we store the index of each num in the deque to
        //keep track of the number of elements in the deque
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int [] res = new int [len - k + 1];
        for(int i = 0; i<len; i++) {
            if(!deque.isEmpty() && i - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            if(i - k + 1>= 0) {
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
