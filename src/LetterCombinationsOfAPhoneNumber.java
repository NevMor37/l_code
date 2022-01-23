/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
import java.util.*;
public class LetterCombinationsOfAPhoneNumber {
    String [] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        backtrack(digits, 0, "");
        return res;
    }

    public void backtrack(String digits, int index, String cur) {
        if(index >= digits.length()) {
            res.add(cur);
            return;
        }
        char currentChar = digits.charAt(index);
        char [] chars = letters[currentChar - '0'].toCharArray();
        for(int i=0; i<chars.length; i++) {
            cur += chars[i];
            backtrack(digits, index +1 , cur);
            cur = cur.substring(0, cur.length()-1);
        }
    }
}
