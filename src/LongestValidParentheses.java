/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
import java.util.*;
public class LongestValidParentheses {
    public int longestValidParenthesesDP(String s) {
        int [] dp = new int [s.length()];
        int res = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(i > 0 && s.charAt(i-1) == '(') {
                    dp[i] = (i >=2 ? dp[i-2] : 0) + 2;
                } else if(i > 0 && i - dp[i-1] > 0 && s.charAt(i - dp[i-1] -1) == '(') {
                    dp[i] = (i - dp[i-1] >= 2 ? dp[i-dp[i-1] -2] : 0)  + dp[i-1] + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public int longestValidParenthesesStack(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            if(s.charAt(i) == ')') {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                   res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public int longestValidParenthesesTwoPass(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
