/**
 * Description
 * Give an integer array，find the longest increasing continuous subsequence in this array.
 *
 * An increasing continuous subsequence:
 *
 * Can be from right to left or from left to right.
 * Indices of the integers in the subsequence should be continuous.
 * Example
 * Example 1:
 *
 * Input: [5, 4, 2, 1, 3]
 * Output: 4
 * Explanation:
 * For [5, 4, 2, 1, 3], the LICS  is [5, 4, 2, 1], return 4.
 * Example 2:
 *
 * Input: [5, 1, 2, 3, 4]
 * Output: 4
 * Explanation:
 * For [5, 1, 2, 3, 4], the LICS  is [1, 2, 3, 4], return 4.
 * Challenge
 * O(n) time and O(1) extra space.
 */
public class LongestContinuousIncreasingSubsequence_397 {
    int max = Integer.MIN_VALUE;
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if(A == null || A.length == 0) return 0;
        if(A.length == 1) return 1;
        int cur = 1;
        for(int i=1; i<A.length; i++) {
            if(A[i] > A[i-1]) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
        }

        cur = 1;
        for(int i=A.length-2; i>=0; i--) {
            if(A[i] > A[i+1]) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
