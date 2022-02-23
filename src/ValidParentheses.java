/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
import java.util.*;
public class ValidParentheses {
    public boolean isValid(String s) {
        char [] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : chars) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(stack.isEmpty()) {
                return false;
            } else if(c == ')') {
                if (stack.pop() != '(') return false;
            } else if(c == '}') {
                if(stack.pop() != '{') return false;
            } else if(c == ']') {
                if(stack.pop() != '[') return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
