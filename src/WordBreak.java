/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 *
 * leetcode
 *
 * leet code
 */
import java.util.*;
public class WordBreak {
    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        if(wordDict.size() == 0) return false;
        boolean [] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=0; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] == false) continue;
                String sub = s.substring(j, i);
                if(set.contains(sub)) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        if(wordDict.size() == 0) return false;
        return backtrack(s, set, 0, new Boolean[s.length()]);
    }

    public boolean backtrack(String s, Set<String> wordSet, int index, Boolean [] memo) {
        if(index == s.length()) {
            return true;
        }
        if(memo[index] != null) {
            return memo[index];
        }
        boolean res = false;
        for(int i=index + 1; i<=s.length(); i++) {
            String sub = s.substring(index, i);
            if(wordSet.contains(sub)) {
                if(backtrack(s, wordSet, i, memo)) {
                    res = true;
                    break;
                }
            }
        }
        memo[index] = res;
        return res;
    }
}
