/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 *
 * Stack<Integer> numStack = new Stack<>();
 *         Stack<String> strStack = new Stack<>();
 *         StringBuilder sb = new StringBuilder();
 *         int i = 0;
 *         while(i < s.length()) {
 *             char cur = s.charAt(i);
 *             if(Character.isDigit(cur)) {
 *                 int num = cur - '0';
 *                 while(i < s.length()-1 && Character.isDigit(s.charAt(i+1))) {
 *                     i++;
 *                     num = num * 10 + s.charAt(i) - '0';
 *                 }
 *                 numStack.push(num);
 *             } else if(cur == '[') {
 *                 strStack.push(sb.toString());
 *                 sb = new StringBuilder();
 *             } else if(cur == ']') {
 *                 int repeat = numStack.pop();
 *                 System.out.println(repeat);
 *                 String prev = strStack.pop();
 *                 for(int j=0;j<repeat;j++) {
 *                     prev+=sb.toString();
 *                 }
 *                 sb = new StringBuilder(prev);
 *             } else {
 *                 sb.append(cur);
 *             }
 *             i++;
 *         }
 *         return sb.toString();
 */
import java.util.*;
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while(i + 1< s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                numStack.push(num);
            } else if(Character.isAlphabetic(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '[') {
                strStack.push(sb.toString());
                sb = new StringBuilder();
            } else if(s.charAt(i) == ']') {
                int repeat = numStack.pop();
                StringBuilder temp = new StringBuilder();
                temp.append(strStack.pop());
                for(int j=0; j<repeat; j++) {
                    temp.append(sb);
                }
                sb = temp;
            }
            i++;
        }
        return sb.toString();
    }
}
