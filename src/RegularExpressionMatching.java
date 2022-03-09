import java.util.Locale;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 *
 *
 * DP: T[i-1][j-1]  if str[i] == patter[j] || pattern[j] == '.'
 *
 *      T[i][j-2]   -> 0 occurance of the character before * in the patter
 *
 *     T[i-1][j] if str[i] == patern[j-1] || pattern[j-1] == '.'
 *     in this case, we take current str[i] as part of the occurance of the character before the * occurance
 *
 *     so we check patter[j-1] equals str[i] || pattern [j-1] == '.'
 *     then we pass the value down from the dp[i-1][j]
 *
 *
 *
 *
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char [] str = s.toCharArray();
        char [] pattern=  p.toCharArray();
        boolean [][] dp = new boolean [s.length() + 1][p.length() + 1];
        //when pattern and str both ""
        dp[0][0] = true;

        for(int i=1; i<pattern.length; i++) {
            if(pattern[i] == '*') {
                dp[0][i+1] = dp[0][i-1];
            }
        }

        for(int i=1; i<=s.length(); i++) {
            for(int j = 1; j<=p.length(); j++) {
                if(pattern[j-1] == '.' || pattern[j-1] == str[i-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern[j-1] == '*') {
                    boolean temp = dp[i][j-2];
                    if(pattern[j-2] == '.' || pattern[j-2] == str[i-1]) {
                        temp = temp || dp[i-1][j];
                    }
                    dp[i][j] = temp;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
