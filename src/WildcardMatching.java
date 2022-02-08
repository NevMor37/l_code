/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
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
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 *
 * Constraints:
 *
 * 0 <= s.length, p.length <= 2000
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '?' or '*'.
 *     x ? y * e
 *   t f f f f f
 * x f t f f f f
 * a f f t f f f
 * y f f f t t f
 * l f f f f t f
 * m f f f f t f
 * e f f f f t t
 */
public class WildcardMatching {
    //dynamic programming
    public boolean isMatchDynamicProgramming(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        if(p.length() == 0) return false;
        char [] sChars = s.toCharArray();
        char [] pChars = p.toCharArray();

        int cur = 0;
        boolean firstStar = true;
        for(int i=0; i<pChars.length; i++) {
            if(pChars[i] == '*') {
                if(firstStar) {
                    pChars[cur++] = pChars[i];
                    firstStar = false;
                }
            } else {
                pChars[cur++] = pChars[i];
                firstStar = true;
            }
        }
        //until here cur represents the length of the new patter string we created
        //dp process
        boolean [][] dp = new boolean [s.length() + 1][cur + 1];
        dp[0][0] = true;
        dp[0][1] = pChars[0] == '*';

        for(int i = 1; i<=s.length(); i++) {
            for(int j=1; j<=cur; j++) {
                if(pChars[j-1] == '?' || pChars[j-1] == sChars[i-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else if(pChars[j-1] == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[s.length()][cur];
    }

    Boolean [][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return backtrack(0, 0, s, p);
    }

    public boolean backtrack(int index1, int index2, String s, String p) {
        if(index1 == s.length() && index2 == p.length()) {
            return true;
        }
        if(index1 == s.length()) {
            for(int index = index2;index<p.length();index++){
                if(p.charAt(index)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(index2 == p.length()) return false;
        if(dp[index1][index2] != null) return dp[index1][index2];

        boolean res = false;
        if(p.charAt(index2) == '?' || p.charAt(index2) == s.charAt(index1)) {
            res = backtrack(index1 +1, index2 +1, s, p);
        } else if(p.charAt(index2) == '*') {
            res = backtrack(index1+1, index2+1, s, p) || backtrack(index1+1, index2, s, p) || backtrack(index1, index2+1, s, p);
        }

        dp[index1][index2] = res;
        return res;
    }
}
