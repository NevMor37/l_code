/**
 *Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 *
 * Return all the possible results. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * Example 2:
 *
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * Example 3:
 *
 * Input: s = ")("
 * Output: [""]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 25
 * s consists of lowercase English letters and parentheses '(' and ')'.
 * There will be at most 20 parentheses in s.
 */
import java.util.*;
public class RemoveInvalidParentheses {
    private Set<String> validExpressions;
    private int minimumRemoved;

    public List<String> removeInvalidParentheses(String s) {
        this.validExpressions = new HashSet<>();
        this.minimumRemoved = Integer.MAX_VALUE;
        backtrack(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList<>(this.validExpressions);
    }

    public void backtrack(String s, int index, int leftCount, int rightCount, StringBuilder expression, int removedCount) {
        if(index == s.length()) {
            if(leftCount == rightCount) {
                if(removedCount <= this.minimumRemoved) {
                    if(removedCount < minimumRemoved) {
                        this.validExpressions.clear();
                        this.minimumRemoved = removedCount;
                    }
                    this.validExpressions.add(expression.toString());
                }
            }
            return;
        }
        // current char is letter
        char cur = s.charAt(index);
        if(Character.isAlphabetic(cur)) {
            expression.append(cur);
            backtrack(s, index+1, leftCount, rightCount, expression, removedCount);
            expression.deleteCharAt(expression.length() - 1);
        } else {
            //remove this char
            backtrack(s, index+1, leftCount, rightCount, expression, removedCount + 1);
            //left and right we process separately
            expression.append(cur);
            if(cur == '(') {
                backtrack(s, index+1, leftCount + 1, rightCount, expression, removedCount);
            } else if(cur == ')' && rightCount < leftCount) {
                backtrack(s, index+1, leftCount, rightCount+1, expression, removedCount);
            }
            expression.deleteCharAt(expression.length() - 1);
        }
    }
}
