import java.util.HashMap;

/**
 * Let's define a function countUniqueChars(s) that returns the number of unique characters on s.
 *
 * For example, calling countUniqueChars(s) if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.
 * Given a string s, return the sum of countUniqueChars(t) where t is a substring of s.
 *
 * Notice that some substrings can be repeated so in this case you have to count the repeated ones too.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABC"
 * Output: 10
 * Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
 * Evey substring is composed with only unique letters.
 * Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
 * Example 2:
 *
 * Input: s = "ABA"
 * Output: 8
 * Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
 * Example 3:
 *
 * Input: s = "LEETCODE"
 * Output: 92
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of uppercase English letters only.
 */
import java.util.*;
public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public static int uniqueLetterString(String s) {
        int [] left = new int [s.length()];
        int [] right = new int [s.length()];
        left[0] = -1;
        right[s.length()-1] = s.length();
        Map<Character, Integer> map = new HashMap<>();
        char [] chars = s.toCharArray();
        for(int i = 0; i<chars.length; i++) {
            char c = chars[i];
            if(!map.containsKey(c)) {
                left[i] = -1;
            } else {
                left[i] = map.get(c);
            }
            map.put(c, i);
        }
        map.clear();
        for(int i = chars.length-1; i>=0; i--) {
            char c = chars[i];
            if(!map.containsKey(c)) {
                right[i] = chars.length;
            } else {
                right[i] = map.get(c);
            }
            map.put(c, i);
        }
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            res += (i - left[i]) * (right[i] - i);
        }
        return res;
    }

    public static void main(String [] args) {
        String test = "ABC";
        String test1 = "ABA";
        uniqueLetterString(test1);
    }
}
