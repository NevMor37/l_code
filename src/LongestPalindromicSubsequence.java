/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 */
public class LongestPalindromicSubsequence {
    Integer [][] memo;
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 1) return 1;
        memo = new Integer[s.length()][s.length()];
        return backtrack(0, s.length()-1, s);
    }

    public int backtrack(int start, int end, String s) {
        if(start > end) return 0;
        if(start == end) return 1;
        int res;
        if(s.charAt(start) == s.charAt(end)) {
            res = 2 + backtrack(start +1, end -1, s);
        } else if(memo[start][end] != null) {
            return memo[start][end];
        } else {
            res = Math.max(backtrack(start+1, end, s), backtrack(start, end-1, s));
        }
        memo[start][end] = res;
        return res;
    }

    public int longestPalindromeSubseqDP(String s) {
        int [][] dp = new int [s.length()][s.length()];
        for(int i = s.length()-1; i>=0;i--) {
            dp[i][i] = 1;
            for(int j = i+1; j<s.length(); j++) {
                if(s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
