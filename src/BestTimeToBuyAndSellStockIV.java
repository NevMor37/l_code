import java.util.Arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 *
 * Constraints:
 *
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 1 || k < 1) return 0;
        int n = prices.length;
        int res = 0;
        if(k >= n/2) {
            int i = 0;
            while(i < n) {
                while(i < n - 1 && prices[i] >= prices[i+1]) i++;
                int vally = i;
                while(i < n - 1 && prices[i] <= prices[i + 1]) i++;
                int peak = i;
                res += prices[peak] - prices[vally];
                i++;
            }
            return res;
        }
        int [] buy = new int[k];
        int [] sell = new int [k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for(int i = 0; i< n; i++) {
            for(int j = 0; j<k; j++) {
                buy[j] = Math.max(buy[j], j == 0 ? -prices[i] : sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k-1];
    }
}
