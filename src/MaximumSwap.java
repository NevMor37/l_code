/**
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 *
 * Return the maximum valued number you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 *
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 *
 *
 * Constraints:
 *
 * 0 <= num <= 108
 */
import java.util.*;
public class MaximumSwap {
    public int maximumSwap(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        char [] numChars = String.valueOf(num).toCharArray();
        for(int i=0;i<numChars.length; i++) {
            map.put(numChars[i] - '0', i);
        }
        for(int i=0; i<numChars.length; i++) {
            char c = numChars[i];
            for(int j=9; j>=0; j--) {
                if(map.containsKey(j) && j > c - '0') {
                    if(map.get(j) > i) {
                        numChars[map.get(j)] = numChars[i];
                        numChars[i] = (char)(j + '0');
                        return Integer.valueOf(new String(numChars));
                    }
                }
            }
        }
        return num;
    }

    public static void main(String ...args) {
        System.out.println("123");
        System.out.println((char)3);
    }
}
