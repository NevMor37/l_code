/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int minPrice1 = Integer.MAX_VALUE;
        int minPrice2 = Integer.MAX_VALUE;
        int maxProfit1 = 0;
        int maxProfit2 = 0;
        for(int i = 0; i<prices.length; i++) {
            minPrice1 = Math.min(prices[i], minPrice1);
            maxProfit1 = Math.max(prices[i] - minPrice1, maxProfit1);
            minPrice2 = Math.min(prices[i] - maxProfit1, minPrice2);
            maxProfit2 = Math.max(prices[i] - minPrice2, maxProfit2);
        }
        return maxProfit2;
    }

    //four states
    //buy first max(buy1, -prices[i])
    //sell first max(sell1, buy1 + prices[i])
    //buy second max(buy2, sell1 - prices[i])
    //sell second max(sell2, buy2 + prices[i])
    public int maxProfitDp(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for(int i = 0; i<n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return Math.max(sell1, sell2);
    }
}
