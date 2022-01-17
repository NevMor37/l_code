/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */
public class PowXN {

    public double myPowStackOverFlow(double x, int n) {
        if(n == 0) return 1;
        return x * myPowStackOverFlow(x, n-1);
    }

    //divide and conquer
    public double myPow(double x, int n) {
        long nn = n;
        if(n < 0) {
            x = 1/x;
            nn = -nn;
        }
        return helper(x, nn);
    }

    //log(n) time complexity
    public double helper(double x, long n) {
        if(x == 0) return 0;
        if(n ==0) return 1;
        double res = helper(x, n/2);
        res = res * res * (n % 2 == 0 ? 1 : x);
        return res;
    }
}
