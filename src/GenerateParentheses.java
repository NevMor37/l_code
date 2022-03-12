/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
import java.util.*;
public class GenerateParentheses {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n <= 0) return res;
        backtrack(n, 0, 0, "");
        return res;
    }
    public void backtrack(int n, int left, int right, String cur) {
        if(cur.length() == n * 2) {
            res.add(cur);
            return;
        }
        if(left < n) {
            backtrack(n, left + 1, right, cur + "(");
        }
        if(right < left) {
            backtrack(n, left, right + 1, cur + ")");
        }
    }

    public static void main(String [] args) {
        String test = "(";
        test = test.substring(0,test.length()-1);
        System.out.println(test);
    }
}
