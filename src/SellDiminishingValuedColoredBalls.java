import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You have an inventory of different colored balls, and there is a customer that wants orders balls of any color.
 *
 * The customer weirdly values the colored balls. Each colored ball's value is the number of balls of that color you currently have in your inventory. For example, if you own 6 yellow balls, the customer would pay 6 for the first yellow ball. After the transaction, there are only 5 yellow balls left, so the next yellow ball is then valued at 5 (i.e., the value of the balls decreases as you sell more to the customer).
 *
 * You are given an integer array, inventory, where inventory[i] represents the number of balls of the ith color that you initially own. You are also given an integer orders,
 * which represents the total number of balls that the customer wants. You can sell the balls in any order.
 *
 * Return the maximum total value that you can attain after selling orders colored balls. As the answer may be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: inventory = [2,5], orders = 4
 * Output: 14
 * Explanation: Sell the 1st color 1 time (2) and the 2nd color 3 times (5 + 4 + 3).
 * The maximum total value is 2 + 5 + 4 + 3 = 14.
 * Example 2:
 *
 * Input: inventory = [3,5], orders = 6
 * Output: 19
 * Explanation: Sell the 1st color 2 times (3 + 2) and the 2nd color 4 times (5 + 4 + 3 + 2).
 * The maximum total value is 3 + 2 + 5 + 4 + 3 + 2 = 19.
 *
 *
 * Constraints:
 *
 * 1 <= inventory.length <= 105
 * 1 <= inventory[i] <= 109
 * 1 <= orders <= min(sum(inventory[i]), 109)
 *
 * 1 3 5 5 9 9 9
 * 1 3 5 5 5 5 5   (9 + 6) * (9 -5)/2 * 3
 * 1 3 3 3 3 3 3   (5 + 4) * (5 -3)/2 * 5
 * 1 1 1 1 1 1 1   (3 + 2) * 2/2 * 6
 * 0 0 0 0 0 0 0   (1 + 1) * 1/2 * 7
 */
public class SellDiminishingValuedColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        long res = 0;
        int mod = 1000000007;
        Arrays.sort(inventory);
        int curIndex = inventory.length-1;
        int curValue = inventory[curIndex];
        while(orders > 0) {
            while(curIndex >= 0 && inventory[curIndex] == curValue) {
                curIndex--;
            }
            int length = inventory.length - 1 - curIndex;
            int nextValue = curIndex < 0 ? 0 : inventory[curIndex];
            int nums = (curValue - nextValue) * length;
            long val = 0;
            if(orders >= nums) {
                val = (long)(curValue + nextValue + 1) * (curValue - nextValue)/2 * length;
            } else {
                int numFullDecrement = orders/length;
                int remaining = orders%length;
                val = (long)(curValue - numFullDecrement + 1 + curValue) * numFullDecrement/2 * length;
                //剩下的remaining 每个减一， 当前value * remaining（数量）
                val+= (long)(curValue - numFullDecrement) * remaining;
            }
            curValue = nextValue;
            orders -= nums;
            res = (res + val)%mod;
        }
        return (int)res;
    }
}
