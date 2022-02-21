/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {
    int maxLength = 0;
    String res = "";
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i+1);
        }
        return res;
    }

    public void checkPalindrome(String s, int start, int end) {
        while(start >= 0 && end < s.length()) {
            if(s.charAt(start) == s.charAt(end)) {
                int len = end - start +1;
                if(len > this.maxLength) {
                    this.maxLength = len;
                    this.res = s.substring(start, end+1);
                }
                start--;
                end++;
            } else {
                break;
            }
        }
    }
}
