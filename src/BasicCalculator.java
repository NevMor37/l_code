import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 */
public class BasicCalculator {
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        char [] chars = s.toCharArray();
        int res = 0, i = 0;
        int sign = 1;
        while(i < chars.length) {
            if(Character.isDigit(chars[i])) {
                int base = chars[i] - '0';
                while(i < chars.length-1 && Character.isDigit(chars[i + 1])) {
                    base = base * 10 + chars[i+1] - '0';
                    i++;
                }
                res += base * sign;
            } else if(chars[i] == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if(chars[i] == ')') {
                //multiply with sign
                res *= stack.pop();
                res += stack.pop();
            } else if(chars[i] == '+') {
                sign = 1;
            } else if(chars[i] == '-'){
                sign = -1;
            }
            i++;
        }
        return res;
    }
}
