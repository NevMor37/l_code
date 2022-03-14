/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 * Example 3:
 *
 * Input: n = 1
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= n <= 5 * 106
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean [] arr = new boolean [n + 1];
        arr[0] = true;
        arr[1] = true;
        for(int i = 2; i * i <= n; i++) {
            if(!arr[i]) {
                for(int j = 2; j * i <= n; j++) {
                    arr[j * i] = true;
                }
            }
        }
        int count = 0;
        for(int i = 0; i<n; i++) {
            if(!arr[i]) count++;
        }
        return count;
    }
}
