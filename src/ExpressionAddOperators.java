/**
 * Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-',
 * and/or '*' between the digits of num so that the resultant expression evaluates to the target value.
 *
 * Note that operands in the returned expressions should not contain leading zeros.
 *
 *
 *
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1*2*3","1+2+3"]
 * Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
 * Example 2:
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2","2+3*2"]
 * Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
 * Example 3:
 *
 * Input: num = "3456237490", target = 9191
 * Output: []
 * Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 *
 *
 * Constraints:
 *
 * 1 <= num.length <= 10
 * num consists of only digits.
 * -231 <= target <= 231 - 1
 */
import java.util.*;
public class ExpressionAddOperators {
    public List<String> answer;
    public String digits;
    public long target;
    public List<String> addOperators(String num, int target) {
        this.digits = num;
        this.target = target;
        this.answer = new ArrayList<>();
        backtrack(0, 0, 0, 0, new ArrayList<>());
        return this.answer;
    }
    public void backtrack(int index, long prevOperand, long currentOperand, long value, List<String> ops) {
        String nums = this.digits;
        if(index == nums.length()) {
            if(value == this.target && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                //sublist low inclusive, high exclusive
                ops.subList(1, ops.size()).forEach(l->sb.append(l));
                answer.add(sb.toString());
            }
            return;
        }
        //extending current by one digit
        currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
        String curString = String.valueOf(currentOperand);

        //no op
        if(currentOperand > 0) {
            backtrack(index +1, prevOperand, currentOperand, value, ops);
        }

        //addition
        ops.add("+");
        ops.add(curString);
        backtrack(index+1, currentOperand, 0, value + currentOperand, ops);
        ops.remove(ops.size()-1);
        ops.remove(ops.size()-1);

        if(ops.size() >0) {
            //subtraction
            ops.add("-");
            ops.add(curString);
            backtrack(index+1, -currentOperand, 0, value - currentOperand, ops);
            ops.remove(ops.size()-1);
            ops.remove(ops.size()-1);

            //multiply
            ops.add("*");
            ops.add(curString);
            value = (value - prevOperand) + prevOperand * currentOperand;
            backtrack(index+1, currentOperand * prevOperand, 0, value, ops);
            ops.remove(ops.size()-1);
            ops.remove(ops.size()-1);
        }
    }
}
