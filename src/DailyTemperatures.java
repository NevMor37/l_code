/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
import java.util.*;
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int [0];
        int [] res = new int [temperatures.length];
        Stack<int []> stack = new Stack<>();
        for(int i = 0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int [] temp = stack.pop();
                res[temp[0]] = i - temp[0];
            }
            stack.push(new int [] {i, temperatures[i]});
        }
        return res;
    }
}
