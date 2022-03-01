/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * public int calculate(String s) {
 *         s = s.replaceAll(" ", "");
 *         char sign = '+';
 *         char [] chars = s.toCharArray();
 *         Stack<Integer> stack = new Stack();
 *         int i = 0;
 *         while(i < s.length()) {
 *             char cur = chars[i];
 *             int val = 0;
 *             if(Character.isDigit(cur)) {
 *                 val += cur - '0';
 *                 while(i + 1 <s.length() && Character.isDigit(chars[i+1])) {
 *                     i++;
 *                     val = val * 10 + (chars[i] - '0');
 *                 }
 *                 if(sign == '+') {
 *                     stack.push(val);
 *                 } else if(sign == '-') {
 *                     stack.push(-val);
 *                 } else if(sign == '*') {
 *                     stack.push(stack.pop() * val);
 *                 } else {
 *                     stack.push(stack.pop()/val);
 *                 }
 *             } else {
 *                 sign = cur;
 *             }
 *             i++;
 *         }
 *         int res = 0;
 *         for(int sub : stack) res += sub;
 *         return res;
 *     }
 */
import java.util.*;
public class BasicCalculatorII {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<>();
        int i = 0, res = 0, ini = 0;
        char sign = '+';
        char [] sch = s.toCharArray();
        while(i<sch.length) {
            while(i<sch.length && Character.isDigit(sch[i])) {
                ini = ini * 10 + sch[i]-'0';
                i++;
            }
            if(sign == '+') {
                stack.push(ini);
            } else if(sign == '-') {
                stack.push(ini * -1);
            } else if(sign == '/') {
                stack.push(stack.pop()/ini);
            } else if(sign == '*') {
                stack.push(stack.pop() * ini);
            }
            ini = 0;
            if(i <sch.length) {
               sign = sch[i];
            }
            i++;
        }
        for(int k : stack) {
            res+=k;
        }
        return res;
    }

    public static void main(String [] args) {
        BasicCalculatorII bc = new BasicCalculatorII();
        String test = " 3+5 / 2 ";
        System.out.println(bc.calculate(test));
    }
}
