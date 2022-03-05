/**
 *
 * public boolean checkValidString(String s) {
 *         return backtrack(s, 0, 0, 0);
 *     }
 *
 *     public boolean backtrack(String s, int left, int right, int index) {
 *         if(index == s.length()) {
 *             return left == right;
 *         }
 *         if(right > left) return false;
 *         char cur = s.charAt(index);
 *         if(cur == '(') {
 *             return backtrack(s, left + 1, right, index + 1);
 *         }else if(cur == ')') {
 *             return backtrack(s, left, right +1, index +1);
 *         } else {
 *             return backtrack(s, left + 1, right, index + 1) ||
 *                     backtrack(s, left, right +1 , index+1) ||
 *                     backtrack(s, left, right, index +1);
 *         }
 *     }
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "(*)"
 * Output: true
 * Example 3:
 *
 * Input: s = "(*))"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s[i] is '(', ')' or '*'.
 *
 *
 */
public class ValidParenthesisString {
    Boolean [][][] dp;
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length()][s.length()];
        return backtrack(s, 0, 0, 0);
    }

    public boolean backtrack(String s, int left, int right, int index) {
        if(index == s.length()) {
            return left == right;
        }
        if(right > left) return false;
        if(dp[left][right][index] != null) {
            return dp[left][right][index];
        }
        char cur = s.charAt(index);
        boolean res = false;
        if(cur == '(') {
            res= backtrack(s, left + 1, right, index + 1);
        }else if(cur == ')') {
            res= backtrack(s, left, right +1, index +1);
        } else {
            res= backtrack(s, left + 1, right, index + 1) ||
                    backtrack(s, left, right +1 , index+1) ||
                    backtrack(s, left, right, index +1);
        }
        dp[left][right][index] = res;
        return res;
    }
}
