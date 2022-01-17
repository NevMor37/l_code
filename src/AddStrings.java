/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        String num1R = new StringBuilder(num1).reverse().toString();
        String num2R = new StringBuilder(num2).reverse().toString();
        StringBuilder res = new StringBuilder();
        int inc = 0, length = Math.max(num1.length(), num2.length());
        for(int i=0; i<length; i++) {
            int val1 = i < num1R.length() ? num1R.charAt(i) - '0' : 0;
            int val2 = i < num2R.length() ? num2R.charAt(i) - '0' : 0;
            int temp = val1 + val2 + inc;
            res.append(temp%10);
            inc = temp/10;
        }
        if(inc != 0) {
            res.append(inc);
        }
        return res.reverse().toString();
    }

    public static void main(String [] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("77", "456"));
    }
}
