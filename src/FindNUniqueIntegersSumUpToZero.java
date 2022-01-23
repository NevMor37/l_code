/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 */
public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int res [] = new int [n];
        int length = n % 2 == 0 ? n : n-1;
        int max = 2000, i = 0;
        while(i < length) {
            res[i] = max;
            res[i+1] = -max;
            i+=2;
            max-=1;
        }
        return res;
    }
}
