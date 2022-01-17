import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class WordBreakII {

    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        Set<String> wordDictSet = new HashSet<>(wordDict);
        backtrack(s, wordDictSet, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(String s, Set<String> wordDict, int index, List<String> list) {
        List<String> res = new ArrayList<>();
        if(index >= s.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<list.size(); i++) {
                sb.append(list.get(i));
                if(i != list.size() -1) {
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
        }

        for(int i=index; i<s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if(wordDict.contains(sub)) {
                list.add(sub);
                backtrack(s, wordDict, i+1, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String [] args) {

    }
}
