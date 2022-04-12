/**
 * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of
 * each character in this substring is greater than or equal to k.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 105
 */
public class LongestSubstringWitAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        return helper(s, k, 0, s.length()-1);
    }

    public int helper(String s, int k, int start, int end) {
        if(end - start + 1 < k) {
            return 0;
        }
        int [] counts = new int [26];
        for(int i = start; i<=end; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int i = start;
        while(i <= end) {
            char c = s.charAt(i);
            if(counts[c - 'a'] < k) {
                int temp = i;
                while(i < end && counts[s.charAt(i)-'a'] < k) i++;
                return Math.max(helper(s, k, start, temp - 1), helper(s, k, i, end));
            }
            i++;
        }
        return end - start + 1;
    }
}
