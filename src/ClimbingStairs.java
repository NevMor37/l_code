/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
import java.util.*;
public class ClimbingStairs {
    public int climbStairsDP(int n) {
        int [] dp = new int [50];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if(n ==0) return 1;
        if(n == 1) return 1;
        if(map.containsKey(n)) return map.get(n);
        int oneStep = climbStairs(n-1);
        int twoSetp = climbStairs(n-2);
        int res = oneStep + twoSetp;
        map.put(n, res);
        return res;
    }
}
